package com.prashantchaubey.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * Created By: Prashant Chaubey
 * Created On: 08-09-2018 04:18
 **/
@MappedSuperclass
public class Item {
    @Setter
    @Getter
    private String heading;
    @Setter
    @Getter
    private String description;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Setter
    @Getter
    private String content;
    @Setter
    @Getter
    private Timestamp timestamp;

    @Override
    public String toString() {
        return "Item{" +
                "heading='" + heading + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
