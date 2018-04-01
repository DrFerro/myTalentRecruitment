package com.myTalentRecruitment.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

	public Candidate findCandidateById(@Param("id") long id);
	
	@Query("select c from Candidate c") 
	public List<Candidate> findAllCandidates();
	
	@Query("select c from Candidate c where c.email = :email") 
	public Candidate findCandidateByEmail(@Param("email") String email);
	
}
