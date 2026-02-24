package ltd.chrshnv.jpoint_2026_demo.compositekeys.order;

import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface OrderRepository extends ListCrudRepository<Order, UUID> {
}
