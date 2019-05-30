package com.ishan.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ishan.allocation.model.Allocation;
import com.ishan.allocation.repository.AllocationRepository;


@Service
public class AllocationServiceImpl implements AllocationService {
	@Autowired
	AllocationRepository allocationRepository;
	
	@Override
	public Allocation saveAllocation(Allocation allocation) {
		
		return allocationRepository.save(allocation);
	}

	@Override
	public List<Allocation> fetchAllocation() {
		
		return allocationRepository.findAll();
	}

	@Override
	public Allocation findAllocation(Allocation allocation) {
		
		Optional<Allocation> optional= allocationRepository.findById(allocation.getId());
		return optional.get();
	}

	@Override
	public List<Allocation> findEmp(Allocation allocation1) {
		
		Optional<Allocation>optional2=allocationRepository.findById(allocation1.getEmpId());
		
		return (List<Allocation>) optional2.get();
	}

	

	

}
