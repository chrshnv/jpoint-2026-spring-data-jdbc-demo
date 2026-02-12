package ltd.chrshnv.jpoint_2026_demo;

import org.springframework.boot.SpringApplication;

public class TestJpoint2026DemoApplication {

	static void main(String[] args) {
		SpringApplication.from(Jpoint2026DemoApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
