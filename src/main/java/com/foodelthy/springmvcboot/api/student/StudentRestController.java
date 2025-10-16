package com.foodelthy.springmvcboot.api.student;

import com.foodelthy.springmvcboot.student.model.Student;
import com.foodelthy.springmvcboot.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("students")
    //@RequestMapping(value = "students", method = RequestMethod.GET, produces = {"application/xml"}) // Mandatory XML
    public List<Student> getStudents() {

        List<Student> students = studentRepository.findAll();

        return students;
    }

    @RequestMapping("student/{id}")
    public Student getStudent(@PathVariable int id) {
        Student student = studentRepository.findById(id).orElse(new Student());

        return student;
    }

    //@RequestMapping(value = "student", method = RequestMethod.POST, consumes = {"application/xml"}) // Mandatory XML
    @RequestMapping(value = "student", method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);

        return savedStudent;
    }
}
