package com.prashantchaubey.controllers;

import com.prashantchaubey.entities.BlogItem;
import com.prashantchaubey.entities.BlogTag;
import com.prashantchaubey.repositories.jpa.BlogItemRepository;
import com.prashantchaubey.repositories.jpa.BlogTagRepository;
import com.prashantchaubey.repositories.elastic_search.BlogItemESRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

/**
 * Control the blog page of the website
 * Created By: Prashant Chaubey
 * Created On: 02-09-2018 04:22
 **/
@Controller
@RequestMapping("/blogs")
public class BlogController {
    private BlogTagRepository blogTagRepository;
    private BlogItemRepository blogItemRepository;
    private final BlogItemESRepository blogItemESRepository;

    @Autowired
    public BlogController(BlogItemRepository blogItemRepository, BlogTagRepository blogTagRepository, BlogItemESRepository blogItemESRepository) {
        this.blogItemRepository = blogItemRepository;
        this.blogTagRepository = blogTagRepository;
        this.blogItemESRepository = blogItemESRepository;
    }

    /**
     * Get all blogs
     *
     * @param search search string
     * @param model  model to pass to JSP
     * @return the view name
     */
    @GetMapping
    public String getBlogs(@RequestParam(value = "search", required = false) String search, Model model) {
        if (search != null) {
            //Use elastic search
            model.addAttribute("blogItems", blogItemESRepository.findSearchResults(search));
            model.addAttribute("search", search);
            return "search";
        }
        List<BlogItem> blogItems = blogItemRepository.findBlogItemsByOrderByCreatedAtDesc();
        model.addAttribute("blogTags", blogTagRepository.findAll());
        model.addAttribute("blogItems", blogItems);
        return "blog";
    }

    /**
     * Get blogs by month and year
     *
     * @param monthYear month in uppercase 3 letters and year in 4 letters separated by hypon(_)
     * @param model     model to pass to JSP
     * @return the view name
     */
    @GetMapping(value = "/month/{month_year}")
    public String blogByMonthAndYear(@PathVariable(value = "month_year") String monthYear, Model model) {
        List<BlogItem> blogItems = blogItemRepository.findBlogItemsByMonthsAndYear(monthYear);
        model.addAttribute("blogTags", blogTagRepository.findAll());
        model.addAttribute("blogItems", blogItems);
        return "blog";
    }

    /**
     * Get blogs by year
     *
     * @param year  year in 4 letters
     * @param model model to pass to JSP
     * @return the view name
     */
    @GetMapping(value = "/year/{year}")
    public String blogByYear(@PathVariable(value = "year") String year, Model model) {
        List<BlogItem> blogItems = blogItemRepository.findBlogItemsByYear(year);
        model.addAttribute("blogTags", blogTagRepository.findAll());
        model.addAttribute("blogItems", blogItems);
        return "blog";
    }

    /**
     * Get blogs by tag
     *
     * @param tagId id of the tag
     * @param model model to pass to JSP
     * @return the view name
     */
    @GetMapping(value = "/tag/{tag_id}")
    public String blogByTag(@PathVariable(value = "tag_id") Long tagId, Model model) {
        BlogTag blogTag = blogTagRepository.findBlogTagById(tagId);
        Set<BlogItem> blogItems = blogTag.getBlogItems();
        model.addAttribute("blogTags", blogTagRepository.findAll());
        model.addAttribute("blogItems", blogItems);
        return "blog";
    }


    /**
     * Get blogs by id
     *
     * @param blogId id of the blog item
     * @param model  model to pass to JSP
     * @return the view name
     */
    @GetMapping(value = "/{blog_id}")
    public String singleBlog(@PathVariable("blog_id") Long blogId, Model model) {
        BlogItem blogItem = blogItemRepository.findBlogItemById(blogId);
        model.addAttribute("blogItem", blogItem);
        return "blog_single";
    }
}
