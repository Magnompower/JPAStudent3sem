package com.example.jpastudent.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepoTest {

    @Autowired
    StudentRepo studentRepo;

    @Test
    void testForRajesh() {
        var obj = studentRepo.findAllByName("Rajesh");
        assertFalse(obj.isEmpty());
    }

}