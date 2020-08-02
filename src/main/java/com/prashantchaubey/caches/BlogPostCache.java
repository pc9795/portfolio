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

    public Page<BlogPost> findByOrderByCreatedAtDesc(Pageable pageable) {
        return blogPostRepository.findByOrderByCreatedAtDesc(pageable);
    }

    public Page<BlogPost> findByMonthsAndYear(String monthYear, Pageable pageable) {
        return blogPostRepository.findByMonthsAndYear(monthYear, pageable);
    }

    public Page<BlogPost> findByYear(String year, Pageable pageable) {
        return blogPostRepository.findByYear(year, pageable);
    }

    public Page<BlogPost> findByHeadingContaining(String searchText, Pageable pageable) {
        return blogPostRepository.findByHeadingContaining(searchText, pageable);
    }

    public BlogPost findByName(String name) {
        return blogPostRepository.findByName(name);
    }
}
