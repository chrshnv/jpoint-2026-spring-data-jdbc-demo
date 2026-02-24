package ltd.chrshnv.jpoint_2026_demo.compositekeys.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("product")
public class Product {
	@Id
	private ProductId productId;

	@Column("title")
	private String title;

	@Column("price")
	private Double price;

	public Product(ProductId productId, String title, Double price) {
		this.productId = productId;
		this.title = title;
		this.price = price;
	}

	public ProductId getProductId() {
		return productId;
	}

	public void setProductId(ProductId productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
