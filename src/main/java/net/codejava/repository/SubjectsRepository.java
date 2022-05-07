package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.entity.Subjects;

public interface SubjectsRepository extends JpaRepository<Subjects, Long> {

}