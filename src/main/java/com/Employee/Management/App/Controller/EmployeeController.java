package com.Employee.Management.App.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Management.App.Entity.Employee;
import com.Employee.Management.App.Service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/home")
	public String home(Model m)
	{
		m.addAttribute("allEmployeeDetails", employeeService.getAllEmployee());
		return "index";
	}
	
	//End points to add new employee
	@GetMapping("/addNewEmployee")
	public String addNewEmployee(Model m)
	{
		Employee employee = new Employee();
		m.addAttribute("employee", employee);
		return "addEmployee";
	}
	
	//End points to save employee
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
		employeeService.saveEmployee(employee);
		return "redirect:/home";
	}
	
	//End points to update employee
	@GetMapping("/updateEmployee/{id}")
	public String updateEmployee(@PathVariable("id") int id, Model m)
	{
		Employee employee =  employeeService.getEmployeeById(id);
		m.addAttribute("employee", employee);
		return "update";
	}
	
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id)
	{
		 employeeService.deleteEmployeeById(id);
		 return "redirect:/home";
	}
	
	@GetMapping("/viewEmployee/{id}")
	public String viewEmployee(@PathVariable("id") int id,Model m)
	{
		Employee employee =  employeeService.getEmployeeById(id);
		m.addAttribute("employee", employee);
		return "view";
	}
	
	
	

}
