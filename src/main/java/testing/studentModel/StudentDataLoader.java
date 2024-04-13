package testing.studentModel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class StudentDataLoader implements CommandLineRunner {
    private final StudentRepository studentRepository;

    public StudentDataLoader(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(studentRepository.count() == 0){
            Student student1 = new Student("John Doe", "john@example.com", Gender.MALE);
            Student student2 = new Student("Jane Smith", "jane@example.com", Gender.FEMALE);
            Student student3 = new Student("Alice Johnson", "alice@example.com", Gender.FEMALE);

            studentRepository.save(student1);
            studentRepository.save(student2);
            studentRepository.save(student3);
        }
    }
}
