package com.pc.repositories;

import com.pc.entities.TutorialTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TutorialTagRepository extends JpaRepository<TutorialTag, Long> {
    public TutorialTag findTutorialTagById(long id);
}
