package telran.java38.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.java38.forum.dto.CommentAddDto;
import telran.java38.forum.dto.PostBaseDto;
import telran.java38.forum.dto.PostDto;
import telran.java38.forum.service.ForumService;

@RestController
public class ForumController {
	
	@Autowired
	ForumService forumService;
	
	@PostMapping("/forum/post/{author}")
	public PostDto addPost(@PathVariable String author, @RequestBody PostBaseDto postBaseDto) {
		return forumService.addPost(author, postBaseDto);
	}
	
	@GetMapping("/forum/post/{id}")
	public PostDto findPost(@PathVariable String id) {
		return forumService.findPostById(id);
	}
	
	@DeleteMapping("/forum/post/{id}")
	public PostDto deletePost(@PathVariable String id) {
		return forumService.deletePostById(id);
	}
	
	
	@PutMapping("/forum/post/{id}")
	public PostDto updatePost(@PathVariable String id, @RequestBody PostBaseDto postBaseDto) {
		return forumService.updatePost(id, postBaseDto);
	}
	
	@PutMapping("/forum/post/{id}/like")
	public boolean addLikeToPost(@PathVariable String id) {
		return forumService.addLike(id);
	}
	
	@PutMapping("/forum/post/{id}/comment/{author}")
	public PostDto addCommentToPost(@PathVariable String id, @PathVariable String author, @RequestBody CommentAddDto commentAddDto) {
		return forumService.addComment(id, author, commentAddDto.getMessage());
	}
	
	@GetMapping("/forum/posts/author/{author}")
	public List<PostDto> findPostsByAuthor(String author) {
		return forumService.findPostsByAuthor(author);
	}
	
}
