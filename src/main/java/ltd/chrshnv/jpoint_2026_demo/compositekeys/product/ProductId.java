package ltd.chrshnv.jpoint_2026_demo.compositekeys.product;

import org.springframework.data.relational.core.mapping.Column;

import java.util.UUID;

public record ProductId(
	@Column("internal_id") UUID internalId,
	@Column("sku") String sku
) {
}
