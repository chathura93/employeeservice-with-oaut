package com.ishan.allocation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ishan.allocation.model.Allocation;
import com.ishan.allocation.service.AllocationService;

@RestController
@RequestMapping(value = "/emscloud")
public class AllocationController {
	
	@Autowired
	AllocationService allocationService;
	
	@RequestMapping(value = "/allocation",method = RequestMethod.POST)
	public Allocation save(@RequestBody Allocation allocation) {
		return allocationService.saveAllocation(allocation);
	}
	@RequestMapping(value = "/allocation",method = RequestMethod.GET)
	public List<Allocation> fetchAllocation(){
	
		return allocationService.fetchAllocation();		
	}
	@RequestMapping(value = "/allocation/{id}",method = RequestMethod.GET)
	public ResponseEntity<Allocation> findAllocation(@PathVariable Integer id) {
		Allocation allocation =new Allocation();
		allocation.setId(id);
		return ResponseEntity.ok(allocationService.findAllocation(allocation));
	}
//	@RequestMapping(value = "/findEmp/{id}",method = RequestMethod.GET)
//	public ResponseEntity<Allocation> findAllocation2(@PathVariable Integer empId) {
//		Allocation allocation =new Allocation();
//		allocation.setId(empId);
//		return ResponseEntity.ok(allocationService.findEmp(allocation));
//	}
	

}
