package ltd.chrshnv.jpoint_2026_demo.singlequeryloading.repository;

import ltd.chrshnv.jpoint_2026_demo.TestcontainersConfiguration;
import ltd.chrshnv.jpoint_2026_demo.singlequeryloading.entity.Author;
import ltd.chrshnv.jpoint_2026_demo.singlequeryloading.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.core.mapping.JdbcMappingContext;

import java.util.UUID;

@SpringBootTest
@Import(TestcontainersConfiguration.class)
class PostRepositoryTest {
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private JdbcAggregateTemplate jdbcAggregateTemplate;

	@Test
	void should_find_all() {
		UUID id = UUID.randomUUID();
		Author author = new Author(id, "test-post-author-first-name", "test-post-author-last-name");

		jdbcAggregateTemplate.insert(author);

		Post post = new Post("test-post-title", "test-post-content", AggregateReference.to(id));
		postRepository.save(post);

		postRepository.findAll();
	}
}

@Configuration
class JdbcMappingContextConfiguration {
	@Bean
	JdbcMappingContext jdbcMappingContext() {
		JdbcMappingContext jdbcMappingContext = new JdbcMappingContext();
		jdbcMappingContext.setSingleQueryLoadingEnabled(true);

		return jdbcMappingContext;
	}
}
