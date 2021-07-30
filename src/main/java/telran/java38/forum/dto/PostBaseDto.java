package telran.java38.forum.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class PostBaseDto {
	String title;
	String content;
    List<String> tags;
}
