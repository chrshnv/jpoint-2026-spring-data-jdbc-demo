package ltd.chrshnv.jpoint_2026_demo.singlequeryloading.repository;

import ltd.chrshnv.jpoint_2026_demo.TestcontainersConfiguration;
import ltd.chrshnv.jpoint_2026_demo.singlequeryloading.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(TestcontainersConfiguration.class)
class PostRepositoryTest {
	@Autowired
	private PostRepository postRepository;

	@Test
	void should_find_all() {
		Post post = new Post("test-post-title", "test-post-content");
		postRepository.save(post);

		postRepository.findAll();
	}
}

/*
@Configuration
class JdbcMappingContextConfiguration {
	@Bean
	JdbcMappingContext jdbcMappingContext() {
		JdbcMappingContext jdbcMappingContext = new JdbcMappingContext();
		jdbcMappingContext.setSingleQueryLoadingEnabled(true);

		return jdbcMappingContext;
	}
}
*/
