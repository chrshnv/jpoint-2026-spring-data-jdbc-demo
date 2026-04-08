package ltd.chrshnv.jpoint_2026_demo.typesafecriteria;

import org.springframework.data.relational.core.mapping.Column;

public record Contact(
	@Column("email") String email,
	@Column("telegram") String telegram,
	@Column("phone") String phone,
	@Column("wechat") String wechat
) {
}
