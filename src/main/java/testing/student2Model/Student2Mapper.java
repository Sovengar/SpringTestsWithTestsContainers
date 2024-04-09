package testing.student2Model;

import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class Student2Mapper {

    public Student2DTO toDTO(@NonNull Student2 student2) {
        return Student2DTO.builder()
                .firstname(student2.getFirstname())
                .lastname(student2.getLastname())
                .email(student2.getEmail())
                .build();
    }

    public Student2 toEntity(@NonNull Student2DTO student2DTO) {
        Student2 student2 = new Student2();

        student2.setFirstname(student2DTO.getFirstname());
        student2.setLastname(student2DTO.getLastname());
        student2.setEmail(student2DTO.getEmail());

        return student2;
    }
}