package testing.student2Model;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ActiveProfiles("test")
class Student2MapperTest {

    private Student2Mapper mapper = new Student2Mapper();

    @Test
    void shouldMapToDTO() {
        Student2DTO dto = new Student2DTO("John", "Doe", "john@mail.com", 20);
        Student2 student2 = mapper.toEntity(dto);

        assertThat(dto.getFirstname()).isEqualTo(student2.getFirstname());
        assertThat(dto.getLastname()).isEqualTo(student2.getLastname());
        assertThat(dto.getEmail()).isEqualTo(student2.getEmail());
        assertThat(dto.getAge()).isEqualTo(student2.getAge());
    }

    @Test
    void shouldThrowWhenDTOIsNull() {
        assertThatThrownBy(() -> mapper.toEntity(null))
                .isInstanceOf(NullPointerException.class);
    }

    //TODO Testear el otro metodo
}