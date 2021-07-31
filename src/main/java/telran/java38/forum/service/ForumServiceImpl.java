package telran.java38.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import telran.java38.forum.dao.ForumMongoRepository;
import telran.java38.forum.dto.PostBaseDto;
import telran.java38.forum.dto.PostDto;
import telran.java38.forum.dto.exceptions.PostNotFoundException;
import telran.java38.forum.model.Post;

@Component
public class ForumServiceImpl implements ForumService {
	
	@Autowired
	ForumMongoRepository forumRepository;
	
	private PostDto convertToPostDto(Post post) {
		return PostDto.builder()
				.id(post.getId())
				.title(post.getTitle())
				.content(post.getContent())
				.author(post.getAuthor())
				.dateCreated(post.getDateCreated())
				.tags(post.getTags())
				.comments(post.getComments())
				.build();
	}
	
	@Override
	public PostDto addPost(String author, PostBaseDto postBaseDto) {
		Post post = new Post(postBaseDto.getTitle(), postBaseDto.getContent(), author, postBaseDto.getTags());
		forumRepository.save(post);
		return convertToPostDto(post);
	}

	@Override
	public PostDto findPostById(String id) {
		Post post = forumRepository.findById(id)
				.orElseThrow(() -> new PostNotFoundException(id));
		return convertToPostDto(post);
	}
	

	@Override
	public PostDto deletePostById(String id) {
		Post post = forumRepository.findById(id)
				.orElseThrow(() -> new PostNotFoundException(id));
		forumRepository.delete(post);
		return convertToPostDto(post);
	}
	
	@Override
	public PostDto updatePost(String id, PostBaseDto postBaseDto) {
		Post post = forumRepository.findById(id)
				.orElseThrow(() -> new PostNotFoundException(id));
		if (postBaseDto.getTitle() == null) {
			post.setTitle(postBaseDto.getTitle());
		}
		if (postBaseDto.getContent() == null) {
			post.setContent(postBaseDto.getContent());
		}
		if (postBaseDto.getTags() == null) {
			post.setTags(postBaseDto.getTags());
		}
		forumRepository.save(post);
		return convertToPostDto(post);
	}
}
