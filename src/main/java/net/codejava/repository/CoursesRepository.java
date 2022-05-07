package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.entity.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Long> {

}