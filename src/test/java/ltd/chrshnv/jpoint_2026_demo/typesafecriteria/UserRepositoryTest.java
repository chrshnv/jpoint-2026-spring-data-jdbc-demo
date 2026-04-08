package ltd.chrshnv.jpoint_2026_demo.typesafecriteria;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JdbcAggregateTemplate jdbcAggregateTemplate;

	@AfterEach
	void tearDown() {
		userRepository.deleteAll();
	}

	@Test
	void should_find_by_username() {
		User user = new User(
			"TestUsername",
			"TestPassword",
			new Contact(
				"TestEmail",
				"TestTgram",
				"TestPhone",
				"TestWechat"
			)
		);
		userRepository.save(user);

		Criteria criteria = Criteria
			.where("username")
			.is("TestUsername");

		Query query = Query.query(criteria);
		Optional<User> result = jdbcAggregateTemplate
			.findOne(query, User.class);

		assertTrue(result.isPresent());
	}

	@Test
	void should_sort_by_id_desc() {
		User firstUser = new User(
			"TestFirstUsername",
			"TestFirstPassword",
			new Contact(
				"TestFirstEmail",
				"TestFirstTgram",
				"TestFirstPhone",
				"TestFirstWechat"
			)
		);
		userRepository.save(firstUser);

		User secondUser = new User(
			"TestSecondUsername",
			"TestSecondPassword",
			new Contact(
				"TestSecondEmail",
				"TestSecondTgram",
				"TestSecondPhone",
				"TestSecondWechat"
			)
		);
		userRepository.save(secondUser);

		Sort sort = Sort
			.by("id")
			.descending();

		List<User> result = jdbcAggregateTemplate
			.findAll(User.class, sort);

		assertEquals(2, result.size());
		User target = result.getFirst();

		assertEquals(secondUser.getId(), target.getId());
	}

	@Test
	void should_find_by_tgram() {
		User user = new User(
			"TestUsername",
			"TestPassword",
			new Contact(
				"TestEmail",
				"TestTgram",
				"TestPhone",
				"TestWechat"
			)
		);
		userRepository.save(user);

		Criteria criteria = Criteria
			.where("contact.telegram")
			.is("TestTgram");

		Query query = Query.query(criteria);
		Optional<User> result = jdbcAggregateTemplate
			.findOne(query, User.class);

		assertTrue(result.isPresent());
	}
}
