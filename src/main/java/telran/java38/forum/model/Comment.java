package telran.java38.forum.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Comment {
	@Setter
	String user;
	@Setter
	String message;
	LocalDateTime dateCreate;
	Integer likes;

	public Comment(String user, String message) {
		this.user = user;
		this.message = message;
		dateCreate = LocalDateTime.now();
		likes = 0;
	}

	public Integer addLike() {
		return ++likes;
	}
}