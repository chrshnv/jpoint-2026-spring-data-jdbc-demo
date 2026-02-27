package ltd.chrshnv.jpoint_2026_demo.aggregatereference;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.UUID;

public interface UserGroupRefEmbeddedRepository extends ListCrudRepository<UserGroupRefEmbedded, UUID> {
	List<UserGroupRefEmbedded> findByUserId_FirstName(String firstName);
}
