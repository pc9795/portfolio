package com.prashantchaubey.caches;

import com.prashantchaubey.entities.BlogPost;
import com.prashantchaubey.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class BlogPostCache {
    private BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostCache(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public Page<BlogPost> findBlogItemsByOrderByCreatedAtDesc(Pageable pageable) {
        return blogPostRepository.findBlogItemsByOrderByCreatedAtDesc(pageable);
    }

    public Page<BlogPost> findBlogItemsByMonthsAndYear(String monthYear, Pageable pageable) {
        return blogPostRepository.findBlogItemsByMonthsAndYear(monthYear, pageable);
    }

    public Page<BlogPost> findBlogItemsByYear(String year, Pageable pageable) {
        return blogPostRepository.findBlogItemsByYear(year, pageable);
    }

    public Page<BlogPost> findBlogItemsByHeadingContaining(String searchText, Pageable pageable) {
        return blogPostRepository.findBlogItemsByHeadingContaining(searchText, pageable);
    }

    public BlogPost findBlogItemById(long id) {
        return blogPostRepository.findBlogItemById(id);
    }
}
