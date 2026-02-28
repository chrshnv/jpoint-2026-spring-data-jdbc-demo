package ltd.chrshnv.jpoint_2026_demo.aggregatereference;

import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.UUID;

public interface UserGroupRefRepository extends ListCrudRepository<UserGroupRef, UUID> {
	List<UserGroupRef> findByUser(AggregateReference<User, UserId> user);

	List<UserGroupRef> findByUser_Username(String username);
}
