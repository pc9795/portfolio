package com.pc.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created By: Prashant Chaubey
 * Created On: 02-09-2018 04:18
 **/
@Entity
public class BlogItem extends Item {

    @Id
    @GeneratedValue
    private long id;
    @ManyToMany(mappedBy = "blogItems", fetch = FetchType.EAGER)
    private Set<BlogTag> blogTags = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<BlogTag> getBlogTags() {
        return blogTags;
    }

    public void setBlogTags(Set<BlogTag> blogTags) {
        this.blogTags = blogTags;
    }

    @Override
    public String toString() {
        return "BlogItem{" +
                "id=" + id +
                ", blogTags=" + BlogTag.toStringWithougBlogItems(blogTags) +
                "} " + super.toString();
    }
}
