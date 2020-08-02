package com.prashantchaubey.api.v1;

import com.prashantchaubey.dto.mappers.ContactMapper;
import com.prashantchaubey.dto.requests.CreateContactRequest;
import com.prashantchaubey.dto.responses.CreateContactResponse;
import com.prashantchaubey.entities.Contact;
import com.prashantchaubey.repositories.ContactRepository;
import com.prashantchaubey.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = Constants.Resource.CONTACTS_V1)
public class ContactResource {

    private ContactRepository contactRepository;
    private ContactMapper contactMapper;

    @Autowired
    public ContactResource(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    @PostMapping
    public CreateContactResponse create(@Valid @RequestBody CreateContactRequest request) {
        Contact contact = contactMapper.from(request);
        contactRepository.save(contact);

        return contactMapper.to(contact);
    }
}
