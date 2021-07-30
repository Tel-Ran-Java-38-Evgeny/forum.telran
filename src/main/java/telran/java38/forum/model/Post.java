package telran.java38.forum.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode(of = {"id"})
public class Post {
	Integer id;
	@Setter
	String title;
	@Setter
	String content;
	String author;
	LocalDateTime dateCreated;
	@Setter
	List<String> tags;
	Integer likes;
	List<Object> comments;
	
	public Post(String title, String content, String author, List<String> tags) {
		id = generateId();
		this.title = title;
		this.content = content;
		this.author = author;
		dateCreated = LocalDateTime.now();
		this.tags = tags;
		comments = new ArrayList<Object>();
	}
	
	private Integer generateId() {
		return (int) Math.floor(Math.random()) + 100000;
	}

	public boolean addComment(Object comment) {
		return comments.add(comment);
	}
}
