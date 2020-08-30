package com.prashantchaubey.repositories;

import com.prashantchaubey.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {}
