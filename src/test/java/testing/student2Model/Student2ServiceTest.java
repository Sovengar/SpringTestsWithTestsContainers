package testing.student2Model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class Student2ServiceTest {
    @InjectMocks
    private Student2Service underTest;

    @Mock
    private Student2Repository repository;

    @Mock
    private Student2Mapper student2Mapper;

    @Test
    void shouldCreateStudent2() {
        Student2DTO dto = new Student2DTO("John", "Doe", "john@mail.com", 20);
        Student2 student2 = new Student2(1L, "John", "Doe", "john@mail.com", 20);
        Student2 savedStudent = new Student2(1L, "John", "Doe", "john@mail.com", 20);

        when(student2Mapper.toEntity(dto)).thenReturn(student2);
        when(repository.save(student2)).thenReturn(savedStudent);

        var responseDTO = underTest.create(dto);

        assertThat(dto.getFirstname()).isEqualTo(responseDTO.getFirstname());
        assertThat(dto.getLastname()).isEqualTo(responseDTO.getLastname());
        assertThat(dto.getEmail()).isEqualTo(responseDTO.getEmail());

        verify(student2Mapper, times(1)).toEntity(dto);
        verify(repository, times(1)).save(student2);
    }

    @Test
    void shouldGetAllStudents2(){
        List<Student2> students2 = List.of(new Student2(1L, "John", "Doe", "john@mail.com", 20));

        when(repository.findAll()).thenReturn(students2);
        //when(student2Mapper.toDTO(any(Student2.class))).thenReturn(new Student2DTO("John", "Doe", "john@mail.com", 20));

        List<Student2> students22 = underTest.getAllStudents();

        assertThat(students2.size()).isEqualTo(students22.size());
    }
}
