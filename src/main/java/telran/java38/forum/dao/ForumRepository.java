package telran.java38.forum.dao;

import telran.java38.forum.model.Post;

public interface ForumRepository {
	
	Post addPost(Post post);
	
	Post findPost(int id);
	
	Post removePost(int id);
	
	Post updatePost(Post post);
	
}
