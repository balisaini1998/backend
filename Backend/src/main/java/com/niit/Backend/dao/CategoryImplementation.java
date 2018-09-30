package com.niit.Backend.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Backend.model.Category;
@Transactional
@Repository
public class CategoryImplementation implements CategoryRepository  {
	@Autowired
	 SessionFactory sessionFactory;

	public boolean addCategory(Category category) {
		Session session=sessionFactory.getCurrentSession();
		try{
		session.save(category);
		return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCategory(Category category) {
		Session session=sessionFactory.getCurrentSession();
		try{
		session.update(category);
		return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}}

	
	public boolean deleteCategory(int categoryId) {
		Session session=sessionFactory.getCurrentSession();
		try{
		session.delete(getCategoryById(categoryId));
		return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}}

	
	public List<Category> getAllCategory() {
		Session session=sessionFactory.getCurrentSession();
		try{
		Query query=session.createQuery("from Category");
		List<Category> categoryList=(List<Category>)query.getResultList();
		return categoryList;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return null;
		}
	
	}


	
	public Category getCategoryById(int categoryId) {
		Session session=sessionFactory.getCurrentSession();
		try{
	    Category category=(Category)session.get(Category.class,categoryId);
		return category;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}