package testing.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    /*
    @Bean
    @ServiceConnection
    public KafkaContainer kafka() {
        return new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:7.4.0"))
                .withKraft()
                .withReuse(true); // Solo un contenedor compartido con n microservicios
    }
    */
}
