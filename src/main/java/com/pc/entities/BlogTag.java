package com.pc.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created By: Prashant Chaubey
 * Created On: 02-09-2018 04:18
 **/
@Entity
public class BlogTag extends Tag {
    @Id
    @GeneratedValue
    private long id;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<BlogItem> blogItems = new HashSet<>();

    //  it was giving an exception without this
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<BlogItem> getBlogItems() {
        return blogItems;
    }

    public void setBlogItems(Set<BlogItem> blogItems) {
        this.blogItems = blogItems;
    }

    public static String toStringWithougBlogItems(Collection<BlogTag> blogTagList) {
        StringBuilder blogTagListWithoutBlogItems = new StringBuilder();
        blogTagListWithoutBlogItems.append("[");
        for (BlogTag blogTag : blogTagList) {
            blogTagListWithoutBlogItems.append("BlogTag{" +
                    "id=" + blogTag.id +
                    "} " + "Tag{" +
                    "name='" + blogTag.getName() + '\'' +
                    '}').append(",");
        }
        blogTagListWithoutBlogItems.append("]");
        return blogTagListWithoutBlogItems.toString();
    }

    @Override
    public String toString() {
        return "BlogTag{" +
                "id=" + id +
                ", blogItems=" + blogItems +
                "} " + super.toString();
    }

}
