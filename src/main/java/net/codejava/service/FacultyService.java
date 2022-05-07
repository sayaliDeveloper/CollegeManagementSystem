package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.entity.Faculty;
import net.codejava.repository.FacultyRepository;
@Service
@Transactional
public class FacultyService 
{
	   @Autowired
	   private FacultyRepository facultyRepository;
	   
	   public List<Faculty> listAllUser()
	   {
		   return facultyRepository.findAll();
	   }
	   //insert data
	   public void save(Faculty faculty)
	   {
		   facultyRepository.save(faculty);
	   }
	   
	   public Faculty getUser(Long id) 
	   {
		   return facultyRepository.findById(id).get();
	   }
	   //delete user
	   public void deleteUser(Long id)
	   {
		   facultyRepository.deleteById(id);
	   }
	///////
		public List<Faculty> getAllFaculty() {
			List<Faculty> facultylist =  (List<Faculty>)facultyRepository.findAll();
			  return facultylist;
		}

		public List<Faculty> getByKeyword(String keyword) {
			return facultyRepository.findByKeyword(keyword);
		}
	///////

}
