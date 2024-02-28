package net.javaguide.departmentService.controller;

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
import net.javaguide.departmentService.dto.DepartmentDto;
import net.javaguide.departmentService.repo.DepartmentRepository;
import net.javaguide.departmentService.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
@AllArgsConstructor
public class DepartmentController {

	private DepartmentService departmentService;
	
	@PostMapping("/")
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
		
		DepartmentDto saveDepartment = this.departmentService.saveDepartment(departmentDto);
		return ResponseEntity.status(HttpStatus.OK).body(saveDepartment);
		
	}
	
	@GetMapping("/{departmentCode}")
	public ResponseEntity<DepartmentDto> getDepartmentbyDepartmentCode(@PathVariable("departmentCode") String departmentCode){
		DepartmentDto dept = this.departmentService.getDepartmentBydepartmentCode(departmentCode);
		
		return ResponseEntity.status(HttpStatus.OK).body(dept);
	}
}
