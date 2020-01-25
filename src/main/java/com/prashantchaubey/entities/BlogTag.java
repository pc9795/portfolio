package com.prashantchaubey.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prashantchaubey.entities.mapped_superclasses.Tag;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @ManyToMany
    @Getter
    @Setter
    @JsonIgnore
    private Set<BlogItem> blogItems = new HashSet<>();

    void addBlogItem(BlogItem item) {
        blogItems.add(item);
    }

    //NOTE: can be made efficient by creating a composite class for storing keys. Can be done in future.
    void removeBlogItem(BlogItem item) {
        if (item.getId() == null) {
            throw new RuntimeException("Give a valid entity with a valid id");
        }
        BlogItem toBeRemoved = null;
        for (BlogItem currBlogItem : blogItems) {
            if (currBlogItem.getId().equals(item.getId())) {
                toBeRemoved = currBlogItem;
                break;
            }
        }
        // Right now not handling the case when tag is not present
        if (toBeRemoved == null) {
            return;
        }
        blogItems.remove(toBeRemoved);
    }
}
