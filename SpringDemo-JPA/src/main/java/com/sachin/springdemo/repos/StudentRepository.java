package com.sachin.springdemo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sachin.springdemo.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
