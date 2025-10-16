package com.foodelthy.springmvcboot;

import com.foodelthy.springmvcboot.student.model.Student;
import com.foodelthy.springmvcboot.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController
{
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping( "/")
    public String home()
    {
        return "index";
    }

    // This is better Way than Next ONe.
    /*@RequestMapping(value = "add", name = "add")
    public ModelAndView add(@RequestParam("num1") int a, @RequestParam("num2")  int b)
    {
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("sum", a + b);

        return modelAndView;
    }*/

    /*@RequestMapping(value = "add", name = "add")
    public String add(@RequestParam("num1") int a, @RequestParam("num2")  int b, Model model)
    {
        model.addAttribute("sum", a + b);

        return "result";
    }*/

    /*@RequestMapping(value = "add", name = "add")
    public String add(@RequestParam("num1") int a, @RequestParam("num2")  int b, ModelMap model)
    {
        model.addAttribute("sum", a + b);

        return "result";
    } */

    /*@ModelAttribute
    public void ModelData(Model model)
    {
        model.addAttribute("name", "Alien");
    }

    @PostMapping(value = "addAlien", name = "addAlien")
    public String addAlien(@ModelAttribute("alien") Student student)
    {
        return "result";
    }*/

}
