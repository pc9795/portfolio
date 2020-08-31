package com.prashantchaubey.dto.mappers;

import com.prashantchaubey.dto.requests.ContactCreateRequest;
import com.prashantchaubey.dto.responses.ContactResponse;
import com.prashantchaubey.entities.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactMapper {
  Contact from(ContactCreateRequest contactRequest);

  ContactResponse to(Contact contact);
}
