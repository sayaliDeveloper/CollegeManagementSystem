package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.entity.Department;

import net.codejava.repository.DepartmentRepository;


@Service
@Transactional
public class DepartmentService 
{
	@Autowired
	   private DepartmentRepository departmentRepository;
	   
	   public List<Department> listAllUser()
	   {
		   return departmentRepository.findAll();
	   }
	   //insert data
	   public void save(Department department)
	   {
		   departmentRepository.save(department);
	   }
	   
	   public Department getUser(Long id) 
	   {
		   return departmentRepository.findById(id).get();
	   }
	   //delete user
	   public void deleteUser(Long id)
	   {
		   departmentRepository.deleteById(id);
	   }
}
