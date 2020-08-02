package com.prashantchaubey.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@ToString
@Table(name = "blog_posts", indexes = {@Index(columnList = "createdAt", name = "createdAtIdx")})
public class BlogPost {
    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Getter
    @Column(nullable = false, unique = true)
    private String name;

    @Getter
    @Column(nullable = false)
    private String heading;

    @Getter
    private String description;

    @Getter
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Getter
    private String createdBy;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Getter
    @Column(nullable = false)
    private String content;
}