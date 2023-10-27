package org.jsp.bootcrudrest.service;

import java.util.List;
import org.jsp.bootcrudrest.dao.Studentdao;
import org.jsp.bootcrudrest.dto.Student;
import org.jsp.bootcrudrest.helper.ResponseStructure;
import org.jsp.bootcrudrest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class Studentservice {
	@Autowired
	Studentdao dao;
	@Autowired
	Student dto;
	@Autowired
	StudentRepository repository;

	public ResponseStructure<Student> save(Student student) {

		int total = (student.getMathematics() + student.getComputerscience() + student.getPhysics());
		student.setTotal(total);
		double percentage = total / 3.0;
		student.setPercentage(percentage);
		if (student.getPhysics() < 35 || student.getComputerscience() < 35 || student.getMathematics() < 35) {
			student.setResult("Fail");
		} else {
			if (percentage > 85)
				student.setResult("Distinction");
			else if (percentage > 60)
				student.setResult("First Class");
			else
				student.setResult("Second Class");
		}
		ResponseStructure<Student> response = new ResponseStructure<>();
		response.setMessage("Saved");
		response.setStatus(HttpStatus.CREATED.value());
		response.setData(dao.save(student));
		return response;
	}

	public ResponseStructure<List<Student>> save(List<Student> list) {
		for (Student student : list) {
			int total = (student.getMathematics() + student.getComputerscience() + student.getPhysics());
			student.setTotal(total);
			double percentage = total / 3.0;
			student.setPercentage(percentage);
			if (student.getPhysics() < 35 || student.getComputerscience() < 35 || student.getMathematics() < 35) {
				student.setResult("Fail");
			} else {
				if (percentage > 85)
					student.setResult("Distinction");
				else if (percentage > 60)
					student.setResult("First Class");
				else
					student.setResult("Second Class");
			}
		}
		ResponseStructure<List<Student>> response = new ResponseStructure<>();
		response.setMessage("Saved All Data");
		response.setStatus(HttpStatus.CREATED.value());
		response.setData(dao.save(list));
		return response;
	}

	public ResponseStructure<List<Student>> fetchall() {
		ResponseStructure<List<Student>> response = new ResponseStructure<>();
		List<Student> student = dao.fetchall();
		if (student.isEmpty()) {
			response.setMessage("No data found");
			response.setStatus(HttpStatus.NOT_FOUND.value());
			return response;
		} else {
			response.setMessage("Fetched All The Data");
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(dao.fetchall());
			return response;
		}
	}

	public ResponseStructure<Student> fetch(int id) {
		ResponseStructure<Student> response = new ResponseStructure<>();
		Student student = dao.fetch(id);
		if (student == null )
		{
			response.setMessage("No data found");
			response.setStatus(HttpStatus.NOT_FOUND.value());
			return response;
		} else {
			response.setMessage("the data in" + id);
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(dao.fetch(id));
			return response;
		}
	}

	public ResponseStructure<List<Student>> fetchbyname(String name) {
		ResponseStructure<List<Student>> response = new ResponseStructure<>();
		List<Student> student = dao.fetchbyname(name);
		if (student.isEmpty()) {
			response.setMessage("No data found");
			response.setStatus(HttpStatus.NOT_FOUND.value());
			return response;
		} else {
			response.setMessage("the data in" + name);
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(dao.fetchbyname(name));
			return response;
		}
	}

	public ResponseStructure<Student> delete(int id) {
		ResponseStructure<Student> response = new ResponseStructure<>();
		Student student = dao.fetch(id);
		if (student == null) {
			response.setMessage("Nodata found");
			response.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			dao.delete(id);
			response.setMessage("deleted success fully");
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(student);
		}
		return response;
	}

	public ResponseStructure<List<Student>> fetchbymobile(long mobile) {

		ResponseStructure<List<Student>> response = new ResponseStructure<>();
		List<Student> student = dao.fetchbymobile(mobile);
		if (student.isEmpty()) {
			response.setMessage("No data found");
			response.setStatus(HttpStatus.NOT_FOUND.value());
			return response;
		} else {
			response.setMessage("the data in" + mobile);
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(dao.fetchbymobile(mobile));
			return response;
		}
	}

	public ResponseStructure<List<Student>> Result(String result) {
		ResponseStructure<List<Student>> response = new ResponseStructure<>();
		List<Student> student = dao.Result(result);
		if (student.isEmpty()) {
			response.setMessage("No data found");
			response.setStatus(HttpStatus.NOT_FOUND.value());
			return response;
		} else {
			response.setMessage("the data of " + result);
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(dao.Result(result));
			return response;
		}
	}

//public List<Student> findByMathssGreater(int marks) {
// return dao.findByMathsGreater(marks);
//}
//public List<Student> findByPhysicssGreater(int marks) {
//	return dao.findByPhysicsGreater(marks);
//}
	public ResponseStructure<List<Student>> findBySubject(String sub, int marks) {
		List<Student> list = null;
		if (sub.equals("mathematics"))
			list = dao.findByMathsGreater(marks);
		else if (sub.equals("physics"))
			list = dao.findByPhysicsGreater(marks);
		else
			list = dao.findByComputerscienceGreater(marks);
		ResponseStructure<List<Student>> response = new ResponseStructure<>();
		if (list == null || list.isEmpty()) {
			response.setMessage("No Data Found");
			response.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			response.setMessage("Data Found");
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(list);
		}
		return response;
	}

	public ResponseStructure<List<Student>> findByMinPhyAndMaxPhy(int minmark, int maxmark) {
		List<Student> list = dao.findByMinPhyAndMaxPhy(minmark, maxmark);
		ResponseStructure<List<Student>> response = new ResponseStructure<>();
		if (list.isEmpty()) 
		{
			response.setMessage("No Data Found");
			response.setStatus(HttpStatus.NOT_FOUND.value());
		}
		else
		{
			response.setMessage("Data Found");
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(list);
		}
		return response;
	}

	public ResponseStructure<Student> updateUser(int id, Student student) {
		Student existingstudent = repository.findById(id).orElse(null);
		existingstudent.setMathematics(student.getMathematics());
		existingstudent.setComputerscience(student.getComputerscience());
		existingstudent.setPhysics(id);
		int total = (student.getMathematics() + student.getComputerscience() + student.getPhysics());
		existingstudent.setTotal(total);
		double percentage = total / 3.0;
		existingstudent.setPercentage(percentage);
		if (existingstudent.getPhysics() < 35 || existingstudent.getComputerscience() < 35
				|| existingstudent.getMathematics() < 35) {
			student.setResult("Fail");
		} else {
			if (percentage >=85)
				existingstudent.setResult("Distinction");
			else if (percentage >= 60)
				existingstudent.setResult("First Class");
			else
				existingstudent.setResult("Second Class");
		}
		ResponseStructure<Student> response=new ResponseStructure<>();
		        response.setMessage("Data Found");
		        response.setStatus(HttpStatus.FOUND.value());
				response.setData(dao.save(existingstudent));
		return response;
	}
}