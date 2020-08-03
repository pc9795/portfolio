package com.prashantchaubey.entities;

import com.prashantchaubey.utils.Constants;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
@NamedEntityGraph(name = Constants.EntityGraphName.BLOG_TAG_WITH_BLOG_POSTS_LOADED_WITH_BLOG_TAGS,
        attributeNodes = {
                @NamedAttributeNode(value = "blogPosts",
                        subgraph = Constants.EntityGraphName.BLOG_POST_WITH_BLOG_TAGS)},
        subgraphs = {
                @NamedSubgraph(name = Constants.EntityGraphName.BLOG_POST_WITH_BLOG_TAGS,
                        attributeNodes = {@NamedAttributeNode("blogTags")})
        })
@Entity
@Table(name = "blog_tags")
public class BlogTag {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private String createdBy;

    @ManyToMany(mappedBy = "blogTags")
    private Set<BlogPost> blogPosts;
}
