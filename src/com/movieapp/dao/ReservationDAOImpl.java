package com.movieapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.movieapp.model.Reservation;

public class ReservationDAOImpl implements ReservationDAO{
	
	@Autowired
	HibernateConfig hibernateConfig;
	
	@Override
	public void addReservation(Reservation r) {
		Session session = hibernateConfig.buildSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(r);
		session.getTransaction().commit();
		
		
	}

	@Override
	public Reservation removeReservation(int idUser) {
		Session session = hibernateConfig.buildSessionFactory().getCurrentSession();
		System.out.println(idUser);
		session.beginTransaction();
		Query query=session.createQuery("from Reservation where id=:id");
		query.setParameter("id", idUser);
		List<Reservation> mLis=query.list();
		session.getTransaction().commit();
		if(mLis.isEmpty())
			return null;
		return mLis.get(0);
		
	}

	@Override
	public List<Integer> userReservations(int uId) {
		Session session = hibernateConfig.buildSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from Reservation where idUser=:id");
		query.setParameter("id", uId);
		List<Reservation> rLis=query.list();
		session.getTransaction().commit();
		List<Integer> intLis=new ArrayList<Integer>();
		for(Reservation r:rLis) {
			intLis.add(r.getId());
		}
		return intLis;
	}



}
