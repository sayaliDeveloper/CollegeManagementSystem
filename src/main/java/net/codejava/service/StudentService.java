package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.entity.Student;
import net.codejava.repository.StudentRepository;


@Transactional
@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;
	

public List<Student> listall()
{
	return repo.findAll();
}
public void save(Student student)
{
	repo.save(student);
}
public Student get(long id) 
{
	return repo.findById((long) id).get();
}
public void delete(long id)
{
	repo.deleteById((long) id);
}
public List<Student> getAllStudent()
{
 List<Student> studentlist =  (List<Student>)repo.findAll();
 return studentlist;
}

public List<Student> getByKeyword(String keyword){
 return repo.findByKeyword(keyword);
}

}
