package com.pfonseca.erp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pfonseca.erp.domain.Sale;

@RepositoryRestResource(collectionResourceRel = "sales", path = "sales")
public interface SaleRepository extends PagingAndSortingRepository<Sale, Long>{

}
