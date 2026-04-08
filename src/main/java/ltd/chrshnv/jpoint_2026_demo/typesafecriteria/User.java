package ltd.chrshnv.jpoint_2026_demo.typesafecriteria;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

@Table("user_")
public class User {
	@Id
	@Column("id")
	private Long id;

	@Column("username")
	private String username;

	@Column("password")
	private String password;

	@Embedded.Empty
	private Contact contact;

	public User(String username, String password, Contact contact) {
		this.username = username;
		this.password = password;
		this.contact = contact;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
