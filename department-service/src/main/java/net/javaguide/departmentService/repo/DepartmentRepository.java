package net.javaguide.departmentService.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguide.departmentService.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	
	Optional<Department> findBydepartmentCode(String departmentCode);
}
