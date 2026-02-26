package ltd.chrshnv.jpoint_2026_demo.aot.repository;

import ltd.chrshnv.jpoint_2026_demo.aot.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {
	@Autowired
	private PersonRepository personRepository;

	@Test
	void should_find_person_ignore_case() {
		Person person = new Person("firstname", "lastname");
		personRepository.save(person);

		Optional<Person> isHasPerson = personRepository.findByFirstNameIgnoreCase("FIRSTNaME");
		assertTrue(isHasPerson.isPresent());
	}
}
