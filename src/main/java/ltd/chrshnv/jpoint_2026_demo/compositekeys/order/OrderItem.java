package ltd.chrshnv.jpoint_2026_demo.compositekeys.order;

import ltd.chrshnv.jpoint_2026_demo.compositekeys.product.ProductId;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

@Table("order_item")
public class OrderItem {
	@Embedded.Empty(prefix = "product_")
	private ProductId product;

	@Column("quantity")
	private Long quantity;

	public OrderItem(ProductId productId, Long quantity) {
		this.product = productId;
		this.quantity = quantity;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public ProductId getProduct() {
		return product;
	}

	public void setProduct(ProductId product) {
		this.product = product;
	}
}
