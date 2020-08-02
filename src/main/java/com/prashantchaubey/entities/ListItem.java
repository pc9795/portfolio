package com.prashantchaubey.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@ToString
@Builder
@Table(name = "list_items", indexes = {@Index(columnList = "type", name = "list_items_type_idx")})
public class ListItem implements Serializable {
    public enum Type {
        GAMING, TECHNICAL
    }

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    @Enumerated(EnumType.STRING)
    private Type type;

    @Getter
    @CreationTimestamp
    private LocalDateTime createdAt;
}
