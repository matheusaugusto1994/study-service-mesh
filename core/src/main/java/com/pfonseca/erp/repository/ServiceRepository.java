package com.pfonseca.erp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pfonseca.erp.domain.Service;

@RepositoryRestResource(collectionResourceRel = "services", path = "services")
public interface ServiceRepository extends PagingAndSortingRepository<Service, Long>{

	public Page<Service> findByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);
	
}
