package com.pc.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Entity carrying data of contact me page form
 * Created By: Prashant Chaubey
 * Created On: 01-09-2018 01:09
 **/
@Entity
public class ContactForm implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String contact;
    @NotNull
    @Email(message = "Email address is not valid!")
    private String email;
    private String purpose;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "ContactForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
