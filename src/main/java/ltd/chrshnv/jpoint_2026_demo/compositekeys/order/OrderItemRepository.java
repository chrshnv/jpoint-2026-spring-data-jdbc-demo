package ltd.chrshnv.jpoint_2026_demo.compositekeys.order;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.UUID;

public interface OrderItemRepository extends ListCrudRepository<OrderItem, Object> {
	List<OrderItem> findAllByProduct_ExternalId(UUID externalId);
}
