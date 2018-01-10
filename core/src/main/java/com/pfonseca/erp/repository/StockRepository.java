package com.pfonseca.erp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pfonseca.erp.domain.Stock;

@RepositoryRestResource(collectionResourceRel = "stocks", path = "stocks")
public interface StockRepository  extends PagingAndSortingRepository<Stock, Long>{

}
