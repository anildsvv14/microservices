package net.javaguide.employeeService.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties.Restclient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import net.javaguide.employeeService.controller.dto.ApiResponseDto;
import net.javaguide.employeeService.controller.dto.DepartmentDto;
import net.javaguide.employeeService.controller.dto.EmployeeDto;
import net.javaguide.employeeService.controller.entity.Employee;
import net.javaguide.employeeService.repo.EmployeeRepository;
import net.javaguide.employeeService.service.ApiClient;
import net.javaguide.employeeService.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	
	private EmployeeRepository employeeRepository;
	private ModelMapper modelMapper;
	//private RestTemplate restTemplate;
	
	//private WebClient webClient;
	private ApiClient apiClient;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		
		//dto to entity
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		Employee savedEmployee = this.employeeRepository.save(employee);
		
		EmployeeDto empDto = modelMapper.map(savedEmployee, EmployeeDto.class);
		
		return empDto;
	}
	@Override
	@CircuitBreaker(name="${spring.application.name}",fallbackMethod = "getDefaultDepartment")
	public ApiResponseDto getEmployeeById(Long id) {
		Optional<Employee> employee = this.employeeRepository.findById(id);
		EmployeeDto emp=null;
		ApiResponseDto apiResponseDto=new ApiResponseDto();
		if(employee.isPresent())
		{
			Employee emp1 = employee.get();
			emp = modelMapper.map(emp1, EmployeeDto.class);
			
			//get the department details from department service
			
			/*ResponseEntity<DepartmentDto> forEntity = restTemplate.getForEntity("http://localhost:8082/api/department/"+emp.getDepartmentCode(), DepartmentDto.class);
			DepartmentDto dept=forEntity.getBody();*/
			
			/*DepartmentDto dept = webClient.get()
			.uri("http://localhost:8082/api/department/"+emp.getDepartmentCode())
			.retrieve().bodyToMono(DepartmentDto.class).block();*/
			
			DepartmentDto dept = apiClient.getDepartmentbyDepartmentCode(emp.getDepartmentCode());
			
			
			
			 
			 apiResponseDto.setDepartment(dept);
			 apiResponseDto.setEmployee(emp);
		}
		
		
		
		return apiResponseDto;
		
	}
	
	public ApiResponseDto getDefaultDepartment(Long id,Exception exception) {
		
		Optional<Employee> employee = this.employeeRepository.findById(id);
		EmployeeDto emp=null;
		ApiResponseDto apiResponseDto=new ApiResponseDto();
		if(employee.isPresent())
		{
			Employee emp1 = employee.get();
			emp = modelMapper.map(emp1, EmployeeDto.class);
			
			DepartmentDto dept =new DepartmentDto();
			dept.setId(id);
			dept.setDepartmentName("Default Department");
			dept.setDepartmentDescription("this is default department desc");
			dept.setDepartmentCode("DEFAULT");
			
			
			 
			 apiResponseDto.setDepartment(dept);
			 apiResponseDto.setEmployee(emp);
		}
		return apiResponseDto;
		
	}
	

}
