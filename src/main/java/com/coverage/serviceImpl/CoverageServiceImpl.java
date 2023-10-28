package com.coverage.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.coverage.exception.ResourceNotFoundException;
import com.coverage.model.Coverage;
import com.coverage.repository.CoverageRepository;
import com.coverage.service.CoverageService;

@Service
public class CoverageServiceImpl implements CoverageService{
	
	@Autowired
	private CoverageRepository coverageRepository;

	@Override
	public Coverage createCoverage(Coverage coverage) {
		Coverage add = coverageRepository.save(coverage);
		if(add == null) {
			throw new ResourceNotFoundException("Please add valid data" +coverage);
		}
		
		return add;
	}

	@Override
	public Coverage updateCoverage(Coverage coverage) {
		Coverage update= coverageRepository.save(coverage);
		if(update == null) {
			throw new ResourceNotFoundException("No details found to be update" + coverage);
		}
		return update;
	}

	@Override
	public void deleteCoverage(Integer id) {
		
		coverageRepository.deleteById(id);
		
		if(id ==null) {
			throw new ResourceNotFoundException("Cant delete_Cause Id not found :" +id);
		}
		
	
		
	}

	@Override
	public Coverage getCoverage(Integer id) {
	Optional<Coverage> get =	coverageRepository.findById(id);
	if (get.isPresent()) {
		coverageRepository.findById(id);
	}else {
		throw new ResourceNotFoundException("COverage with given id is not found" +id);
	}
	  
		return get.get();
	}

	@Override
	public List<Coverage> getAllCoverageList() {
		List<Coverage> getAll= coverageRepository.findAll();
		return getAll;
	}

	@Override
	public Coverage searchCoverage(String coverageName) {
		Coverage search= coverageRepository.findByCoverageName(coverageName);
		
		if(search ==null) {
			throw new ResourceNotFoundException("Given Covrage Name Is Not Found: "+ coverageName);
		}
		return search;
	}

	@Override
public List<Coverage> getAllCoverage(Integer pageNumber, Integer pageSize , String sortBy) {
		
		Pageable paging = PageRequest.of(pageNumber, pageSize , Sort.by("coverageName").ascending());
		
		Page< Coverage> coverageResult = coverageRepository.findAll(paging);
		
		if(coverageResult.hasContent()) {
			return coverageResult.getContent();
	}
         return new ArrayList<Coverage>();
	
	}

}
