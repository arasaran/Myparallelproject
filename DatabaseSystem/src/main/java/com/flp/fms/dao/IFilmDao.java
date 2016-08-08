package com.flp.fms.dao;

import java.util.List;

import com.flp.ems.domain.Category;
//import com.flp.ems.domain.Actor;
import com.flp.ems.domain.Film;
import com.flp.ems.domain.Language;
import com.flp.fms.exception.EmptyFieldException;
import com.flp.fms.exception.NegativeIdException;
import com.flp.fms.exception.RecordNotFoundException;


public interface IFilmDao {
	void addFilm(Film film);
	void modifyFilm(Film film);
	boolean removeFilm(int filmId) throws RecordNotFoundException, NegativeIdException, EmptyFieldException;
	Film searchFilm(int filmId) throws RecordNotFoundException, NegativeIdException, EmptyFieldException;
	List<Film> getAllFilm();
	Language findLanguageByName(String string);
	Category findCategoryByName(String string);
	
	

}

