package com.flp.fms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.flp.ems.domain.Actor;
import com.flp.fms.dao.ActorDaoImpl;
import com.flp.fms.dao.IActorDao;
import com.flp.fms.exception.EmptyFieldException;
import com.flp.fms.exception.NegativeIdException;
import com.flp.fms.exception.RecordNotFoundException;


public class ActorServiceImpl implements IActorService
{
	IActorDao actorDao=new ActorDaoImpl();

	public ActorServiceImpl()
	{
		
	}
	
	public ActorServiceImpl(IActorDao actorDao2) {
		// TODO Auto-generated constructor stub
	}




	public Actor addActor(HashMap<Integer, Object> actorSet) throws EmptyFieldException
	{
		Actor actor=new Actor();
		actor.setFirstName((String) actorSet.get(1));
		actor.setLastName((String) actorSet.get(2));
		return actorDao.addActor(actor);
	}
	
	
	public Actor modifyActor(int actorId,String firstName,String lastName) {
		Actor actor=new Actor();
		actor.setActorId(actorId);
		actor.setFirstName( firstName);
		actor.setLastName(lastName);
		return actorDao.modifyActor(actor);
	
	}
	
	public boolean removeActor(int actorId) throws EmptyFieldException, NegativeIdException, RecordNotFoundException  {
		if(actorId==0)
			throw new EmptyFieldException();
		else if(actorId<0)
			throw new NegativeIdException();
		else
		return actorDao.removeActor(actorId);
	}

	
	public Actor searchActor(int actorId) throws EmptyFieldException, NegativeIdException, RecordNotFoundException {
		if(actorId==0)
			throw new EmptyFieldException();
		else if(actorId<0)
			throw new NegativeIdException();
		else
		return actorDao.searchActor(actorId);
	}

	
	public List<Actor> getAllActor() {
		return actorDao.getAllActor();
	}
}
