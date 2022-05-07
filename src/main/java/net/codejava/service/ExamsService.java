package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.entity.Exams;
import net.codejava.repository.ExamsRepository;


@Transactional
@Service
public class ExamsService {
	@Autowired
	private ExamsRepository repo;
	

public List<Exams> listall()
{
	return repo.findAll();
}
public void save(Exams exams)
{
	repo.save(exams);
}
public Exams get(long id) 
{
	return repo.findById((long) id).get();
}
public void delete(long id)
{
	repo.deleteById((long) id);
}


}