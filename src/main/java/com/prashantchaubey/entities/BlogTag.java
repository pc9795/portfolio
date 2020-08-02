package com.prashantchaubey.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Builder
@ToString
@Table(name = "blog_tags")
public class BlogTag {
    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(unique = true, nullable = false)
    private String name;

    @Getter
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Getter
    private String createdBy;

    @Getter
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "blogTags")
    private Set<BlogPost> blogPosts;
}
