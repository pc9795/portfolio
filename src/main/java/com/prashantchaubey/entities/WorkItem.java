package com.prashantchaubey.entities;

import com.prashantchaubey.entities.mapped_superclasses.Item;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created By: Prashant Chaubey
 * Created On: 08-09-2018 15:21
 **/
@Entity
@ToString
public class WorkItem extends Item {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String link;
}
