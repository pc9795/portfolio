package com.prashantchaubey.api.v1;

import com.prashantchaubey.entities.BlogItem;
import com.prashantchaubey.entities.BlogTag;
import com.prashantchaubey.exceptions.BadDataException;
import com.prashantchaubey.exceptions.ResourceNotFoundException;
import com.prashantchaubey.repositories.jpa.BlogItemRepository;
import com.prashantchaubey.repositories.jpa.BlogTagRepository;
import com.prashantchaubey.utils.Constants;
import com.prashantchaubey.utils.Utils;
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
    private final BlogItemRepository blogItemRepository;
    private final BlogTagRepository blogTagRepository;

    @Autowired
    public BlogItemResource(BlogItemRepository blogItemRepository, BlogTagRepository blogTagRepository) {
        this.blogItemRepository = blogItemRepository;
        this.blogTagRepository = blogTagRepository;
    }

    /**
     * Create a new blog item
     *
     * @param blogItem  blog item input data
     * @param principal authenticated user
     * @return created blog item
     */
    @PostMapping
    public BlogItem addBlogItem(@Valid @RequestBody BlogItem blogItem, Principal principal) {
        blogItem.setCreatedBy(principal.getName());
        Utils.checkAndFillDescriptionIfNot(blogItem);
        return blogItemRepository.save(blogItem);
    }

    /**
     * Add a tag to a blog item
     *
     * @param blog_item_id id of the blog item
     * @param blogTag      blog tag input data
     * @param principal    authenticated user
     * @return blog item updated data
     * @throws ResourceNotFoundException blog with given id doesn't exist
     */
    @PatchMapping("/{blog_item_id}/add_tag")
    public BlogItem addBlogTag(@PathVariable("blog_item_id") long blog_item_id, @Valid @RequestBody BlogTag blogTag, Principal principal)
            throws ResourceNotFoundException {
        BlogItem blogItem = safeGet(blog_item_id);
        BlogTag dbTag = blogTagRepository.findBlogTagByName(blogTag.getName());
        if (dbTag == null) {
            // Creating and saving
            dbTag = new BlogTag();
            dbTag.setName(blogTag.getName());
            dbTag.setCreatedBy(principal.getName());
            dbTag = blogTagRepository.save(dbTag);
        }
        blogItem.addBlogTag(dbTag);
        return blogItemRepository.save(blogItem);
    }

    /**
     * Remove tag for a blog item
     *
     * @param blog_item_id id of the blog item
     * @param blogTag      blog tag data to be removed
     * @return blog item updated data
     * @throws ResourceNotFoundException blog with given id doesn't exist
     * @throws BadDataException          when blog tag doesn't exists
     */
    @PatchMapping("/{blog_item_id}/remove_tag")
    public BlogItem removeBlogTag(@PathVariable("blog_item_id") long blog_item_id, @Valid @RequestBody BlogTag blogTag)
            throws ResourceNotFoundException, BadDataException {
        BlogItem blogItem = safeGet(blog_item_id);
        BlogTag dbTag = blogTagRepository.findBlogTagByName(blogTag.getName());
        if (dbTag == null) {
            throw new BadDataException(String.format(Constants.ErrorMsg.TAG_NOT_FOUND, blogTag.getName()));
        }
        blogItem.removeBlogTag(dbTag);
        return blogItemRepository.save(blogItem);
    }

    /**
     * Handles the case when blog item with given id is not found.
     *
     * @param blogItemId id of the blog item
     * @return blog item
     * @throws ResourceNotFoundException if the blog item with given id is not found
     */
    private BlogItem safeGet(long blogItemId) throws ResourceNotFoundException {
        BlogItem item = blogItemRepository.findBlogItemById(blogItemId);
        if (item == null) {
            throw new ResourceNotFoundException(String.format(Constants.ErrorMsg.NOT_FOUND, blogItemId));
        }
        return item;
    }
}