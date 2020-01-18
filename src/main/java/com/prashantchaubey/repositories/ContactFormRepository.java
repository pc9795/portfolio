package com.prashantchaubey.repositories;

import com.prashantchaubey.entities.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created By: Prashant Chaubey
 * Created On: 01-09-2018 22:09
 **/
@Repository
@Transactional
public interface ContactFormRepository extends JpaRepository<ContactForm, Long> {
}
