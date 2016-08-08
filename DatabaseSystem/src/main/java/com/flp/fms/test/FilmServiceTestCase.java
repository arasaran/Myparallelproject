package com.flp.fms.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.flp.ems.domain.Actor;
import com.flp.ems.domain.Category;
import com.flp.ems.domain.Film;
import com.flp.ems.domain.Language;
import com.flp.fms.dao.IActorDao;
import com.flp.fms.dao.IFilmDao;
import com.flp.fms.exception.DuplicateRecordException;
import com.flp.fms.exception.EmptyFieldException;
import com.flp.fms.exception.NegativeIdException;
import com.flp.fms.exception.RecordNotFoundException;
import com.flp.fms.service.ActorServiceImpl;
import com.flp.fms.service.FilmServiceImpl;
import com.flp.fms.service.IActorService;
import com.flp.fms.service.IFilmService;

public class FilmServiceTestCase {
	@Mock
	IFilmDao filmDao;
	IActorDao actorDao;
	IFilmService filmService;
	IActorService actorService;

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	@Before
	public void setUp() throws Exception {
	MockitoAnnotations.initMocks(this);
	 
	filmService=new FilmServiceImpl(filmDao);
	actorService=new ActorServiceImpl(actorDao);
	}

	//createFilm must return valid with valid inputs
	
	//createFilm must return null when any input is invalid


	/*@Test
	public void removeFilmWillReturnValidWithValidInputs() throws EmptyFieldException, NegativeIdException, RecordNotFoundException{
	Mockito.when(filmDao.removeFilm(3)).thenReturn(true);
	assertEquals(true,filmService.removeFilm(3));
	}*/
	//removeFilm must return null with null inputs
	@Test(expected = com.flp.fms.exception.EmptyFieldException.class)
	public void removeFilmWillReturnNullWithIdZero() throws EmptyFieldException, NegativeIdException, RecordNotFoundException{
	assertEquals(false,filmService.removeFilm(0));
	}
	//removeFilm must return null when record is not present
	/*@Test(expected = com.flp.fms.exception.RecordNotFoundException.class)
	public void removeFilmWillReturnNullWithNoRecord() throws EmptyFieldException, NegativeIdException, RecordNotFoundException{
	Film film=new Film();
	Mockito.when(filmService.searchFilm(1)).thenReturn(null);
	assertEquals(false,filmService.removeFilm(1));
	}
	*/
	//removeFilm must return null with invalid inputs

	@Test(expected = com.flp.fms.exception.NegativeIdException.class)
	public void whenTheidIsZeroInRemoveFilmThrowException() throws EmptyFieldException, NegativeIdException, RecordNotFoundException
	{
	filmService.removeFilm(-10);
	}
	//modifyFilm will return valid with valid inputs
	/*@Test
	public void modifyFilmWillReturnValidWithValidInput() throws ParseException, IllegalArgumentException{
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	Film film=new Film();
	Film film2=new Film();
	Map<Integer,Object> film1=new HashMap();
	film1.put(1, 3);
	film1.put(2,"xyz");
	film1.put(3,"This film is an epic.");
	film1.put(4,dateFormat.parse("20-03-1998"));
	film1.put(5,2);
	film1.put(6,4);
	film1.put(7,3);
	film1.put(8,9.0);
	film1.put(9,4);
	film1.put(10,"action");
	film1.put(11,new Language("telugu"));
	film1.put(12,new Category("action"));
	film1.put(13,new HashSet<Actor>());
	Mockito.when(filmDao.searchFilm(3)).thenReturn(film2);
	        Mockito.when(filmDao.modifyFilm(film2)).thenReturn("success");
	        assertEquals("success",filmService.modifyFilm(film1));
	        
	}
	*/ 

	//searchFilm must return null with  null inputs
	@Test(expected = com.flp.fms.exception.EmptyFieldException.class)
	public void whenTheidIsZeroInSearchFilmThrowException() throws EmptyFieldException, NegativeIdException, RecordNotFoundException
	{
	filmService.searchFilm(0);
	}
	//searchFilm must return null with  invalid inputs
	@Test(expected = com.flp.fms.exception.NegativeIdException.class)
	public void whenTheidIsNegativeInSearchFilmThrowException() throws EmptyFieldException, NegativeIdException, RecordNotFoundException
	{
	filmService.searchFilm(-1);
	}
	//searchFilm must return valid with  valid inputs
/*	@Test
	public void whenTheidIsValidInSearchFilmItShouldReturnValid() throws EmptyFieldException, NegativeIdException, RecordNotFoundException
	{
	Film film=new Film();
	Mockito.when(filmDao.searchFilm(4)).thenReturn(film);
	assertEquals(film,filmService.searchFilm(4));
	}
	//searchFilm must return null with  no record
*/	@Test(expected = com.flp.fms.exception.RecordNotFoundException.class)
	public void whenTheidIsNotPresentInSearchFilmThrowException() throws EmptyFieldException, NegativeIdException, RecordNotFoundException
	{
	filmService.searchFilm(121);
	}

	}

