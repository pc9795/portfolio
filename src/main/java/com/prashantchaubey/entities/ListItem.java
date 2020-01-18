package com.prashantchaubey.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Each value represent items from different lists which i am maintaining i.e.,
 * Casual Reading books, Technical Reading books, Videogames
 * Created By: Prashant Chaubey
 * Created On: 02-09-2018 03:41
 **/

@Entity
public class ListItem implements Serializable {
    public enum Type {
        GAMING, CASUAL, TECHNICAL
    }

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private Type type;
    @Getter
    @Setter
    private Date date;

    @Override
    public String toString() {
        return "ListItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}';
    }
}
