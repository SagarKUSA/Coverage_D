package com.coverage.service;

import java.util.List;

import com.billing.model.Bill;
import com.coverage.model.Coverage;

public interface CoverageService {
	
	public Coverage createCoverage (Coverage coverage);
	
	public Coverage updateCoverage (Coverage coverage);
	
	public void deleteCoverage (Integer id);
	
	public Coverage getCoverage (Integer id);
	
	public List<Coverage>  getAllCoverageList();
	
	public Coverage searchCoverage (String coverageName);
	
	public List<Coverage> getAllBills(Integer pageNumber , Integer pageSize , String sortBy);
}
