package h4h.springboot.postgresexample.service;

import h4h.springboot.postgresexample.model.Student;
import h4h.springboot.postgresexample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.sql.DataSource;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    DataSource dataSource;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    public Student save(Student student){
        return studentRepository.save(student);
    }


}
