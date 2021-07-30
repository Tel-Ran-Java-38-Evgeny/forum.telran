package telran.java38.forum.service;

import telran.java38.forum.dto.PostBaseDto;
import telran.java38.forum.dto.PostDto;

public interface ForumService {
	PostDto addPost(String author, PostBaseDto postBaseDto);
	
	PostDto findPostById(Integer id);
	 
}
