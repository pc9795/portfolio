package com.prashantchaubey.dto.mappers;

import com.prashantchaubey.dto.requests.ContactCreateRequest;
import com.prashantchaubey.dto.responses.ContactResponse;
import com.prashantchaubey.entities.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
  Contact from(ContactCreateRequest contactRequest);

  ContactResponse to(Contact contact);
}
