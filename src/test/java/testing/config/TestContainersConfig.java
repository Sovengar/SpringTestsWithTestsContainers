package testing.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;

@TestConfiguration(proxyBeanMethods = false)
@Import({PostgreSQLConfig.class, KafkaConfig.class})
public class TestContainersConfig {
}