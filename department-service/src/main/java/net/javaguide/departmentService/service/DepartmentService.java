package net.javaguide.departmentService.service;

import net.javaguide.departmentService.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto saveDepartment(DepartmentDto departmentDto);
	DepartmentDto getDepartmentBydepartmentCode(String departmentCode);
}
