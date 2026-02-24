package ltd.chrshnv.jpoint_2026_demo.compositekeys.order;

import ltd.chrshnv.jpoint_2026_demo.compositekeys.product.Product;
import ltd.chrshnv.jpoint_2026_demo.compositekeys.product.ProductId;
import ltd.chrshnv.jpoint_2026_demo.compositekeys.product.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.util.UUID;

@SpringBootTest
class OrderRepositoryTest {

	@Autowired
	private JdbcAggregateTemplate jdbcAggregateTemplate;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	UUID productIdx = null;

	@BeforeEach
	void setUp() {
		productIdx = UUID.randomUUID();

		ProductId productId = new ProductId(productIdx, "test-sku");
		Product product = new Product(productId, "test-title", 10.0);

		jdbcAggregateTemplate.insert(product);
	}

	@AfterEach
	void tearDown() {
		orderRepository.deleteAll();
		productRepository.deleteAll();
	}

	@Test
	void should_create_order() {
		ProductId productId = new ProductId(productIdx, "test-sku");

		OrderItem orderItem = new OrderItem(AggregateReference.to(productId), 10L);
		Order order = new Order(UUID.randomUUID(), 1.0);
		order.getOrderItems().add(orderItem);

		jdbcAggregateTemplate.insert(order);
	}
}
