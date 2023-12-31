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

import com.coverage.model.Coverage;
import com.coverage.service.CoverageService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CoverageController {

	@Autowired
	private CoverageService coverageService;

	@PostMapping("/addCoverage")
	@ApiOperation(value = "Request to add coverage")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"), 
			@ApiResponse(code = 400, message = "Invalid Request"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public Coverage createCoverage(@RequestBody Coverage coverage) {
		Coverage add = coverageService.createCoverage(coverage);
		return add;

	}

	@PutMapping("/editCoverage")
	@ApiOperation(value = "Request to edit coverage")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), 
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public Coverage updateCoverage(@RequestBody Coverage coverage) {
		Coverage update = coverageService.updateCoverage(coverage);
		return update;

	}

	@DeleteMapping("/deleteCoverage/{id}")
	@ApiOperation(value = "Request to delete coverage by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), 
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public void deleteCoverage(@PathVariable("id") Integer id) {
		coverageService.deleteCoverage(id);
	}

	@GetMapping("/getCoverage/{id}")
	@ApiOperation(value = "Request to get coverage by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), 
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public Coverage getCoverage(@PathVariable("id") Integer id) {
		Coverage get = coverageService.getCoverage(id);
		return get;

	}

	@GetMapping("/getAllCoverageList")
	@ApiOperation(value = "Request to get all coverage")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), 
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public List<Coverage> getAllCoverageList() {
		List<Coverage> getAll = coverageService.getAllCoverageList();
		return getAll;

	}

	@GetMapping("/searchByCoverageName")
	@ApiOperation(value = "Request to get coverage by coverage name")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), 
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public Coverage searchCoverage(@RequestParam("coverageName") String coverageName) {
		Coverage search = coverageService.searchCoverage(coverageName);
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
