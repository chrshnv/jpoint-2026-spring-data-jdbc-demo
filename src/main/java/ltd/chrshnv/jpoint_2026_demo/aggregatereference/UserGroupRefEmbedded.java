package ltd.chrshnv.jpoint_2026_demo.aggregatereference;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("user_group_ref_embedded")
public class UserGroupRefEmbedded {
	@Id
	@Column("id")
	private UUID id;

	@Column("user_group")
	private UserGroup userGroup;

	@Embedded.Empty(prefix = "user_")
	private UserId userId;

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

	public UserId getUserId() {
		return userId;
	}

	public void setUserId(UserId userId) {
		this.userId = userId;
	}
}
