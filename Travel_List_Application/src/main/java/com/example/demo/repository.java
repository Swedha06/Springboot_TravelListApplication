package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface repository extends JpaRepository<travel,Integer>{

	@Query(value="SELECT * FROM travel s where s.travelId=?1",nativeQuery=true)
	List<travel> findById(int id);
	
	
	@Query(value="SELECT * FROM travel s where s.name=?1",nativeQuery=true)
	List<travel> findByName(String name);
	
	
	@Modifying
	@Transactional
	@Query(value="Update travel s set s.travelId=?1 , s.name=?2 , s.description=?3 where s.travelId=?5", nativeQuery=true)
	void update(int travelId, String name, String description, int id);
	
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM travel where travelId=?1", nativeQuery=true)
	void deleteAllByIdInBatch(int id);
}



