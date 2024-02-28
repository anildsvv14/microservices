package net.javaguide.employeeService.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguide.employeeService.controller.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
