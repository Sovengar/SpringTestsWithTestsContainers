package testing;

import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import testing.config.TestContainersConfig;

/*
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
 Ejecuta 2 threads, por tanto 2 transacciones, haciendo que no funcione
 Utilizamos @AutoconfigureMockMvc pero seguimos utilizando testRestTemplate
 */
@SpringBootTest
@AutoConfigureMockMvc

//No se que es mejor, si hacer un import o cargar solo la configuracion desde el springbootTest
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {}, classes = {TestContainersConfig.class})
@Import(TestContainersConfig.class)

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@ActiveProfiles("test")
public class BaseIntegrationTest {

    //@Autowired
    //protected TestRestTemplate testRestTemplate;

    @Autowired
    protected PostgreSQLContainer<?> postgres;

    protected final Faker faker = new Faker();
}