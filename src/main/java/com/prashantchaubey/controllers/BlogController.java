package com.prashantchaubey.controllers;

import com.prashantchaubey.entities.BlogItem;
import com.prashantchaubey.entities.BlogTag;
import com.prashantchaubey.repositories.BlogItemRepository;
import com.prashantchaubey.repositories.BlogTagRepository;
import com.prashantchaubey.utils.BlogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Control the blog page of the website
 * Created By: Prashant Chaubey
 * Created On: 02-09-2018 04:22
 **/
@Controller
@RequestMapping("/blog")
public class BlogController {
    private BlogTagRepository blogTagRepository;
    private BlogItemRepository blogItemRepository;

    @Autowired
    public BlogController(BlogItemRepository blogItemRepository, BlogTagRepository blogTagRepository) {
        this.blogItemRepository = blogItemRepository;
        this.blogTagRepository = blogTagRepository;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);

    @GetMapping
    public String blog(Model model) {
        List<BlogItem> blogItems = blogItemRepository.findBlogItemsByOrderByTimestampDesc();
        // If there is no description create one from content.
        blogItems.forEach(BlogUtils::checkAndFillDescriptionIfNot);
        LOGGER.debug("blogItems:" + blogItems.size());
        addBlogsAndTagsToModel(model, getAllTags(), blogItems);
        return "blog";
    }

    @GetMapping(value = "/month/{month_year}")
    public String blogsByMonthAndYear(@PathVariable(value = "month_year") String monthYear, Model model) {
        LOGGER.debug("Getting blogs for:" + monthYear);
        List<BlogItem> blogItems = blogItemRepository.findBlogItemsByMonthsAndYear(monthYear);
        // If there is no description create one from content.
        blogItems.forEach(BlogUtils::checkAndFillDescriptionIfNot);
        addBlogsAndTagsToModel(model, getAllTags(), blogItems);
        return "blog";
    }

    @GetMapping(value = "/year/{year}")
    public String blogsByYear(@PathVariable(value = "year") String year, Model model) {
        LOGGER.debug("Getting blogs for:" + year);
        List<BlogItem> blogItems = blogItemRepository.findBlogItemsByYear(year);
        // If there is no description create one from content.
        blogItems.forEach(BlogUtils::checkAndFillDescriptionIfNot);
        addBlogsAndTagsToModel(model, getAllTags(), blogItems);
        return "blog";
    }

    @GetMapping(value = "/tag/{tag_id}")
    public String blogsByTag(@PathVariable(value = "tag_id") String tagId, Model model) {
        LOGGER.debug("Getting blogs for:" + tagId);
        BlogTag blogTag = blogTagRepository.findBlogTagById(Long.parseLong(tagId));
        addBlogsAndTagsToModel(model, getAllTags(), blogTag.getBlogItems());
        return "blog";
    }


    @GetMapping(value = "/search/")
    public String blogsBySearchText(@RequestParam("search_text") String searchText, Model model) {
        LOGGER.debug("Getting blogs for:" + searchText);
        List<BlogItem> blogItems = blogItemRepository.findBlogItemsByHeadingContaining(searchText);
        // If there is no description create one from content.
        blogItems.forEach(BlogUtils::checkAndFillDescriptionIfNot);
        addBlogsAndTagsToModel(model, getAllTags(), blogItems);
        return "blog";
    }

    @GetMapping(value = "/single/{blog_id}")
    public String singleBlog(@PathVariable("blog_id") String blogId, Model model) {
        LOGGER.debug("Getting blog for id:" + blogId);
        BlogItem blogItem = blogItemRepository.findBlogItemById(Long.parseLong(blogId));
        BlogUtils.checkAndFillDescriptionIfNot(blogItem);
        model.addAttribute("blogItem", blogItem);
        return "blog_single";
    }

    private List<BlogTag> getAllTags() {
        List<BlogTag> blogTags = blogTagRepository.findAll();
        LOGGER.debug("blogTags:" + blogTags.size());
        return blogTags;
    }

    private void addBlogsAndTagsToModel(Model model, Collection<BlogTag> blogTags, Collection<BlogItem> blogItems) {
        model.addAttribute("blogTags", blogTags);
        model.addAttribute("blogItems", blogItems);
    }


}
