package ltd.chrshnv.jpoint_2026_demo.aggregatereference;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("user_")
public class User {
	@Id
	private UserId userId;

	@Column("phone")
	private String phone;

	public User(UserId userId, String phone) {
		this.userId = userId;
		this.phone = phone;
	}

	public UserId getUserId() {
		return userId;
	}

	public void setUserId(UserId userId) {
		this.userId = userId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
