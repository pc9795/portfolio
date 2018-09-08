package com.prashantchaubey9795.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created By: Prashant Chaubey
 * Created On: 02-09-2018 04:18
 **/
@Entity
public class TutorialTag extends Tag {
    @Id
    @GeneratedValue
    private long id;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<TutorialItem> tutorialItems = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<TutorialItem> getTutorialItems() {
        return tutorialItems;
    }

    public void setTutorialItems(Set<TutorialItem> tutorialItems) {
        this.tutorialItems = tutorialItems;
    }

    public static String toStringWithoutTutorialItems(Collection<TutorialTag> tutorialTags) {
        StringBuilder tutorialTagsWithoutItems = new StringBuilder();
        tutorialTagsWithoutItems.append("[");
        for (TutorialTag tutorialTag : tutorialTags) {
            tutorialTagsWithoutItems.append("TutorialTag{" +
                    "id=" + tutorialTag.id +
                    "} " + "Tag{" +
                    "name='" + tutorialTag.getName() + '\'' +
                    '}').append(",");
        }
        tutorialTagsWithoutItems.append("]");
        return tutorialTagsWithoutItems.toString();
    }

    @Override
    public String toString() {
        return "TutorialTag{" +
                "id=" + id +
                ", tutorialItems=" + tutorialItems +
                "} " + super.toString();
    }
}
