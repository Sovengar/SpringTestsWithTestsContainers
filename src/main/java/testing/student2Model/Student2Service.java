package testing.student2Model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Student2Service {
    private final Student2Repository studentRepository;

    public List<Student2> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student2 getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student2 saveOrUpdateStudent(Student2 student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
