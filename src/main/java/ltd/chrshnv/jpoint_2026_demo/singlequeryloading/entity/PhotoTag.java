package ltd.chrshnv.jpoint_2026_demo.singlequeryloading.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("photo_tag")
public class PhotoTag {
	@Column("title")
	private String title;

	public PhotoTag(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
