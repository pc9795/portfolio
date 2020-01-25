package com.prashantchaubey.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Entity carrying data of contact me page form
 * Created By: Prashant Chaubey
 * Created On: 01-09-2018 01:09
 **/
@Entity
@ToString
public class ContactForm implements Serializable {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String contact;
    @NotNull
    @Email(message = "Email address is not valid!")
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String purpose;
    @Setter
    @Getter
    @CreationTimestamp
    private LocalDateTime createdAt;
}
