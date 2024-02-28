package net.javaguide.employeeService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguide.employeeService.controller.dto.ApiResponseDto;
import net.javaguide.employeeService.controller.dto.EmployeeDto;
import net.javaguide.employeeService.service.EmployeeService;

@RestController
@RequestMapping("/api/employee/")
@AllArgsConstructor
public class EmployeeController {

	private EmployeeService employeeService;
	
	@PostMapping("/")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto employee = this.employeeService.createEmployee(employeeDto);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponseDto> createEmployee(@PathVariable("id") Long id){
		ApiResponseDto employee = this.employeeService.getEmployeeById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
	
}
