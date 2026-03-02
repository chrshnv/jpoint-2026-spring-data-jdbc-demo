package ltd.chrshnv.jpoint_2026_demo.compositekeys.order;

import ltd.chrshnv.jpoint_2026_demo.compositekeys.product.Product;
import ltd.chrshnv.jpoint_2026_demo.compositekeys.product.ProductId;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.UUID;

public interface OrderItemRepository extends ListCrudRepository<OrderItem, Object> {
//	List<OrderItem> findAllByProduct_ExternalId(UUID externalId);
	List<OrderItem> findAllByProduct(AggregateReference<Product, AggregateReference<Product, ProductId>> product);
}
