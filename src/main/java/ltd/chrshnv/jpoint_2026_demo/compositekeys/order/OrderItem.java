package ltd.chrshnv.jpoint_2026_demo.compositekeys.order;

import ltd.chrshnv.jpoint_2026_demo.compositekeys.product.Product;
import ltd.chrshnv.jpoint_2026_demo.compositekeys.product.ProductId;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("order_item")
public class OrderItem {
	@Column("product_id")
	private AggregateReference<Product, ProductId> product;

	@Column("quantity")
	private Long quantity;

	public OrderItem(AggregateReference<Product, ProductId> product, Long quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public AggregateReference<Product, ProductId> getProduct() {
		return product;
	}

	public void setProduct(AggregateReference<Product, ProductId> product) {
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
}
