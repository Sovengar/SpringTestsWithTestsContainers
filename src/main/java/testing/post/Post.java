package testing.post;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

/*
record Post(
        @Id
        Integer id,
        Integer userId,
        @NotEmpty
        String title,
        @NotEmpty
        String body,
        @Version Integer version
){ }
*/

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
class Post {
        @Id
        @SequenceGenerator(
                name = "student_sequence",
                sequenceName = "student_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                generator = "student_sequence",
                strategy = GenerationType.SEQUENCE)
        private Long id;
        private Integer userId;
        @NotEmpty
        private String title;
        @NotEmpty
        private String body;
        private Integer version;

        public Post withId(Long id) {
                this.id = id;
                return this;
        }

        public Post withUserId(Integer userId) {
                this.userId = userId;
                return this;
        }

        public Post withTitle(String title) {
                this.title = title;
                return this;
        }

        public Post withBody(String body) {
                this.body = body;
                return this;
        }

        public Post withVersion(Integer version) {
                this.version = version;
                return this;
        }

        public Long id() {
                return id;
        }

        public Integer userId() {
                return userId;
        }

        public String title() {
                return title;
        }

        public String body() {
                return body;
        }

        public Integer version() {
                return version;
        }
}
