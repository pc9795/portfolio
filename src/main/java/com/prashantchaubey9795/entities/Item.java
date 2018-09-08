package com.prashantchaubey9795.entities;

import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * Created By: Prashant Chaubey
 * Created On: 08-09-2018 04:18
 **/
@MappedSuperclass
public class Item {
    private String heading;
    private String description;
    private String content;
    private Timestamp timestamp;

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

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
