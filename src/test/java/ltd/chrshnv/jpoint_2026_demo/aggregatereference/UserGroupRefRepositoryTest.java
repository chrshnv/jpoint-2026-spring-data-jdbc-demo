package ltd.chrshnv.jpoint_2026_demo.aggregatereference;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserGroupRefRepositoryTest {

	@Autowired
	private UserGroupRefRepository userGroupRefRepository;

	@Test
	void should_crash() {
		userGroupRefRepository.findByUser_Username("test-username");
	}
}
