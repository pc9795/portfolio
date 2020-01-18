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

import static com.prashantchaubey.utils.Utils.addBlogAndTagsToModel;

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

    @GetMapping
    public String blog(Model model) {
        List<BlogItem> blogItems = blogItemRepository.findBlogItemsByOrderByCreatedAtDesc();
        blogItems.forEach(Utils::checkAndFillDescriptionIfNot);
        addBlogAndTagsToModel(model, getAllTags(), blogItems);
        return "blog";
    }

    @GetMapping(value = "/month/{month_year}")
    public String blogByMonthAndYear(@PathVariable(value = "month_year") String monthYear, Model model) {
        List<BlogItem> blogItems = blogItemRepository.findBlogItemsByMonthsAndYear(monthYear);
        blogItems.forEach(Utils::checkAndFillDescriptionIfNot);
        addBlogAndTagsToModel(model, getAllTags(), blogItems);
        return "blog";
    }

    @GetMapping(value = "/year/{year}")
    public String blogByYear(@PathVariable(value = "year") String year, Model model) {
        List<BlogItem> blogItems = blogItemRepository.findBlogItemsByYear(year);
        blogItems.forEach(Utils::checkAndFillDescriptionIfNot);
        addBlogAndTagsToModel(model, getAllTags(), blogItems);
        return "blog";
    }

    @GetMapping(value = "/tag/{tag_id}")
    public String blogByTag(@PathVariable(value = "tag_id") String tagId, Model model) {
        BlogTag blogTag = blogTagRepository.findBlogTagById(Long.parseLong(tagId));
        Set<BlogItem> blogItems = blogTag.getBlogItems();
        blogItems.forEach(Utils::checkAndFillDescriptionIfNot);
        addBlogAndTagsToModel(model, getAllTags(), blogItems);
        return "blog";
    }


    @GetMapping(value = "/search/")
    public String blogBySearchText(@RequestParam("search_text") String searchText, Model model) {
        List<BlogItem> blogItems = blogItemRepository.findBlogItemsByHeadingContaining(searchText);
        blogItems.forEach(Utils::checkAndFillDescriptionIfNot);
        addBlogAndTagsToModel(model, getAllTags(), blogItems);
        return "blog";
    }

    @GetMapping(value = "/single/{blog_id}")
    public String singleBlog(@PathVariable("blog_id") String blogId, Model model) {
        BlogItem blogItem = blogItemRepository.findBlogItemById(Long.parseLong(blogId));
        Utils.checkAndFillDescriptionIfNot(blogItem);
        model.addAttribute("blogItem", blogItem);
        return "blog_single";
    }

    private List<BlogTag> getAllTags() {
        return blogTagRepository.findAll();
    }
}
