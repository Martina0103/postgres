package h4h.springboot.postgresexample.controller;

import h4h.springboot.postgresexample.model.Student;
import h4h.springboot.postgresexample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/students/exceptions")
    public @ResponseBody
    Student save(@RequestBody Student student) throws IOException {
        return studentService.save(student);
    }


    @DeleteMapping("/students/{id}")
    public @ResponseBody
    void deleteById(@PathVariable Long id){
        studentService.deleteById(id);
    }

    @GetMapping("/students/{id}")
    public @ResponseBody
    Optional<Student> findById(@PathVariable Long id, @RequestBody String name){
        return studentService.findById(id);
    }

    @PutMapping("/students/{id}")
    public @ResponseBody
    Student save(@PathVariable Long id, @RequestParam String name){
        Student student = new Student();
        student.setName(name);
        student.setId(id);
        return studentService.save(student);
    }
}
