package com.flp.fms.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.flp.ems.domain.Actor;
import com.flp.fms.dao.IActorDao;
import com.flp.fms.exception.EmptyFieldException;
import com.flp.fms.exception.NegativeIdException;
import com.flp.fms.exception.RecordNotFoundException;
import com.flp.fms.service.ActorServiceImpl;
import com.flp.fms.service.IActorService;



public class ActorServiceTestCase {


	@Mock
	IActorDao actorDao;
	IActorService actorService;

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	@Before
	public void setUp() throws Exception {
	MockitoAnnotations.initMocks(this);
	 
	actorService=new ActorServiceImpl(actorDao);
	}

	//removeActor must return valid when inputs are valid
	/*@Test
	public void removeFilmWillReturnValidWithValidInputs() throws EmptyFieldException, NegativeIdException, RecordNotFoundException{
	Mockito.when(actorDao.removeActor(1)).thenReturn(true);
	assertEquals(true,actorService.removeActor(1));
	}*/
	//removeActor must return null with null inputs
	@Test(expected = com.flp.fms.exception.EmptyFieldException.class)
	public void removeActorWillReturnNullWithIdZero() throws EmptyFieldException, NegativeIdException, RecordNotFoundException{
	assertEquals(false,actorService.removeActor(0));
	}
	
	//removeActor must return null when record is not present
/*	@Test(expected = com.flp.fms.exception.RecordNotFoundException.class)
	public void removeActorWillReturnNullWithNoRecord() throws EmptyFieldException, NegativeIdException, RecordNotFoundException{
	Actor actor=new Actor();
	Mockito.when(actorService.searchActor(2)).thenReturn(null);
	assertEquals(false,actorService.removeActor(2));
	}*/

	//removeActor must return null with invalid inputs

	@Test(expected = NegativeIdException.class)
	public void whenTheidIsZeroInRemoveActorThrowException() throws EmptyFieldException, NegativeIdException, RecordNotFoundException
	{
	actorService.removeActor(-10);
	}
	
	//searchActor must return null with  null inputs
	@Test(expected = EmptyFieldException.class)
	public void whenTheidIsZeroInSearchActorThrowException() throws EmptyFieldException, NegativeIdException, RecordNotFoundException
	{
	actorService.searchActor(0);
	}
	//searchActor must return null with  invalid inputs
	@Test(expected = com.flp.fms.exception.NegativeIdException.class)
	public void whenTheidIsNegativeInSearchActorThrowException() throws EmptyFieldException, NegativeIdException, RecordNotFoundException
	{
	actorService.searchActor(-1);
	}
	//searchActor must return valid with  valid inputs
	/*@Test
	public void whenTheidIsValidInSearchActorItShouldReturnValid() throws EmptyFieldException, NegativeIdException, RecordNotFoundException
	{
	Actor actor=new Actor();
	Mockito.when(actorDao.searchActor(2)).thenReturn(actor);
	assertEquals(actor,actorService.searchActor(2));
	}*/
	//searchActor must return null with  no record
	/*@Test(expected = com.flp.fms.exception.RecordNotFoundException.class)
	public void whenTheidIsNotPresentInSearchActorThrowException() throws EmptyFieldException, NegativeIdException, RecordNotFoundException
	{
	actorService.searchActor(1);
	}*/
	}

