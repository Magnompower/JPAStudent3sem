package com.example.jpastudent.repositories;

import com.example.jpastudent.models.Student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer> {


    List<Student> findAllByName(String name);
}
