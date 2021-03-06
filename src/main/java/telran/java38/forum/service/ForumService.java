package telran.java38.forum.service;

import java.util.List;

import telran.java38.forum.dto.CommentAddDto;
import telran.java38.forum.dto.PostBaseDto;
import telran.java38.forum.dto.PostDto;

public interface ForumService {
	PostDto addPost(String author, PostBaseDto postBaseDto);
	
	PostDto findPostById(String id);
	
	PostDto deletePostById(String id);
	
	PostDto updatePost(String id, PostBaseDto postBaseDto);
	
	boolean addLike(String id);
	
	PostDto addComment(String id, String author, String message);
	
	List<PostDto> findPostsByAuthor(String author);

}
