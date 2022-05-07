package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.entity.Exams;

public interface ExamsRepository extends JpaRepository<Exams, Long> {

}