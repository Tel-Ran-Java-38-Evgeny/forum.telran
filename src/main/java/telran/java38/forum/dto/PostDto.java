package telran.java38.forum.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostDto {
	Integer id;
	String title;
	String content;
	String author;
	LocalDateTime dateCreated;
	List<String> tags;
	Integer likes;
	List<Object> comments;
}
