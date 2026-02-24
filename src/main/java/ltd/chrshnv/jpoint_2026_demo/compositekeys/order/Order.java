package ltd.chrshnv.jpoint_2026_demo.compositekeys.order;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Table("order_")
public class Order {
	@Id
	@Column("id")
	private UUID id;

	@MappedCollection(idColumn = "order__id")
	private Set<OrderItem> orderItems = new LinkedHashSet<>();

	@Column("price")
	private Double price;

	public Order(UUID id, Double price) {
		this.id = id;
		this.price = price;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
