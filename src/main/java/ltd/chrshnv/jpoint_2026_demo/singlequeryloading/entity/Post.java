package ltd.chrshnv.jpoint_2026_demo.singlequeryloading.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Table("post")
public class Post {
	@Id
	@Column("id")
	private Long id;

	@Column("title")
	private String title;

	@Column("content")
	private String content;

	@MappedCollection(idColumn = "post_id")
	private Set<Comment> comments = new LinkedHashSet<>();

	@Column("author_id")
	private AggregateReference<Author, UUID> author;

	public Post(String title, String content, AggregateReference<Author, UUID> author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public AggregateReference<Author, UUID> getAuthor() {
		return author;
	}

	public void setAuthor(AggregateReference<Author, UUID> author) {
		this.author = author;
	}
}
