package telran.java38.forum.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import telran.java38.forum.model.Post;

@Component
public class ForumRepositoryImpl implements ForumRepository {

	Map<Integer, Post> forum = new ConcurrentHashMap<Integer, Post>();
	
	@Override
	public Post addPost(Post post) {
		return forum.putIfAbsent(post.getId(), post);
	}

	@Override
	public Post findPost(int id) {
		return forum.get(id);
	}

	@Override
	public Post removePost(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post updatePost(Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
