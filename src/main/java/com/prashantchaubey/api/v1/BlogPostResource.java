package com.prashantchaubey.api.v1;

import com.prashantchaubey.caches.BlogPostCache;
import com.prashantchaubey.dto.mappers.BlogPostMapper;
import com.prashantchaubey.dto.responses.BlogPostResponse;
import com.prashantchaubey.dto.responses.BlogPostWithContentResponse;
import com.prashantchaubey.entities.BlogPost;
import com.prashantchaubey.exceptions.BadDataException;
import com.prashantchaubey.exceptions.ResourceNotFoundException;
import com.prashantchaubey.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(Constants.Endpoint.BLOG_POSTS_V1)
public class BlogPostResource {
  private static final Map<String, Integer> THREE_LETTER_MONTH_NAMES_TO_MONTH_NO =
      new HashMap<>() {
        {
          put("jan", 1);
          put("feb", 2);
          put("mar", 3);
          put("apr", 4);
          put("may", 5);
          put("jun", 6);
          put("jul", 7);
          put("aug", 8);
          put("sep", 9);
          put("oct", 10);
          put("nov", 11);
          put("dec", 12);
        }
      };
  private final BlogPostCache blogPostCache;
  private final BlogPostMapper blogPostMapper;

  @Autowired
  public BlogPostResource(BlogPostCache blogPostCache, BlogPostMapper blogPostMapper) {
    this.blogPostCache = blogPostCache;
    this.blogPostMapper = blogPostMapper;
  }

  @GetMapping
  public Page<BlogPostResponse> getAll(Pageable pageable) {
    return blogPostCache.findAll(pageable).map(blogPostMapper::toBlogPostResponse);
  }

  @GetMapping("/year/{year}")
  public Page<BlogPostResponse> getByYear(@PathVariable("year") String yearStr, Pageable pageable) {
    Optional<Integer> maybeYear = getYear(yearStr);
    if (!maybeYear.isPresent()) {
      throw new BadDataException(String.format("%s is not a valid year", yearStr));
    }
    int year = maybeYear.get();
    LocalDateTime firstMinuteOfYear = LocalDateTime.of(year, Month.JANUARY, 1, 0, 0);
    LocalDateTime lastMinuteOfYear = firstMinuteOfYear.plus(Period.ofYears(1));

    return blogPostCache
        .findByYearCreatedAtBetween(firstMinuteOfYear, lastMinuteOfYear, pageable)
        .map(blogPostMapper::toBlogPostResponse);
  }

  @GetMapping("/year/{year}/month/{month}")
  public Page<BlogPostResponse> getByMonthYear(
      @PathVariable("year") String yearStr,
      @PathVariable("month") String monthStr,
      Pageable pageable) {
    Optional<Integer> maybeYear = getYear(yearStr);
    if (!maybeYear.isPresent()) {
      throw new BadDataException(String.format("%s is not a valid year", yearStr));
    }
    Optional<Integer> maybeMonth = getMonth(monthStr);
    if (!maybeMonth.isPresent()) {
      throw new BadDataException(String.format("%s is not a valid month", monthStr));
    }
    int year = maybeYear.get();
    int month = maybeMonth.get();
    LocalDateTime firstMinuteOfMonth = LocalDateTime.of(year, month, 1, 0, 0);
    LocalDateTime lastMinuteOfMonth = firstMinuteOfMonth.plus(Period.ofMonths(1));

    return blogPostCache
        .findByYearCreatedAtBetween(firstMinuteOfMonth, lastMinuteOfMonth, pageable)
        .map(blogPostMapper::toBlogPostResponse);
  }

  @GetMapping("/search/{searchText}")
  public Page<BlogPostResponse> search(
      @PathVariable("searchText") String searchText, Pageable pageable) {
    return blogPostCache
        .findByHeadingContaining(searchText, pageable)
        .map(blogPostMapper::toBlogPostResponse);
  }

  @GetMapping("/{blogPostName}")
  public BlogPostWithContentResponse getByName(@PathVariable("blogPostName") String blogPostName) {
    BlogPost blogPost = blogPostCache.findByName(blogPostName);
    if (blogPost == null) {
      throw new ResourceNotFoundException(
          String.format("Blog post with name: %s is not found", blogPostName));
    }

    return blogPostMapper.toBlogPostWithContentResponse(blogPost);
  }

  @GetMapping("/blog-tags/{blogTagName}")
  public Page<BlogPostResponse> getByTagName(
      @PathVariable("blogTagName") String blogTagName, Pageable pageable) {
    return blogPostCache
        .findByTagName(blogTagName, pageable)
        .map(blogPostMapper::toBlogPostResponse);
  }

  private Optional<Integer> getYear(String yearStr) {
    if (yearStr.length() != 4) {
      return Optional.empty();
    }

    try {
      return Optional.of(Integer.valueOf(yearStr));
    } catch (NumberFormatException e) {
      return Optional.empty();
    }
  }

  private Optional<Integer> getMonth(String monthStr) {
    return Optional.ofNullable(THREE_LETTER_MONTH_NAMES_TO_MONTH_NO.get(monthStr.toLowerCase()));
  }
}
