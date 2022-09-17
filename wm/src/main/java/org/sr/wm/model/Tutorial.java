package org.sr.wm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "tutorials")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Tutorial {

	@Id
	private String id;

	private String title;
	private String description;
	private boolean published;

	public Tutorial(String title, String description, boolean published) {
		this.title = title;
		this.description = description;
		this.published = published;
	}

}
