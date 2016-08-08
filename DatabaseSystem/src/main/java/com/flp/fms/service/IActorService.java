package com.flp.fms.service;

import java.util.HashMap;
import java.util.List;

import com.flp.ems.domain.Actor;
import com.flp.fms.exception.EmptyFieldException;
import com.flp.fms.exception.NegativeIdException;
import com.flp.fms.exception.RecordNotFoundException;

public interface IActorService {

	Actor addActor(HashMap<Integer, Object> actorSet) throws EmptyFieldException;

	Actor modifyActor(int actorId,String firstName,String lastName);

	boolean removeActor(int actorId) throws EmptyFieldException, NegativeIdException, RecordNotFoundException;

	Actor searchActor(int actorId) throws EmptyFieldException, NegativeIdException, RecordNotFoundException;

	List<Actor> getAllActor();

	

}