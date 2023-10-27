package org.jsp.bootcrudrest.repository;

import java.util.*;

import org.jsp.bootcrudrest.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer>
{

	List<Student> findByName(String name);

	List<Student> findByMobile(long mobile);

	List<Student> findByResult(String result);

	List<Student> findByMathematicsGreaterThanEqual(int marks);

	List<Student> findByPhysicsGreaterThanEqual(int marks);

	List<Student> findByComputerscienceGreaterThanEqual(int marks);
//1 way
	List<Student> findByPhysicsGreaterThanEqualAndPhysicsLessThanEqual(int minmark, int maxmark);
//	2 way
//
//	@Query("select x from x where physics between ?1 and ?2")
//	List<Student>  findByPhysicsbetween(int minmark,int maxmark);
//	
////	3 way
//	List<Student> findByPhysicsBetween(int minmax,int maxmarks);

}
