package ltd.chrshnv.jpoint_2026_demo.aggregatereference;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("user_group_ref")
public class UserGroupRef {
	@Id
	@Column("id")
	private UUID id;

	@Column("user_group")
	private UserGroup userGroup;

	private AggregateReference<User, UserId> user;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	public AggregateReference<User, UserId> getUser() {
		return user;
	}

	public void setUser(AggregateReference<User, UserId> user) {
		this.user = user;
	}
}
