package com.prashantchaubey.dto.mappers;

import com.prashantchaubey.dto.requests.CreateContactRequest;
import com.prashantchaubey.dto.responses.CreateContactResponse;
import com.prashantchaubey.entities.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    Contact from(CreateContactRequest contactRequest);

    CreateContactResponse to(Contact contact);
}
