package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.entity.Books;

public interface BoooksRepository extends JpaRepository<Books, Long> {

}
