package com.cisco.cmad.stackflood.data.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.cisco.cmad.stackflood.data.api.PostDao;
import com.cisco.cmad.stackflood.model.PostDetails;

public class PostDaoImpl extends BaseJPADao implements PostDao{

	public PostDaoImpl() {
		super();
	}

	public PostDetails read(int postId) {
		EntityManager em = factory.createEntityManager();
		PostDetails postDetails = em.find(PostDetails.class, postId);
		em.close();
		return postDetails;
	}

	@SuppressWarnings("unchecked")
	public List<PostDetails> read() {
		EntityManager em = factory.createEntityManager();
		List<PostDetails> postDetailsList = em.createQuery("from PostDetails").getResultList();
		em.close();
		return postDetailsList;
	}
	
	@SuppressWarnings("unchecked")
	public List<PostDetails> search(String searchString) {
		EntityManager em = factory.createEntityManager();
		String searchStringPattern = "%" + searchString + "%";
		List<PostDetails> postDetailsList = em.createQuery("from PostDetails p where p.title LIKE :searchstring OR p.article LIKE :searchstring OR p.tags LIKE :searchstring").setParameter("searchstring", searchStringPattern).getResultList();
		em.close();
		return postDetailsList;
	}

	public PostDetails create(PostDetails postDetails) throws PersistenceException {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(postDetails);
		em.getTransaction().commit();
		em.close();
		return postDetails;
	}

}
