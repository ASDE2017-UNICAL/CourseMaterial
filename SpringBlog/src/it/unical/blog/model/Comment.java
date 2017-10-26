package it.unical.blog.model;

import java.util.Date;

public class Comment {

	private String commenter;
	private String commentContent;
	private Date commentDate;

	public Comment(String commenter, String commentContent, Date commentDate) {
		super();
		this.commenter = commenter;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public String getCommenter() {
		return commenter;
	}

}
