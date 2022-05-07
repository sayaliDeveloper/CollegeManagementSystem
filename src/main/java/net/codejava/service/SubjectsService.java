package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import net.codejava.entity.Subjects;

import net.codejava.repository.SubjectsRepository;

@Service
@Transactional

public class SubjectsService {
	@Autowired
	   private SubjectsRepository subjectRepository;
	   
	   public List<Subjects> listAllUser()
	   {
		   return subjectRepository.findAll();
	   }
	   //insert data
	   public void save(Subjects subjects)
	   {
		   subjectRepository.save(subjects);
	   }
	   
	   public Subjects getUser(Long id) 
	   {
		   return subjectRepository.findById(id).get();
	   }
	   //delete user
	   public void deleteUser(Long id)
	   {
		  subjectRepository.deleteById(id);
	   }
	


}
