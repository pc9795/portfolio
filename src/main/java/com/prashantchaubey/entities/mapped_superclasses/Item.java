package com.prashantchaubey.entities.mapped_superclasses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created By: Prashant Chaubey
 * Created On: 08-09-2018 04:18
 **/
@MappedSuperclass
@ToString
public class Item {
    @Setter
    @Getter
    @NotNull
    private String heading;
    @Setter
    @Getter
    private String description;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Setter
    @Getter
    @NotNull
    private String content;
    @Setter
    @Getter
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Setter
    @Getter
    private String createdBy;
}
