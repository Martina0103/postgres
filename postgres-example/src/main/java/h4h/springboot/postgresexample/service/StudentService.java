package h4h.springboot.postgresexample.service;
import h4h.springboot.postgresexample.model.Student;
import h4h.springboot.postgresexample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    DataSource dataSource;

    public List<Student> getStudents() {
        List<Student> student1 = new ArrayList<Student>();
        try {
            Connection connect = dataSource.getConnection();
            try{
                return studentRepository.findAll();

            }catch (Exception e){
                e.printStackTrace();
                System.out.printf("\nConnection timeout\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student1;
    }

//    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Student save(Student student){
        Student pomStudent = new Student();
        try {
            Connection connect = dataSource.getConnection();
            try{
                return studentRepository.save(student);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("\nRead only value is TRUE\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.printf("\nConnection timeout\n");
        }
        return pomStudent;
    }

    public void deleteById(Long id){
        try{
            studentRepository.deleteById(id);
        }catch(Exception e){
            e.printStackTrace();
            System.out.printf("\nThe item doesn't exist\n");
        }
    }

    public Optional<Student> findById(Long id){
        Optional<Student> student1 = Optional.of(new Student());
        try{
            return studentRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.printf("\nThe item doesn't exist\n");
        }
        return student1;
    }
}
