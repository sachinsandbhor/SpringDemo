package com.sachin.springdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sachin.springdemo.entities.Student;
import com.sachin.springdemo.repos.StudentRepository;

@SpringBootTest
class SpringDemoJpaApplicationTests {
	
	@Autowired
	private StudentRepository studentRepository;

	@Test
	void saveStudent() {
		//Create
		Student student = new Student();
		student.setId(1l);
		student.setName("Shreeja");
		student.setTestScore(98);
		studentRepository.save(student);
		
		//Read
		Student expectedStudent = studentRepository.findById(1l).get(); 
		assertNotNull(expectedStudent);
		assertEquals(student.getName(), expectedStudent.getName());
		
		//Update
		expectedStudent.setTestScore(99);
		studentRepository.save(expectedStudent);
		Student updatedStudent = studentRepository.findById(1l).get(); 
		assertNotNull(updatedStudent);
		assertEquals(expectedStudent.getTestScore(), updatedStudent.getTestScore());
		
		//Delete
		studentRepository.deleteById(1l);
		boolean exist = studentRepository.existsById(1l);
		assertFalse(exist);
		
		
	}

}
