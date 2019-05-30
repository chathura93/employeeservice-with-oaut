package com.ishan.allocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ishan.allocation.model.Allocation;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Integer>{

}
