package net.codejava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.codejava.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
	
	@Query(value = "select * from faculty s where s.id like %:keyword% or s.name like %:keyword% or s.email like %:keyword% or s.post like %:keyword%", nativeQuery = true)
	 List<Faculty> findByKeyword(@Param("keyword") String keyword);

}
