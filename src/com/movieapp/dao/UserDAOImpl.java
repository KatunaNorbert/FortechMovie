package com.movieapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.movieapp.model.User;

public class UserDAOImpl implements UserDAO{
	
	@Autowired
	HibernateConfig hibernateConfig;
	
	
	@Override
	public void addUser(User u) {
		Session session = hibernateConfig.buildSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		
	}

	@Override
	public void updatePerson(User u) {
		Session session = hibernateConfig.buildSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(u);
		session.getTransaction().commit();
		
	}

	@Override
	public List<User> listUsers() {
			Session session = hibernateConfig.buildSessionFactory().getCurrentSession();
			session.beginTransaction();
			List<User> mList=session.createQuery("from User").list();
			session.getTransaction().commit();
			return mList;
	}

	@Override
	public User getUserByName(User u) {
		Session session = hibernateConfig.buildSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from User where name=:name");
		query.setParameter("name", u.getName());
		List<User> mLis=query.list();
		session.getTransaction().commit();
		if(mLis.isEmpty())
			return null;
		return mLis.get(0);
	}

	@Override
	public void removeUser(int id) {
		Session session = hibernateConfig.buildSessionFactory().getCurrentSession();
		String mId =""+id;
		session.beginTransaction();
		Query q = session.createQuery("delete from User where id=:Id");
		q.setString("Id", mId);
		q.executeUpdate();
		session.getTransaction().commit();
		
	}

}
