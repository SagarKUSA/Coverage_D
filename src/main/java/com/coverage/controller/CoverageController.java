package com.coverage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.billing.model.Bill;
import com.coverage.model.Coverage;
import com.coverage.service.CoverageService;

@RestController
public class CoverageController {
	
	@Autowired
	private CoverageService coverageService;
	
     @PostMapping("/addCoverage")
	public Coverage createCoverage (@RequestBody Coverage coverage) {
		Coverage add = coverageService.createCoverage(coverage);
		return add;
		
	}
	@PutMapping("/editCoverage")
	public Coverage updateCoverage (@RequestBody Coverage coverage) {
		Coverage update= coverageService.updateCoverage(coverage);
		return update;
		
	}
	@DeleteMapping("/deleteCoverage/{id}")
	public void deleteCoverage (@PathVariable ("id") Integer id) {
		coverageService.deleteCoverage(id);
	}
	@GetMapping("/getCoverage/{id}")
	public Coverage getCoverage (@PathVariable ("id") Integer id) {
		Coverage get= coverageService.getCoverage(id);
		return get;
		
	}
	@GetMapping("/getAllCoverageList")
	public List<Coverage>  getAllCoverageList(){
		List<Coverage> getAll= coverageService.getAllCoverageList();
		return getAll;
	
	}
	@GetMapping("/searchByCoverageName")
	public Coverage searchCoverage (@RequestParam ("coverageName") String coverageName) {
		Coverage search= coverageService.searchCoverage(coverageName);
		return search;
		
	}
	
	@GetMapping("/coverageByPage")
	public List<Coverage> getCoverageByPage(@RequestParam (defaultValue = "0" )Integer pageNumber, 
			                        @RequestParam (defaultValue = "100") Integer pageSize,
			                        @RequestParam (defaultValue = "coverageName")String sortBy){
		
		List<Coverage> coverageByPage = coverageService.getAllCoverage(pageNumber, pageSize , sortBy);
		
		return coverageByPage;
	}
}
