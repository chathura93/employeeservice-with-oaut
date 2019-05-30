package com.ishan.allocation.service;

import java.util.List;
import java.util.Optional;

import com.ishan.allocation.model.Allocation;

public interface AllocationService {

	public Allocation saveAllocation(Allocation allocation);
	public List<Allocation> fetchAllocation();
	Allocation findAllocation(Allocation allocation);
	public List<Allocation> findEmp(Allocation allocation1);
}
