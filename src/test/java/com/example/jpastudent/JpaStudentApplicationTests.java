package com.example.jpastudent;

import com.example.jpastudent.models.Student;
import com.example.jpastudent.repositories.StudentRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JpaStudentApplicationTests {

    @Autowired
    StudentRepo studentRepo;

    @Test
    void contextLoads() {
        List<Student> students = studentRepo.findAllByName("Rajesh");
        assertFalse(students.isEmpty());
    }

}
