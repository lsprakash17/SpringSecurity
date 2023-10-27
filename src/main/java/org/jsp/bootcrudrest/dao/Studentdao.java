package org.jsp.bootcrudrest.dao;


import java.util.List;
import java.util.Optional;

import org.jsp.bootcrudrest.dto.Student;
import org.jsp.bootcrudrest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Studentdao 
{
	@Autowired 
	 StudentRepository repository;
	
	public Student save(Student student)
	{
	  return repository.save(student);
	}

	public List<Student> fetchall() {
		
		return repository.findAll();
	}
	public List<Student> save(List<Student> list) 
	{
      return repository.saveAll(list);		
	}

	public Student fetch(int id) {
		Optional<Student> op=repository.findById(id);
		if(op.isPresent())
			return op.get();
		else
			return null;
//		return repository.findById(id).orElse(null);
	}

	public void delete(int id) {
        repository.deleteById(id);
	}

	public List<Student> fetchbyname(String name) {
		
		return repository.findByName(name);
	}

	public List<Student> fetchbymobile(long mobile) {
		return  repository.findByMobile(mobile);
	}

	public List<Student> Result(String result) {
		return repository.findByResult(result);
	}

	public List<Student> findByMathsGreater(int marks) {
		return repository.findByMathematicsGreaterThanEqual(marks);
	}

	public List<Student> findByPhysicsGreater(int marks) {
		return repository.findByPhysicsGreaterThanEqual(marks);
	}

	public List<Student> findByComputerscienceGreater(int marks) {
		
		return repository.findByComputerscienceGreaterThanEqual(marks);
	}

	public List<Student> findByMinPhyAndMaxPhy(int minmark, int maxmark) {
		return repository.findByPhysicsGreaterThanEqualAndPhysicsLessThanEqual(minmark,maxmark);
	}



	}

