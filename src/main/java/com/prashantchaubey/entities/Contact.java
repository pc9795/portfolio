package com.prashantchaubey.entities;


import lombok.Builder;
import lombok.Value;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Value
@Entity
@Table(name = "contacts")
public class Contact implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String contact;

    private String email;

    private String purpose;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
