package com.pfonseca.erp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pfonseca.erp.domain.Contact;

@RepositoryRestResource(collectionResourceRel = "contacts", path = "contacts")
public interface ContactRepository extends PagingAndSortingRepository<Contact, Long>{

	public Page<Contact> findByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);
	
}
