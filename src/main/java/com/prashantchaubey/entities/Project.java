package com.prashantchaubey.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@ToString
@Builder
@Table(name = "projects", indexes = {@Index(columnList = "createdAt", name = "createdAtIdx")})
public class Project {

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

    @Getter
    private String link;
}
