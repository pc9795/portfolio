package com.pc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created By: Prashant Chaubey
 * Created On: 08-09-2018 15:21
 **/
@Entity
public class WorkItem extends Item {

    @Id
    @GeneratedValue
    private long id;

    private String link;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "WorkItem{" +
                "id=" + id +
                ", link='" + link + '\'' +
                "} " + super.toString();
    }
}
