package com.eazybytes.eazyschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eazybytes.eazyschool.model.Technology;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long> {

}
