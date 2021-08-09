package telran.java38.forum.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import telran.java38.forum.model.Comment;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
	String id;
	String title;
	String content;
	String author;
	LocalDateTime dateCreated;
	@Singular
	List<String> tags;
	Integer likes;
	@Singular
	List<Comment> comments;
}
