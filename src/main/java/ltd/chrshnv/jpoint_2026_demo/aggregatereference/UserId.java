package ltd.chrshnv.jpoint_2026_demo.aggregatereference;

import org.springframework.data.relational.core.mapping.Column;

public record UserId(
	@Column("username") String username,
	@Column("email") String email
) {
}
