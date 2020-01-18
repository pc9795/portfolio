package com.prashantchaubey.controllers;

import com.prashantchaubey.entities.BlogItem;
import com.prashantchaubey.entities.BlogTag;
import com.prashantchaubey.repositories.BlogItemRepository;
import com.prashantchaubey.repositories.BlogTagRepository;
import com.prashantchaubey.utils.Utils;
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

    @Autowired
    public BlogController(BlogItemRepository blogItemRepository, BlogTagRepository blogTagRepository) {
        this.blogItemRepository = blogItemRepository;
        this.blogTagRepository = blogTagRepository;
    }

    @GetMapping
    public String getBlogs(@RequestParam(value = "search", required = false) String search, Model model) {
        List<BlogItem> blogItems;
        if (search != null) {
            blogItems = blogItemRepository.findBlogItemsByHeadingContaining(search);
        } else {
            blogItems = blogItemRepository.findBlogItemsByOrderByCreatedAtDesc();
        }
        blogItems.forEach(Utils::checkAndFillDescriptionIfNot);
        model.addAttribute("blogTags", blogTagRepository.findAll());
        model.addAttribute("blogItems", blogItems);
        return "blog";
    }

    @GetMapping(value = "/month/{month_year}")
    public String blogByMonthAndYear(@PathVariable(value = "month_year") String monthYear, Model model) {
        List<BlogItem> blogItems = blogItemRepository.findBlogItemsByMonthsAndYear(monthYear);
        blogItems.forEach(Utils::checkAndFillDescriptionIfNot);
        model.addAttribute("blogTags", blogTagRepository.findAll());
        model.addAttribute("blogItems", blogItems);
        return "blog";
    }

    @GetMapping(value = "/year/{year}")
    public String blogByYear(@PathVariable(value = "year") String year, Model model) {
        List<BlogItem> blogItems = blogItemRepository.findBlogItemsByYear(year);
        blogItems.forEach(Utils::checkAndFillDescriptionIfNot);
        model.addAttribute("blogTags", blogTagRepository.findAll());
        model.addAttribute("blogItems", blogItems);
        return "blog";
    }

    @GetMapping(value = "/tag/{tag_id}")
    public String blogByTag(@PathVariable(value = "tag_id") Long tagId, Model model) {
        BlogTag blogTag = blogTagRepository.findBlogTagById(tagId);
        Set<BlogItem> blogItems = blogTag.getBlogItems();
        blogItems.forEach(Utils::checkAndFillDescriptionIfNot);
        model.addAttribute("blogTags", blogTagRepository.findAll());
        model.addAttribute("blogItems", blogItems);
        return "blog";
    }

    @GetMapping(value = "/{blog_id}")
    public String singleBlog(@PathVariable("blog_id") Long blogId, Model model) {
        BlogItem blogItem = blogItemRepository.findBlogItemById(blogId);
        Utils.checkAndFillDescriptionIfNot(blogItem);
        model.addAttribute("blogItem", blogItem);
        return "blog_single";
    }
}
