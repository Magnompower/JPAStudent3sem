package com.example.jpastudent.config;

import com.example.jpastudent.models.Student;
import com.example.jpastudent.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public void run(String... args) throws Exception {
        Student s1= new Student();
        s1.setName("Ramesh");
        s1.setBornDate(LocalDate.of(1990, 1, 1));
        s1.setBornTime(LocalTime.of(10, 10, 10));


        studentRepo.save(s1);
        studentRepo.save(s1);

        s1.setName("Rajesh");
        studentRepo.save(s1);
        studentRepo.save(s1);
    }

}
