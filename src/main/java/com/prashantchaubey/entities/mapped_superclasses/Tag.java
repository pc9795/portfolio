package com.prashantchaubey.entities.mapped_superclasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
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
    @Column(unique = true, nullable = false)
    private String name;
    @Setter
    @Getter
    @CreationTimestamp
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime createdAt;
    @Setter
    @Getter
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String createdBy;
}