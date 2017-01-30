package com.cisco.cmad.stackflood.data.api;

import java.util.List;

import javax.persistence.PersistenceException;

import com.cisco.cmad.stackflood.model.PostDetails;

public interface PostDao {

	public PostDetails read(int postId);
	
	public List<PostDetails> read();
	
	public PostDetails create(PostDetails postDetails) throws PersistenceException;
	
}
