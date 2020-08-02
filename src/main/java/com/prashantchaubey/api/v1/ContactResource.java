package com.prashantchaubey.api.v1;

import com.prashantchaubey.repositories.ContactRepository;
import com.prashantchaubey.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Constants.Resource.CONTACTS_V1)
public class ContactResource {

    private ContactRepository repository;

    @Autowired
    public ContactResource(ContactRepository contactRepository) {
        this.repository = contactRepository;
    }
}
