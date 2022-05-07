package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.entity.Faculty;
import net.codejava.entity.Management_Staff;

public interface Management_StaffRepository extends JpaRepository<Management_Staff, Long> {

}
