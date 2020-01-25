package com.prashantchaubey.repositories;

import com.prashantchaubey.entities.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By: Prashant Chaubey
 * Created On: 01-09-2018 22:09
 * Repository for entity ContactForm
 **/

public interface ContactFormRepository extends JpaRepository<ContactForm, Long> {
}
