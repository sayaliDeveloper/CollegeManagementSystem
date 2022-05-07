package net.codejava.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.entity.Courses;

import net.codejava.service.CoursesService;


@Controller
public class CoursesController 
{
	@Autowired
	private CoursesService service;

	//@GetMapping("/teacher_login")
	//public String teacher_login() 
	//{
	//	return "teacher_login";
	//}
	
	
	@RequestMapping("/add_courses")
	public String addCourses(Model model) 
	{
		Courses courses  = new Courses();
		
		model.addAttribute("courses", courses);
		
		return "add_courses";
	}
	
	
	
	@RequestMapping(value = "/savee",method = RequestMethod.POST)
	public String saveCourses(@ModelAttribute("courses")Courses courses)
	{
		service.save(courses);
		return "redirect:/";
	}
	
	
	@RequestMapping("/list_courses")
	public String viewDetail(Model model) 
	{
		List<Courses> listCourses = service.listAllUser();
		model.addAttribute("listCourses", listCourses);
		return "list_courses";
	}
	
	@RequestMapping("/edit_course/{id}")
	public ModelAndView showEditCoursesPage(@PathVariable(name = "id") long id) 
	{
		ModelAndView mav = new ModelAndView("edit_Courses");
		Courses courses = service.getUser(id);
		mav.addObject("courses",courses);
		return mav;
		
	}
	@RequestMapping("/deleteUser_course/{id}")
	public String deleteCourses(@PathVariable(name = "id") long id) 
	{
		service.deleteUser(id);
		return "redirect:/";
	}


}
