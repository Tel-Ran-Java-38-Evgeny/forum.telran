package telran.java38.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	public PostDto findPost(@PathVariable Integer id) {
		return forumService.findPostById(id);
	}
}
