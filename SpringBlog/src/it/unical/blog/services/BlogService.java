package it.unical.blog.services;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import it.unical.blog.model.Comment;
import it.unical.blog.model.Post;

@Service
public class BlogService {

	private Map<Integer, Post> posts;
	
	@PostConstruct
	public void init() {
		posts = new HashMap<>();
		Post first = new Post("Ciccio", "I love pizza, who does not?", "The same does not apply to vegetables", new Date());
		first.addComment(new Comment("Peppe", "I agree", new Date()));
		first.addComment(new Comment("Pasquale", "Who dares not? xD", new Date()));
		posts.put(first.getPostId(), first);
		
		Post second = new Post("Pasquale", "This blog is too good", "What do you think?", new Date());
		second.addComment(new Comment("Peppe", "I agree", new Date()));
		second.addComment(new Comment("Ciccio", "Awesome!", new Date()));
		posts.put(second.getPostId(), second);
	}
	
	public Collection<Post> getAllPosts() {
		return posts.values();
	}

	public void postComment(String comment, int postId, String user) {
		posts.get(postId).addComment(new Comment(user, comment, new Date()));
		
	}
	
	
	
}
