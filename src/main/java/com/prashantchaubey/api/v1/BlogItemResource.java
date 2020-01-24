package com.prashantchaubey.api.v1;

import com.prashantchaubey.entities.BlogItem;
import com.prashantchaubey.entities.BlogTag;
import com.prashantchaubey.repositories.BlogItemRepository;
import com.prashantchaubey.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created By: Prashant Chaubey
 * Created On: 24-01-2020 22:54
 **/
@RestController
@RequestMapping(Constants.Resource.BLOG_ITEM)
public class BlogItemResource {
    private final BlogItemRepository repository;

    @Autowired
    public BlogItemResource(BlogItemRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public BlogItem addBlogItem(@Valid @RequestBody BlogItem blogItem, Principal principal) {
        return null;
    }

    @PatchMapping("/{blog_item_id}/add_tag")
    public void addBlogTag(@PathVariable("blog_item_id") long blog_item_id, @Valid @RequestBody BlogTag blogTag, Principal principal) {

    }

    @PatchMapping("/{blog_item_id}/remove_tag")
    public void removeBlogTag(@PathVariable("blog_item_id") long blog_item_id, @Valid @RequestBody BlogTag blogTag, Principal principal) {

    }
}
