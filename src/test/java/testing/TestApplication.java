package testing;

import org.springframework.boot.SpringApplication;
import testing.config.TestContainersConfig;

public class TestApplication {
	public static void main(String[] args) {
		SpringApplication.from(Application::main).with(TestContainersConfig.class).run(args);
	}
}