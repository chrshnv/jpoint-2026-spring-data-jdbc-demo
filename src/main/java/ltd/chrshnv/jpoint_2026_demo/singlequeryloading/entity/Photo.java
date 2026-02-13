package ltd.chrshnv.jpoint_2026_demo.singlequeryloading.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Table("photo")
public class Photo {
	@Id
	@Column("id")
	private Long id;

	@Column("url")
	private String url;

	@MappedCollection(idColumn = "photo_id", keyColumn = "photo_key")
	private List<PhotoTag> photoTags = new ArrayList<>();

	public Photo(String url) {
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<PhotoTag> getPhotoTags() {
		return photoTags;
	}

	public void setPhotoTags(List<PhotoTag> photoTags) {
		this.photoTags = photoTags;
	}
}
