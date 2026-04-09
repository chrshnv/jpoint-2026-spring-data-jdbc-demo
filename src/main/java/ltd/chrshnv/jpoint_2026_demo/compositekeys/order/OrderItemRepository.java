package ltd.chrshnv.jpoint_2026_demo.compositekeys.order;

import ltd.chrshnv.jpoint_2026_demo.compositekeys.product.Product;
import ltd.chrshnv.jpoint_2026_demo.compositekeys.product.ProductId;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface OrderItemRepository extends ListCrudRepository<OrderItem, Object> {
	List<OrderItem> findByProductIn(List<ProductId> products);

	List<OrderItem> findAllByProduct(AggregateReference<Product, AggregateReference<Product, ProductId>> product);
}
