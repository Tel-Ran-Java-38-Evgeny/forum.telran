package telran.java38.forum.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.java38.forum.model.Post;

public interface ForumMongoRepository extends MongoRepository<Post, String> {
	
}
