package ltd.chrshnv.jpoint_2026_demo.aggregatereference;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserGroupRefEmbeddedRepositoryTest {

	@Autowired
	private UserGroupRefEmbeddedRepository userGroupRefEmbeddedRepository;

	@Test
	void should_not_crash() {
		assertDoesNotThrow(() -> userGroupRefEmbeddedRepository.findByUserId_Username("test-username"));
	}
}
