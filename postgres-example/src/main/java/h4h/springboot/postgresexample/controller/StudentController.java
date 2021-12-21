package h4h.springboot.postgresexample.controller;

import h4h.springboot.postgresexample.model.Student;
import h4h.springboot.postgresexample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/students")
    public @ResponseBody
    Student save(@RequestBody Student student){
        return studentService.save(student);
    }
}
