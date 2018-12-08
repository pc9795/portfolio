package com.pc.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created By: Prashant Chaubey
 * Created On: 08-09-2018 04:18
 **/
@Entity
public class TutorialItem extends Item {

    @Id
    @GeneratedValue
    private long id;

    @ManyToMany(mappedBy = "tutorialItems", fetch = FetchType.EAGER)
    private Set<TutorialTag> tutorialTags = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<TutorialTag> getTutorialTags() {
        return tutorialTags;
    }

    public void setTutorialTags(Set<TutorialTag> tutorialTags) {
        this.tutorialTags = tutorialTags;
    }

    @Override
    public String toString() {
        return "TutorialItem{" +
                "id=" + id +
                ", tutorialTags=" + TutorialTag.toStringWithoutTutorialItems(tutorialTags) +
                "} " + super.toString();
    }
}

