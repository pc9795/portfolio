package com.prashantchaubey.entities;

import lombok.Getter;
import lombok.Setter;

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
    @Getter
    @Setter
    private long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Set<BlogItem> blogItems = new HashSet<>();

    static String toStringWithoutBlogItems(Collection<BlogTag> blogTagList) {
        StringBuilder blogTagListWithoutBlogItems = new StringBuilder();
        blogTagListWithoutBlogItems.append("[");
        for (BlogTag blogTag : blogTagList) {
            blogTagListWithoutBlogItems.append("BlogTag{" + "id=").
                    append(blogTag.id).append("} ").append("Tag{").append("name='").
                    append(blogTag.getName()).append('\'').append('}').append(",");
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
