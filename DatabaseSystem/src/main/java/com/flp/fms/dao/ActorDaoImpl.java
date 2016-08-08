package com.flp.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.flp.ems.domain.Actor;
import com.flp.ems.domain.Film;
import com.flp.fms.exception.EmptyFieldException;
import com.flp.fms.exception.NegativeIdException;
import com.flp.fms.exception.RecordNotFoundException;


public class ActorDaoImpl implements IActorDao{

	public Actor addActor(Actor actor) throws EmptyFieldException {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FMS");  
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction().begin();
		entitymanager.persist(actor);
		entitymanager.getTransaction( ).commit( );
		return actor;

	}

	public Actor modifyActor(Actor actor) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FMS");  
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction().begin();
		entitymanager.merge(actor);
		entitymanager.getTransaction( ).commit( );
		return actor;
	}

	public boolean removeActor(int actorId) throws RecordNotFoundException, NegativeIdException, EmptyFieldException {
		if(actorId==0)
		{
			throw new EmptyFieldException();
		}
		else if(actorId<0)
			throw new NegativeIdException();
		else
		{
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FMS");
			EntityManager entitymanager = emfactory.createEntityManager( );
			entitymanager.getTransaction( ).begin( );
			Actor actor = entitymanager.find( Actor.class, actorId );
			if(actor!=null)
			{
				entitymanager.remove( actor );
				entitymanager.getTransaction( ).commit( );

				return true;
			}
			else
			{
				throw new RecordNotFoundException();
			}
		}
	}

	public Actor searchActor(int actorId) throws RecordNotFoundException, NegativeIdException, EmptyFieldException {
		if(actorId==0)
		{
			throw new EmptyFieldException();
		}
		else if(actorId<0)
			throw new NegativeIdException();
		else
		{

			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FMS");
			EntityManager entitymanager = emfactory.createEntityManager();
			Actor actor = entitymanager.find( Actor.class, actorId );
			if(actor!=null)
				return actor;
			else
				throw new RecordNotFoundException();

		}
	}

	public List<Actor> getAllActor() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FMS");
		EntityManager entitymanager = emfactory.createEntityManager();
		TypedQuery<Actor> query = entitymanager.createQuery("Select f from Actor f",Actor.class);
		return query.getResultList();
	}


}


