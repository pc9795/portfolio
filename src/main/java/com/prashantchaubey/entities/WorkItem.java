package com.prashantchaubey.entities;

import lombok.Getter;
import lombok.Setter;

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
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String link;

    @Override
    public String toString() {
        return "WorkItem{" +
                "id=" + id +
                ", link='" + link + '\'' +
                "} " + super.toString();
    }
}
