package com.flp.fms.dao;

import java.util.List;

import com.flp.ems.domain.Actor;
import com.flp.fms.exception.EmptyFieldException;
import com.flp.fms.exception.NegativeIdException;
import com.flp.fms.exception.RecordNotFoundException;

public interface IActorDao {
	Actor addActor(Actor actor) throws EmptyFieldException;
	Actor modifyActor(Actor actor);
	boolean removeActor(int actorId) throws RecordNotFoundException, NegativeIdException, EmptyFieldException;
	Actor searchActor(int actorId) throws RecordNotFoundException, NegativeIdException, EmptyFieldException;
	List<Actor> getAllActor();

}
