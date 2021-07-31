package telran.java38.forum.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import telran.java38.forum.model.Comments;

@Getter
@Builder
public class PostDto {
	String id;
	String title;
	String content;
	String author;
	LocalDateTime dateCreated;
	List<String> tags;
	Integer likes;
	List<Comments> comments;
}
