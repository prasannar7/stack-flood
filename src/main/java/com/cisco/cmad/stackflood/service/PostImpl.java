package com.cisco.cmad.stackflood.service;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import com.cisco.cmad.stackflood.api.Post;
import com.cisco.cmad.stackflood.data.dao.BaseJPADao;
import com.cisco.cmad.stackflood.data.dao.PostDaoImpl;
import com.cisco.cmad.stackflood.exception.PostException;
import com.cisco.cmad.stackflood.exception.UserException;
import com.cisco.cmad.stackflood.model.PostDetails;

public class PostImpl implements Post{
	
	private static BaseJPADao baseJPADao;

	public PostImpl() {
		baseJPADao = new PostDaoImpl();
	}

	public PostDetails fetch(int postId) {
		PostDetails postDetails = null;
		try {
			postDetails = ((PostDaoImpl) baseJPADao).read(postId);
			if (postDetails == null)
				throw new PostException(new Integer(404), "Post not found");
		} catch (Exception e) {
				throw new PostException(new Integer(500), e.getMessage());
			
		}
		return postDetails;
	}

	public PostDetails add(PostDetails postDetails) {
		PostDetails postDetailsResponse = null;
		try {
			postDetails.setReplyCount(0);
			postDetails.setViewCount(0);
			postDetails.setCreatedDate(new Date());
			postDetailsResponse = ((PostDaoImpl) baseJPADao).create(postDetails);
			if (postDetailsResponse == null)
				throw new PostException(new Integer(400), "Bad request");
		} catch (Exception e) {
			if(e instanceof PersistenceException){
				throw new PostException(new Integer(600), "Post already exists.");
			}else{
				throw new PostException(new Integer(500), e.getMessage());
			}
		}
		return postDetailsResponse;
	}

	public List<PostDetails> fetch() {
		List<PostDetails> postDetailsList = null;
		try {
			postDetailsList = ((PostDaoImpl) baseJPADao).read();
			if (postDetailsList == null)
				throw new PostException(new Integer(404), "Posts not found");
		} catch (Exception e) {
				throw new UserException(new Integer(500), e.getMessage());
			
		}
		return postDetailsList;
	}

}
