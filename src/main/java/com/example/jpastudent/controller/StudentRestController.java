package com.example.jpastudent.controller;

import com.example.jpastudent.models.Student;
import com.example.jpastudent.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController // Transforms objects into Jso format
public class StudentRestController {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/students")
    public List<Student> studentsList() {
        var obj = studentRepo.findAll();
        return obj;
    }

    @GetMapping("/addstudent")
    public List<Student> addstudent() {
        Student std = new Student();
        std.setBornDate(LocalDate.now());


        List<Student> lst = studentRepo.findAll();
        return lst;
    }

    @GetMapping("students/{name}")
    public List<Student> getallstudentsbyname(@PathVariable String name) {
        return studentRepo.findAllByName(name);
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student postStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentRepo.save(student);
    }

    @PutMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> putStudent(@RequestBody Student student) {
        Optional<Student> student1 = studentRepo.findById(student.getId());
        if (student1.isPresent()) {
            System.out.println(student);
            studentRepo.save(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<Student>((Student) null, HttpStatus.NOT_FOUND);

        }
    }

    // Putmapping with id TODO

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {
            studentRepo.deleteById(id);
            return ResponseEntity.ok("Student with id " + id + " is deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with id " + id + " is not found");
        }// MANY WAYS TO DO THIS
    }

}
