package testing.student2Model;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class Student2Controller {
    private final Student2Service student2Service;

    @GetMapping
    public List<Student2> getAllStudents() {
        return student2Service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student2 getStudentById(@PathVariable Long id) {
        return student2Service.getStudentById(id);
    }

    @PostMapping
    public Student2 createStudent(@RequestBody Student2 student) {
        return student2Service.saveOrUpdateStudent(student);
    }

    @PutMapping("/{id}")
    public Student2 updateStudent(@PathVariable Long id, @RequestBody Student2 student) {
        student.setId(id); // Set the id of the student to update
        return student2Service.saveOrUpdateStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        student2Service.deleteStudent(id);
    }
}