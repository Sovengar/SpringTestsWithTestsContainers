package testing.config;

/*
@TestConfiguration(proxyBeanMethods = false)
@Import(KafkaConfig.class)
@Profile("dev")
public class TestContainersComposeDev {

    @RestartScope
    @Bean
    @ServiceConnection
    public PostgreSQLContainer<?> postgresContainer() {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:16.0"));
    }
}
*/