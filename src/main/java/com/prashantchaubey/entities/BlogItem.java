package com.prashantchaubey.entities;

import lombok.Getter;
import lombok.Setter;

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
    @Getter
    @Setter
    private long id;
    @ManyToMany(mappedBy = "blogItems", fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Set<BlogTag> blogTags = new HashSet<>();

    @Override
    public String toString() {
        return "BlogItem{" +
                "id=" + id +
                ", blogTags=" + BlogTag.toStringWithoutBlogItems(blogTags) +
                "} " + super.toString();
    }
}
