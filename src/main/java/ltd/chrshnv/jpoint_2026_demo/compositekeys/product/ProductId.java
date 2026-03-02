package ltd.chrshnv.jpoint_2026_demo.compositekeys.product;

import org.springframework.data.relational.core.mapping.Column;

import java.util.UUID;

public record ProductId(
	@Column("external_id") UUID externalId,
	@Column("sku") String sku
) {
}
