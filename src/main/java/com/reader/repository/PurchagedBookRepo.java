package com.reader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reader.model.PurchagedBook;

@Repository
public interface PurchagedBookRepo extends JpaRepository<PurchagedBook, Long>{

}
