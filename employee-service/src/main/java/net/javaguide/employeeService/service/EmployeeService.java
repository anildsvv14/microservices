package net.javaguide.employeeService.service;

import net.javaguide.employeeService.controller.dto.ApiResponseDto;
import net.javaguide.employeeService.controller.dto.EmployeeDto;
import net.javaguide.employeeService.repo.EmployeeRepository;

public interface EmployeeService {
	
	public EmployeeDto createEmployee(EmployeeDto employeeDto);
	public ApiResponseDto getEmployeeById(Long id);

}
