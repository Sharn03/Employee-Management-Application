package com.Employee.Management.App.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.Management.App.Entity.Employee;
import com.Employee.Management.App.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// Method to fetch all the Employee Details
	public List<Employee> getAllEmployee()
	{
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}
	
	
	//Method to fetch Employee details by EmployeeId
	public Employee getEmployeeById(int id)
	{
		//Declaring the employee obj to null 
		Employee employee = null;
		
		// checking if the id is null or not
		if(Objects.nonNull(id))
		{
		 // here we are using Optional class to check where the object is present or not 
		 Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		 
		 if(optionalEmployee.isPresent())
		 {
			 employee = optionalEmployee.get();
		 }
		 // if the employee object leads to  null we would a run time error message
		 else
		 {
			throw new RuntimeException("Employee id "+ id +" Not Found ");
		 }
		 
		}
		 
		 return employee;
	}
	
	//Method to save employee 
	public void saveEmployee(Employee employee)
	{
		//checking the arguments is null or not
		if(Objects.nonNull(employee))
		{
			
		 employeeRepository.save(employee);
		
		}
	}
	
	
	//Method to update Employee Details
	public Employee updateEmployee(Employee employee)
	{
		Employee existingEmployee = null;
		
		if(Objects.nonNull(employee))
		{
			existingEmployee = employeeRepository.findById(employee.getId()).get();
			existingEmployee.setId(employee.getId());
			existingEmployee.setEmailId(employee.getEmailId());
			existingEmployee.setFirstName(employee.getFirstName());
			existingEmployee.setLastName(employee.getLastName());
		}
		
		return employeeRepository.save(existingEmployee);
	}
	
	
	//Method to delete Employee Details
	public void deleteEmployeeById(int id)
	{
		if(Objects.nonNull(id))
		{
			employeeRepository.deleteById(id);
		}
	}

}
