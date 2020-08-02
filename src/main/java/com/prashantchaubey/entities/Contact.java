package com.prashantchaubey.entities;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@ToString
@Builder
@Table(name = "contacts")
public class Contact implements Serializable {
    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    private String contact;

    @Getter
    private String email;

    @Getter
    private String purpose;

    @Getter
    @CreationTimestamp
    private LocalDateTime createdAt;
}
