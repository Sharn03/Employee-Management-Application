package com.Employee.Management.App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.Management.App.Entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
