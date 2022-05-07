package net.codejava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.codejava.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query(value = "select * from student s where s.id like %:keyword% or s.name like %:keyword% or s.email like %:keyword% or s.course like %:keyword%", nativeQuery = true)
	 List<Student> findByKeyword(@Param("keyword") String keyword);


}
