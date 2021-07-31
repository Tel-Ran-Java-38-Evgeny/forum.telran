package telran.java38.forum.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import telran.java38.forum.dao.ForumMongoRepository;
import telran.java38.forum.dto.PostBaseDto;
import telran.java38.forum.dto.PostDto;
import telran.java38.forum.dto.exceptions.PostNotFoundException;
import telran.java38.forum.model.Comment;
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
				.likes(post.getLikes())
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
		if (postBaseDto.getTitle() != null) {
			post.setTitle(postBaseDto.getTitle());
		}
		if (postBaseDto.getContent() != null) {
			post.setContent(postBaseDto.getContent());
		}
		if (postBaseDto.getTags() != null) {
			post.setTags(postBaseDto.getTags());
		}
		forumRepository.save(post);
		return convertToPostDto(post);
	}

	@Override
	public boolean addLike(String id) {
		Post post = forumRepository.findById(id)
				.orElseThrow(() -> new PostNotFoundException(id));
		post.addLike();
		return forumRepository.save(post) != null;
	}

	@Override
	public PostDto addComment(String id, String user, String message) {
		Post post = forumRepository.findById(id)
				.orElseThrow(() -> new PostNotFoundException(id));
		post.addComment(new Comment(user, message));
		forumRepository.save(post);
		return convertToPostDto(post);
	}

	@Override
	public List<PostDto> findPostsByAuthor(String author) {
		return forumRepository.findByAuthor(author)
				.map(p -> convertToPostDto(p))
				.collect(Collectors.toList());
	}

}
