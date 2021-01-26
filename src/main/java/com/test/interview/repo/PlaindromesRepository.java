package com.test.interview.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.test.interview.entity.Palindrome;

public interface PlaindromesRepository extends CrudRepository<Palindrome, Long>{
	@Query(value = "select max(p.palindrome) from Palindrome p ")
	public Palindrome findLargestPalindrome();

	

}
