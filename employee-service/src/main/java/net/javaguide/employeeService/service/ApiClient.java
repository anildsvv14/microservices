package net.javaguide.employeeService.service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.javaguide.employeeService.controller.dto.DepartmentDto;







//@FeignClient(url="http://localhost:8082",value = "DEPARTMENT-SERVICE")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiClient {
	
	@GetMapping("api/department/{departmentCode}")
	DepartmentDto getDepartmentbyDepartmentCode(@PathVariable("departmentCode") String departmentCode);
	

}
