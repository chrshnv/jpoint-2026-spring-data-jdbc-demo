package ltd.chrshnv.jpoint_2026_demo.singlequeryloading.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("comment")
public class Comment {
	@Column("content")
	private String content;

	public Comment(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
