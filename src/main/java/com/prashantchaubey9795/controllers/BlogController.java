package com.prashantchaubey9795.controllers;

import com.prashantchaubey9795.entities.BlogItem;
import com.prashantchaubey9795.entities.BlogTag;
import com.prashantchaubey9795.repositories.BlogItemRepository;
import com.prashantchaubey9795.repositories.BlogTagRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    @Autowired
    BlogTagRepository blogTagRepository;
    @Autowired
    BlogItemRepository blogItemRepository;

    private static final Logger LOGGER = Logger.getLogger(BlogController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String blog(Model model) {
        List<BlogItem> blogItems = blogItemRepository.findBlogItemsByOrderByTimestampDesc();
        LOGGER.info("blogItems:" + blogItems);
        addBlogsAndTagsToModel(model, getAllTags(), blogItems);
        return "blog";
    }

    @RequestMapping(value = "/month/{month_year}", method = RequestMethod.GET)
    public String blogsByMonthAndYear(@PathVariable(value = "month_year") String monthYear, Model model) {
        LOGGER.info("Getting blogs for:" + monthYear);
        List<BlogItem> blogItems = blogItemRepository.findBlogItemsByMonthsAndYear(monthYear);
        addBlogsAndTagsToModel(model, getAllTags(), blogItems);
        return "blog";
    }

    @RequestMapping(value = "/year/{year}", method = RequestMethod.GET)
    public String blogsByYear(@PathVariable(value = "year") String year, Model model) {
        LOGGER.info("Getting blogs for:" + year);
        List<BlogItem> blogItems = blogItemRepository.findBlogItemsByYear(year);
        addBlogsAndTagsToModel(model, getAllTags(), blogItems);
        return "blog";
    }

    @RequestMapping(value = "/tag/{tag_id}", method = RequestMethod.GET)
    public String blogsByTag(@PathVariable(value = "tag_id") String tagId, Model model) {
        LOGGER.info("Getting blogs for:" + tagId);
        BlogTag blogTag = blogTagRepository.findBlogTagById(Long.parseLong(tagId));
        addBlogsAndTagsToModel(model, getAllTags(), blogTag.getBlogItems());
        return "blog";
    }


    @RequestMapping(value = "/search/", method = RequestMethod.GET)
    public String blogsBySearchText(@RequestParam("search_text") String searchText, Model model) {
        LOGGER.info("Getting blogs for:" + searchText);
        List<BlogItem> blogItems = blogItemRepository.findBlogItemsByHeadingContaining(searchText);
        addBlogsAndTagsToModel(model, getAllTags(), blogItems);
        return "blog";
    }

    @RequestMapping(value = "/single/{blog_id}", method = RequestMethod.GET)
    public String singleBlog(@PathVariable("blog_id") String blogId, Model model) {
        LOGGER.info("Getting blog for id:" + blogId);
        BlogItem blogItem = blogItemRepository.findBlogItemById(Long.parseLong(blogId));
        model.addAttribute("blogItem", blogItem);
        return "blog_single";
    }

    private List<BlogTag> getAllTags() {
        List<BlogTag> blogTags = blogTagRepository.findAll();
        LOGGER.info("blogTags:" + blogTags);
        return blogTags;
    }

    private void addBlogsAndTagsToModel(Model model, Collection<BlogTag> blogTags, Collection<BlogItem> blogItems) {
        model.addAttribute("blogTags", blogTags);
        model.addAttribute("blogItems", blogItems);
    }


}
