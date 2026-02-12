package ltd.chrshnv.jpoint_2026_demo.aot.repository;

import ltd.chrshnv.jpoint_2026_demo.aot.entity.Person;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface PersonRepository extends ListCrudRepository<Person, Long> {
	Optional<Person> findByFirstNameIgnoreCase(String firstName);

	@Query("SEL * FRIM persons WHERE firstName = :firstName")
	Person invalidQuery(String firstName);
}
