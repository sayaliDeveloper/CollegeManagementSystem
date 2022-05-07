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


import net.codejava.entity.Department;

import net.codejava.service.DepartmentService;

@Controller
public class DepartmentController 
{
	@Autowired
	private DepartmentService deptserv;

	//@GetMapping("/teacher_login")
	//public String teacher_login() 
	//{
	//	return "teacher_login";
	//}
	
	
	@RequestMapping("/add_department")
	public String addDepartment(Model model) 
	{
		Department department  = new Department();
		
		model.addAttribute("department", department);
		
		return "add_department";
	}
	
	
	
	@RequestMapping(value = "/saves",method = RequestMethod.POST)
	public String saveDepartment(@ModelAttribute("department")Department department)
	{
		deptserv.save(department);
		return "redirect:/";
	}
	
	
	@RequestMapping("/list_department")
	public String viewDetail(Model model) 
	{
		List<Department> listDepartment = deptserv.listAllUser();
		model.addAttribute("listDepartment", listDepartment);
		return "list_department";
	}
	
	@RequestMapping("/edit_department/{id}")
	public ModelAndView showEditDepartmentPage(@PathVariable(name = "id") long id) 
	{
		ModelAndView mav = new ModelAndView("edit_Department");
		Department department = deptserv.getUser(id);
		mav.addObject("department",department);
		return mav;
		
	}
	@RequestMapping("/deleteUser_department/{id}")
	public String deleteDepartment(@PathVariable(name = "id") long id) 
	{
		deptserv.deleteUser(id);
		return "redirect:/";
	}


}
