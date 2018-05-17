package com.movieapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.movieapp.model.Show;
import com.movieapp.model.User;

public class ShowDAOImpl implements ShowDAO{
	
	@Autowired
	HibernateConfig hibernateConfig;

	@Override
	public void addShow(Show s) {
		Session session = hibernateConfig.buildSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		
	}

	@Override
	public void updateShow(Show s) {
		Session session = hibernateConfig.buildSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(s);
		session.getTransaction().commit();
		
	}

	@Override
	public List<Show> listShow() {
		Session session = hibernateConfig.buildSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Show> mList=session.createQuery("from Show").list();
		session.getTransaction().commit();
		session.close();
		return mList;
	}

	@Override
	public Show getShowByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeShow(int id) {
		Session session = hibernateConfig.buildSessionFactory().getCurrentSession();
		String mId =""+id;
		session.beginTransaction();
		Query q = session.createQuery("delete from Show where id=:Id");
		q.setString("Id", mId);
		q.executeUpdate();
		session.getTransaction().commit();
		
	}

	@Override
	public List<Show> getShowById(int id) {
		Session session = hibernateConfig.buildSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from Show where id=:id");
		query.setParameter("id", id);
		List<Show> mLis=query.list();
		session.getTransaction().commit();
		return mLis;
	}
	
}
