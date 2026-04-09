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

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryTest {

	@Autowired
	private JdbcAggregateTemplate jdbcAggregateTemplate;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired private OrderItemRepository orderItemRepository;

	UUID productIdx = null;

	@BeforeEach
	void setUp() {
		productIdx = UUID.randomUUID();

		ProductId productId = new ProductId(
			productIdx,
			"test-sku"
		);
		Product product = new Product(
			productId,
			"test-title",
			10.0
		);

		jdbcAggregateTemplate.insert(product);
	}

	@AfterEach
	void tearDown() {
		orderRepository.deleteAll();
		productRepository.deleteAll();
	}

	@Test
	void should_not_find_order_item_in() {
		UUID productIdx2 = UUID.randomUUID();
		ProductId productId2 = new ProductId(
			productIdx2,
			"test-sku-2"
		);

		Product product2 = new Product(
			productId2,
			"test-title-2",
			10.0
		);
		jdbcAggregateTemplate.insert(product2);

		List<AggregateReference<Product, ProductId>> query = List.of(
			AggregateReference.to(
				new ProductId(
					productIdx,
					"test-sku"
				)
			),
			AggregateReference.to(
				productId2
			)
		);

		List<OrderItem> result = orderItemRepository
			.findByProductIn(query);

		assertTrue(result.isEmpty());
	}

	@Test
	void should_create_order() {
		ProductId productId = new ProductId(
			productIdx,
			"test-sku"
		);

		OrderItem orderItem = new OrderItem(
			AggregateReference.to(productId),
			10L
		);
		Order order = new Order(UUID.randomUUID(), 1.0);
		order.getOrderItems().add(orderItem);

		jdbcAggregateTemplate.insert(order);
	}
}
