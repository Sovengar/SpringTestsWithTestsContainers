package testing;

import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import testing.config.TestContainersConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
@Import(TestContainersConfiguration.class)
@Transactional
@ActiveProfiles("test")
public class BaseIntegrationTest {

    @Autowired
    protected TestRestTemplate testRestTemplate;

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected PostgreSQLContainer<?> postgres;

    protected final Faker faker = new Faker();

    /*
    @Autowired
    protected ArticlesRepository articlesRepository;

    @Autowired
    protected UsersRepository usersRepository;

    @AfterEach
    void cleanup() {
        articlesRepository.deleteAll();
        usersRepository.deleteAll();
    }

     */
}

