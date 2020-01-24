package com.prashantchaubey.entities.mapped_superclasses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created By: Prashant Chaubey
 * Created On: 02-09-2018 04:18
 **/
@MappedSuperclass
@ToString
public class Tag {
    @Getter
    @Setter
    @NotNull
    private String name;
    @Setter
    @Getter
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Setter
    @Getter
    private String createdBy;
}