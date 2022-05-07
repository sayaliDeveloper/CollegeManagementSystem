package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}