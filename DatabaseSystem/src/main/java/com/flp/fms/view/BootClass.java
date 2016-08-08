package com.flp.fms.view;

import java.text.ParseException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.flp.fms.exception.DuplicateRecordException;
import com.flp.fms.exception.EmptyFieldException;
import com.flp.fms.exception.NegativeIdException;
import com.flp.fms.exception.RecordNotFoundException;

public class BootClass 
{
	static BootClass bootClass=new BootClass();
	UserInteraction userInterface=new UserInteraction();
	public static void main(String args[]) throws ParseException, DuplicateRecordException, EmptyFieldException, RecordNotFoundException, NegativeIdException
	{	
		Scanner sc=new Scanner(System.in);
		while(true)
		{
		System.out.println("Enter a choice");
		System.out.println("1. Add Film 2.Modify Film 3.Remove Film  4.Get details of the film based on ID 5. Get all films  ");
		System.out.println("6.Add Actor 7.Modify actor 8.Remove actor  9.Get details of the actor based on ID 10. Get all actors 11.Exit ");
		int choice=sc.nextInt();
		bootClass.menuSelection(choice);
		}
	}

	private void menuSelection(int choice) throws ParseException, DuplicateRecordException, EmptyFieldException, RecordNotFoundException, NegativeIdException
	{
		switch(choice)
		{
		case 1:userInterface.addFilm();
		break;
		case 2:userInterface.modifyFilm();
		break;
		case 3:userInterface.removeFilm();
		break;
		case 4:userInterface.searchFilm();
		break;
		case 5:userInterface.getAllFilm();
		break;
		case 6:userInterface.addActor();
		break;
		case 7:userInterface.modifyActor();
		break;
		case 8:userInterface.removeActor();
		break;
		case 9:userInterface.searchActor();
		break;
		case 10:userInterface.getAllActor();
		break;
		default:System.out.println("Inavalid Menu Selection");
		break;
		case 11:System.exit(0);
		break;
		}
	}
}
