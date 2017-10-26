package it.unical.blog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

	private String poster;
	private String content;
	private String title;
	private Date postDate;
	private List<Comment> comments = new ArrayList<>();
	private int postId;
	
	private static int postsCounter = 0;
	
	public Post(String postingUser, String title, String content, Date postDate) {
		super();
		this.poster = postingUser;
		this.title = title;
		this.content = content;
		this.postDate = postDate;
		postId = postsCounter++;
	}

	public String getContent() {
		return content;
	}
	
	public String getPoster() {
		return poster;
	}
	
	public Date getPostDate() {
		return postDate;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	
	public void addComment(Comment comment) {
		comments.add(comment);
	}
	
	public int getPostId() {
		return postId;
	}
	
	public String getTitle() {
		return title;
	}
	
	
}

