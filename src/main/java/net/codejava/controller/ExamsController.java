package net.codejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.codejava.entity.Exams;
import net.codejava.service.ExamsService;


@Controller
public class ExamsController {
	@Autowired
	ExamsService service;
	
	
	//show exam
	
		@RequestMapping("/Student_exams")
		public String viewHomepage(Model model)
		{
			List<Exams> listexam = service.listall();
			model.addAttribute("listexam",listexam);
			return "Student_exams";
		}

}
