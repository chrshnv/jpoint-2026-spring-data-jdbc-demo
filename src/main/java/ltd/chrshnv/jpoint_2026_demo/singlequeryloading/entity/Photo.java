package ltd.chrshnv.jpoint_2026_demo.singlequeryloading.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("post_photo")
public class Photo {
	@Column("title")
	private String title;

	@Column("content")
	private String content;

	public Photo(String title, String content) {
		this.title = title;
		this.content = content;
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
}
