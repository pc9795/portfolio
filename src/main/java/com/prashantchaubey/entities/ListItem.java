package com.prashantchaubey.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    private long id;
    private String name;
    private String type;
    private Date date;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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
