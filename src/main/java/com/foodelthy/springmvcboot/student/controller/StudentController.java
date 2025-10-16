package com.foodelthy.springmvcboot.student.controller;

import com.foodelthy.springmvcboot.student.model.Student;
import com.foodelthy.springmvcboot.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = {"", "/"}, name = "getStudents", method = RequestMethod.GET)
    public String getStudents(Model model) {

        model.addAttribute("students", studentRepository.findAll());

        return "student/index";
    }

    @RequestMapping(value = "/{id}", name = "getStudentById", method = RequestMethod.GET)
    public String getStudentById(@PathVariable int id, Model model) {
        model.addAttribute("student", studentRepository.findById(id));

        return "student/showStudent";
    }

    @RequestMapping(value = "/get/{name}", name = "getStudentByName", method = RequestMethod.GET)
    public String getStudentById(@PathVariable String name, Model model) {
        model.addAttribute("student", studentRepository.findByNameOrderByIdDesc(name));

        return "student/showStudent";
    }

    @RequestMapping(value = "/add", name = "addStudent", method = RequestMethod.GET)
    public String showStudentAddForm(Model model){
        model.addAttribute("student", new Student());

        return "student/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student student, Model model) {
        studentRepository.save(student);

        return "redirect:/student"; // or to a detail page
    }
}
