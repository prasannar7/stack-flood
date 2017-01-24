package com.cisco.cmad.stackflood.api;

import java.util.List;

import com.cisco.cmad.stackflood.model.PostDetails;

public interface Post {

	public PostDetails fetch(int postId);
	
	public PostDetails add(PostDetails postDetails);
	
	public List<PostDetails> fetch();
	
}
