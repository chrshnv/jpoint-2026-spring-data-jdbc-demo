package ltd.chrshnv.jpoint_2026_demo.aggregatereference;

import org.springframework.data.relational.core.mapping.Column;

public record UserId(
	@Column("first_name") String firstName,
	@Column("last_name") String lastName,
	@Column("email") String email
) {
}
