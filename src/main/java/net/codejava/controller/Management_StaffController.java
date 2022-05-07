package net.codejava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Management_StaffController {
	@GetMapping("/management_staff_login")
	public String management_staff_login() {
		return "management_staff_login";
	}

}
