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
    private long id;

    @ManyToMany
    @Getter
    @Setter
    @JsonIgnore
    private Set<BlogItem> blogItems = new HashSet<>();
}
