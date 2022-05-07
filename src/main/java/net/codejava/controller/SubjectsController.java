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


import net.codejava.entity.Subjects;

import net.codejava.service.SubjectsService;

@Controller
public class SubjectsController 
{
	@Autowired
	private SubjectsService service;

	//@GetMapping("/teacher_login")
	//public String teacher_login() 
	//{
	//	return "teacher_login";
	//}
	
	
	@RequestMapping("/add_subject")
	public String addSubject(Model model) 
	{
		Subjects subject  = new Subjects();
		
		model.addAttribute("subject", subject);
		
		return "add_subject";
	}
	
	
	
	@RequestMapping(value = "/savesub",method = RequestMethod.POST)
	public String saveSubject(@ModelAttribute("subject")Subjects subject)
	{
		service.save(subject);
		return "redirect:/";
	}
	
	
	@RequestMapping("/list_subject")
	public String viewDetail(Model model) 
	{
		List<Subjects> listSubject = service.listAllUser();
		model.addAttribute("listSubjects", listSubject);
		return "list_subject";
	}
	
	@RequestMapping("/edit_subject/{id}")
	public ModelAndView showEditCoursesPage(@PathVariable(name = "id") long id) 
	{
		ModelAndView mav = new ModelAndView("edit_Subject");
		Subjects subject = service.getUser(id);
		mav.addObject("subject",subject);
		return mav;
		
	}
	@RequestMapping("/deleteUser_subject/{id}")
	public String deleteSubject(@PathVariable(name = "id") long id) 
	{
		service.deleteUser(id);
		return "redirect:/";
	}



}
