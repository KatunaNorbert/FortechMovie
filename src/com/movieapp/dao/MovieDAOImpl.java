package com.movieapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movieapp.model.Movie;

@Repository
public class MovieDAOImpl implements MovieDAO{
	
	@Autowired
	HibernateConfig hibernateConfig;
	
	@Override
	public void addMovie(Movie m) {
		Session session = hibernateConfig.buildSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(m);
		session.getTransaction().commit();
		
	}

	@Override
	public void updateMovie(Movie m) {
		Session session = hibernateConfig.buildSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(m);
		session.getTransaction().commit();
		
	}

	@Override
	public List<Movie> listMovies() {
		Session session = hibernateConfig.buildSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Movie> mList=session.createQuery("from Movie").list();
		session.getTransaction().commit();
		session.close();
		return mList;
	}

	@Override
	public Movie getMovieByName(Movie m) {
		Session session = hibernateConfig.buildSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from User where name=:name");
		query.setParameter("name", m.getName());
		List<Movie> mLis=query.list();
		session.getTransaction().commit();
		if(mLis.isEmpty())
			return null;
		return mLis.get(0);
	}

	@Override
	public void removeMovie(int  id) {
		Session session = hibernateConfig.buildSessionFactory().getCurrentSession();
		String mId =""+id;
		session.beginTransaction();
		Query q = session.createQuery("delete from Movie where id=:Id");
		q.setString("Id", mId);
		q.executeUpdate();
		session.getTransaction().commit();
		
		
		
	}

	@Override
	public Movie getMovieById(int id) {
		Session session = hibernateConfig.buildSessionFactory().getCurrentSession();
		System.out.println(id);
		session.beginTransaction();
		Query query=session.createQuery("from Movie where id=:id");
		query.setParameter("id", id);
		List<Movie> mLis=query.list();
		session.getTransaction().commit();
		if(mLis.isEmpty())
			return null;
		return mLis.get(0);
	}

}
