package net.javaguide.departmentService.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;
import net.javaguide.departmentService.dto.DepartmentDto;
import net.javaguide.departmentService.entity.Department;
import net.javaguide.departmentService.repo.DepartmentRepository;
import net.javaguide.departmentService.service.DepartmentService;
@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentRepository departmentRepository;
	private ModelMapper modelMapper;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		// TODO Auto-generated method stub
		//change the dto to entity
		Department dept = modelMapper.map(departmentDto, Department.class);
		Department savedDept = this.departmentRepository.save(dept);
		//change entity to dto
		DepartmentDto deptDto = modelMapper.map(savedDept, DepartmentDto.class);
		
	
		
		
		return deptDto;
	}

	@Override
	public DepartmentDto getDepartmentBydepartmentCode(String departmentCode) {
		
		Optional<Department> bydepartmentCode = this.departmentRepository.findBydepartmentCode(departmentCode);
		DepartmentDto deptDto=null;
		if(bydepartmentCode.isPresent()) {
			Department dept=bydepartmentCode.get();
			deptDto = modelMapper.map(dept, DepartmentDto.class);
		}else {
			
		}
		
		return deptDto;
	}

	
	
	

}
