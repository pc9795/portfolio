package com.prashantchaubey.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

/**
 * Created By: Prashant Chaubey
 * Created On: 02-09-2018 04:18
 **/
@MappedSuperclass
public abstract class Tag {
    @Getter
    @Setter
    private String name;

    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                '}';
    }
}
