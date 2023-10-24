package com.coverage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coverage.model.Coverage;

@Repository
public interface CoverageRepository extends JpaRepository<Coverage, Integer> {
	
	public Coverage findByCoverageName (String coverageName);

}
