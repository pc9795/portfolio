package com.prashantchaubey.entities;

import javax.persistence.MappedSuperclass;

/**
 * Created By: Prashant Chaubey
 * Created On: 02-09-2018 04:18
 **/
@MappedSuperclass
public abstract class Tag {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                '}';
    }
}
