package com.prashantchaubey.entities;

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
    private long id;

    @ManyToMany
    @Getter
    @Setter
    private Set<BlogItem> blogItems = new HashSet<>();

}
