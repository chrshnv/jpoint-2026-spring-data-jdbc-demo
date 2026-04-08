package ltd.chrshnv.jpoint_2026_demo.typesafecriteria;

import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Long> {
}
