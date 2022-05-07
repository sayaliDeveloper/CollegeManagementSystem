package net.codejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import net.codejava.entity.Student;

import net.codejava.service.StudentService;





@Controller
public class StudentController {
	@Autowired
	StudentService service;
	
	
	//admission
	@RequestMapping("/admission")
	public String showNewProductPage(Model model)
	{
		Student student = new Student();
		model.addAttribute("student",student);
		return "admission";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("student") Student student)
	{
		service.save(student);
		return "redirect:/admission";
	}
	
//	login		 
	 @RequestMapping(path = {"/student_login"})
	 public String home(Student student, Model model, String keyword) {
	  if(keyword!=null) 
	  {
		  List<Student> studentlist = service.getByKeyword(keyword);
	  	   model.addAttribute("studentlist", studentlist);
	  }
	  else
	  {
		  List<Student> studentlist = service.getAllStudent();
		  model.addAttribute("studentlist", studentlist);
	  }
	  return "student_login";
	 }
	 
	//show home page
	     
	     @RequestMapping("/Student_home")
	 	public String getStudentById(Student student, Model model, String keyword)
	 	{
	    	 List<Student> studentlist = service.getByKeyword(keyword);
	  	   model.addAttribute("studentlist", studentlist);
		return "Student_home";
	 		
	 	}
	
	
}

