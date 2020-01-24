package com.prashantchaubey.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prashantchaubey.entities.mapped_superclasses.Item;
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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;
    @ManyToMany(mappedBy = "blogItems", fetch = FetchType.EAGER)
    @Getter
    @Setter
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Set<BlogTag> blogTags = new HashSet<>();

    public void addBlogTag(BlogTag tag) {
        blogTags.add(tag);
    }

    public void removeBlogTag(BlogTag tag) {
        BlogTag tagToBeRemoved = null;
        for (BlogTag currTag : blogTags) {
            if (currTag.getName().equals(tag.getName())) {
                tagToBeRemoved = currTag;
                break;
            }
        }
        // Right now not handling the case when tag is not present
        if (tagToBeRemoved == null) {
            return;
        }
        blogTags.remove(tagToBeRemoved);
    }
}