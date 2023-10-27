package org.jsp.bootcrudrest.controler;

import java.util.*;

import org.jsp.bootcrudrest.dto.Student;
import org.jsp.bootcrudrest.helper.ResponseStructure;
import org.jsp.bootcrudrest.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Studentcontroler 
{
	@Autowired
	Studentservice service;
	
 @PostMapping("students")
 public ResponseStructure<Student> save(@RequestBody Student student)
 {
	 return  service.save(student);
 }
 @PostMapping("students/all")
 public ResponseStructure<List<Student>> save(@RequestBody List<Student> student)
 {
	 return service.save(student);
 }
 
 @GetMapping("/students/all")
 public  ResponseStructure<List<Student>> fetch()
 {
	 return service.fetchall();
 }
 @GetMapping("/students")
 public ResponseStructure<Student> fetch(@RequestParam int id)
 {
	 return service.fetch(id);
 }
 @DeleteMapping("students/sid")
 public ResponseStructure<Student> delete(@RequestParam int id)
 {
    return service.delete(id);
 }
 @GetMapping("students/{name}")
public ResponseStructure<List<Student>> fetchbyname(@PathVariable String name)
{
	 return service.fetchbyname(name);
 
}
 @GetMapping("student/{mobile}")
 public ResponseStructure<List<Student>> fetchbymobile(@PathVariable long mobile)
 
 {
	 return service.fetchbymobile(mobile);
 }
 @GetMapping("students/results/{result}")
 public ResponseStructure<List<Student>> Result(@PathVariable String result)
 {
	 return service.Result(result);
 }
 @GetMapping("students/{subject}/{marks}")
 public ResponseStructure<List<Student>> findBySubject(@PathVariable String subject,@PathVariable int marks)
 {
	 return service.findBySubject(subject,marks);
 }
 @GetMapping("studentss/{minmark}/{maxmark}")
 public ResponseStructure<List<Student>> findByMinPhyAndMaxPhy(@PathVariable int minmark ,@PathVariable int maxmark)
 {
	 return  service.findByMinPhyAndMaxPhy(minmark,maxmark);
 }
 @PutMapping("studentss/{id}")
 public ResponseStructure<Student> edit(@PathVariable int id,@RequestBody Student student )
 {
	 return service.updateUser(id, student);
 }
}