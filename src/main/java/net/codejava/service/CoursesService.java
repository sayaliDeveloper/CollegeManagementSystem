package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.entity.Courses;

import net.codejava.repository.CoursesRepository;


@Service
@Transactional
public class CoursesService 
{
	 @Autowired
	   private CoursesRepository coursesRepository;
	   
	   public List<Courses> listAllUser()
	   {
		   return coursesRepository.findAll();
	   }
	   //insert data
	   public void save(Courses courses)
	   {
		   coursesRepository.save(courses);
	   }
	   
	   public Courses getUser(Long id) 
	   {
		   return coursesRepository.findById(id).get();
	   }
	   //delete user
	   public void deleteUser(Long id)
	   {
		   coursesRepository.deleteById(id);
	   }
	

}
