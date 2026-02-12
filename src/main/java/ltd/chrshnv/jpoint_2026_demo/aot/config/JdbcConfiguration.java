package ltd.chrshnv.jpoint_2026_demo.aot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.dialect.JdbcDialect;
import org.springframework.data.jdbc.core.dialect.JdbcPostgresDialect;

@Configuration
public class JdbcConfiguration {
	@Bean
	JdbcDialect jdbcDialect() {
		return JdbcPostgresDialect.INSTANCE;
	}
}
