package com.prashantchaubey.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Builder
@ToString
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
}
