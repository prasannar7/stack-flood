package com.cisco.cmad.stackflood.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PostDetails {
	
	@Id
	@GeneratedValue
	protected int postId;
	protected String title;
	protected String article;
	protected String createdBY;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;
	protected String tags;
	protected int replyCount;
	protected int viewCount;
	
	public PostDetails() {
		
	}

	public PostDetails(int postId, String title, String article, String createdBY, Date createdDate, String tags,
			int replyCount, int viewCount) {
		super();
		this.postId = postId;
		this.title = title;
		this.article = article;
		this.createdBY = createdBY;
		this.createdDate = createdDate;
		this.tags = tags;
		this.replyCount = replyCount;
		this.viewCount = viewCount;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getCreatedBY() {
		return createdBY;
	}

	public void setCreatedBY(String createdBY) {
		this.createdBY = createdBY;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
}
