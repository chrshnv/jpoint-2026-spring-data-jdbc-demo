package ltd.chrshnv.jpoint_2026_demo.singlequeryloading.repository;

import ltd.chrshnv.jpoint_2026_demo.TestcontainersConfiguration;
import ltd.chrshnv.jpoint_2026_demo.singlequeryloading.entity.Photo;
import ltd.chrshnv.jpoint_2026_demo.singlequeryloading.entity.PhotoTag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.core.mapping.JdbcMappingContext;

@SpringBootTest
@Import(TestcontainersConfiguration.class)
class PhotoRepositoryTest {
	@Autowired
	private PhotoRepository photoRepository;

	@Test
	void should_find_all() {
		PhotoTag photoTag = new PhotoTag("test-tag-1");
		PhotoTag photoTag1 = new PhotoTag("test-tag-2");

		Photo photo = new Photo("test-photo-url");
		photo.getPhotoTags().add(photoTag);
		photo.getPhotoTags().add(photoTag1);

		photoRepository.save(photo);

		photoRepository.findAll();
	}
}

@Configuration
class JdbcMappingContextConfiguration {
	@Bean
	JdbcMappingContext jdbcMappingContext() {
		JdbcMappingContext ctx = new JdbcMappingContext();
		ctx.setSingleQueryLoadingEnabled(true);

		return ctx;
	}
}
