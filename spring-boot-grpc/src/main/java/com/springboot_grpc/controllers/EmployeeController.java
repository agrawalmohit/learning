package com.springboot_grpc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot_grpc.clients.EmployeeClient;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeClient client; 
	
	@GetMapping("employee")
    public String getForm() {
        return "employeeForm";
    }

	/*
	 * @GetMapping({ "/", "/employee" }) public String searchEmployee(Model
	 * model, @RequestParam(value = "fname") String firstName,
	 * 
	 * @RequestParam(value = "lname") String lastName) {
	 * model.addAttribute("firstName", firstName); model.addAttribute("lastName",
	 * firstName); return "employee"; }
	 */

	@PostMapping("/saveDetails") // it only support port method
	public String saveDetails(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, ModelMap modelMap) {
		String response = client.getEmployeeDetails(firstName, lastName);
		// write your code to save details
		modelMap.put("firstName", firstName);
		modelMap.put("lastName", response);
		return "employee"; // welcome is view name. It will call welcome.jsp
	}

}
