package h4h.springboot.postgresexample.repository;

import h4h.springboot.postgresexample.model.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Override
    <S extends Student> S save(S entity);

    @Override
    Optional<Student> findById(Long id);

    @Override
    void deleteById(Long id);
}