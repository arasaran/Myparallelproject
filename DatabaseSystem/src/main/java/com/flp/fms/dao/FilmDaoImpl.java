package com.flp.fms.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.flp.ems.domain.Category;
import com.flp.ems.domain.Film;
import com.flp.ems.domain.Language;
import com.flp.fms.exception.EmptyFieldException;
import com.flp.fms.exception.NegativeIdException;
import com.flp.fms.exception.RecordNotFoundException;

public class FilmDaoImpl implements IFilmDao
{
	public void addFilm(Film film) 
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FMS");  
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction().begin();
		entitymanager.persist(film);
		entitymanager.getTransaction( ).commit( );


	}

	public void modifyFilm(Film film) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FMS");  
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction().begin();
		entitymanager.merge(film);
		entitymanager.getTransaction( ).commit( );

	}

	public boolean removeFilm(int filmId) throws RecordNotFoundException, NegativeIdException, EmptyFieldException {
		if(filmId==0)
		{
			throw new EmptyFieldException();
		}
		else if(filmId<0)
			throw new NegativeIdException();
		else
		{

			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FMS");
			EntityManager entitymanager = emfactory.createEntityManager( );
			entitymanager.getTransaction( ).begin( );
			Film film = entitymanager.find( Film.class, filmId );
			if(film!=null)
			{
				entitymanager.remove( film );
				entitymanager.getTransaction( ).commit( );

				return true;
			}
			else
			{
				throw new RecordNotFoundException();
			}

		}
	}

	public Film searchFilm(int filmId) throws RecordNotFoundException, NegativeIdException, EmptyFieldException {

		if(filmId==0)
		{
			throw new EmptyFieldException();
		}
		else if(filmId<0)
			throw new NegativeIdException();
		else
		{

			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FMS");
			EntityManager entitymanager = emfactory.createEntityManager();
			Film film = entitymanager.find( Film.class, filmId );
			if(film != null)
			{
				return film;
			}
			else
				throw new RecordNotFoundException();

		}
	}

	public List<Film> getAllFilm() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FMS");
		EntityManager entitymanager = emfactory.createEntityManager();
		TypedQuery<Film> query = entitymanager.createQuery("Select f from Film f",Film.class);
		return query.getResultList();

	}

	public Language findLanguageByName(String languageName)
	{

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FMS");
		EntityManager entitymanager = emfactory.createEntityManager();
		TypedQuery<Language> typedQuery = entitymanager.createQuery("Select l from Language l where l.name='"+languageName+"' ",Language.class);
		if(typedQuery.getResultList().size() > 0)
		{
			return typedQuery.getSingleResult();
		}
		return null;
	}

	public Category findCategoryByName(String categoryName)
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FMS");
		EntityManager entitymanager = emfactory.createEntityManager();

		TypedQuery<Category> typedQuery = entitymanager.createQuery("Select c from Category c where c.name='"+categoryName+"' ",Category.class);
		if(typedQuery.getResultList().size() > 0)
		{
			return typedQuery.getSingleResult();
		}
		return null;

	}




}
