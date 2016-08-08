package com.flp.fms.service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.flp.ems.domain.Film;
import com.flp.fms.exception.EmptyFieldException;
import com.flp.fms.exception.NegativeIdException;
import com.flp.fms.exception.RecordNotFoundException;

public interface IFilmService 
{
	void addFilm(Map<Integer, Object> film) throws EmptyFieldException, RecordNotFoundException, NegativeIdException ;
	void modifyFilm(Map<String, Object> filmDetails) throws RecordNotFoundException, EmptyFieldException, NegativeIdException;
	boolean removeFilm(int filmId) throws NegativeIdException, EmptyFieldException, RecordNotFoundException;
	Film searchFilm(int filmId) throws NegativeIdException, EmptyFieldException, RecordNotFoundException;
	List<Film> getAllFilm();
	
}
