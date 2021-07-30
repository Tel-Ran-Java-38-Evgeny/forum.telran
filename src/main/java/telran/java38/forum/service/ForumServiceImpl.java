package telran.java38.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import telran.java38.forum.dao.ForumRepository;
import telran.java38.forum.dto.PostBaseDto;
import telran.java38.forum.dto.PostDto;
import telran.java38.forum.model.Post;

@Component
public class ForumServiceImpl implements ForumService {
	
	@Autowired
	ForumRepository forumRepository;
	
	@Override
	public PostDto addPost(String author, PostBaseDto postBaseDto) {
		Post post = new Post(postBaseDto.getTitle(), postBaseDto.getContent(), author, postBaseDto.getTags());
		return convertToPostDto(post);
	}

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
	public PostDto findPostById(Integer id) {
		Post post = forumRepository.findPost(id);
		return convertToPostDto(post);
	}

}
