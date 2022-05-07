package net.codejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndView;



import net.codejava.entity.Faculty;
import net.codejava.service.FacultyService;

@Controller
public class FacultyController {
	@Autowired
	private FacultyService service;

	@GetMapping("/teacher_login")
	public String teacher_login() 
	{
		return "teacher_login";
	}
	
	
	@RequestMapping("/add_Teacher")
	public String addTeacher(Model model) 
	{
		Faculty faculty  = new Faculty();
		
		model.addAttribute("faculty", faculty);
		
		return "add_Teacher";
	}
	
	
	
	@RequestMapping(value = "/sav",method = RequestMethod.POST)
	public String saveFaculty(@ModelAttribute("faculty")Faculty faculty)
	{
		service.save(faculty);
		return "redirect:/";
	}
	
	
	@RequestMapping("/list_teacher")
	public String viewDetail(Model model) 
	{
		List<Faculty> listFaculty = service.listAllUser();
		model.addAttribute("listFaculty", listFaculty);
		return "list_teacher";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditFacultyPage(@PathVariable(name = "id") long id) 
	{
		ModelAndView mav = new ModelAndView("edit_Faculty");
		Faculty faculty = service.getUser(id);
		mav.addObject("faculty",faculty);
		return mav;
		
	}
	@RequestMapping("/deleteUser/{id}")
	public String deleteFaculty(@PathVariable(name = "id") long id) 
	{
		service.deleteUser(id);
		return "redirect:/";
	}
	//teacher 
//	login		 
	 @RequestMapping(path = {"/teacher_login"})
	 public String home(Faculty faculty, Model model, String keyword) {
	  if(keyword!=null) 
	  {
		  List<Faculty> facultylist = service.getByKeyword(keyword);
	  	   model.addAttribute("facultylist", facultylist);
	  }
	  else
	  {
		 // List<Faculty> facultylist = service.getAllFaculty();
		 // model.addAttribute("facultylist", facultylist);
		  List<Faculty> listFaculty = service.listAllUser();
			model.addAttribute("listFaculty", listFaculty);
			return "list_teacher";

	  }
	  return "teacher_login";
	 }
	 
	//show single rec
	     
	     @RequestMapping("/Faculty_single")
	 	public String getStudentById(Faculty faculty, Model model, String keyword)
	 	{
	    	 List<Faculty> facultylist = service.getByKeyword(keyword);
	  	   model.addAttribute("facultylist", facultylist);
		return "Faculty_single";
	 		
	 	}
	}