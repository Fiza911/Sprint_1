package com.demo.restaurant_reservation_system;
import java.util.Scanner;
import static com.demo.restaurant_reservation_system.AllOperations.*;
public class MainOperations 
{
	static Scanner sc=new Scanner(System.in);
	public static void mainOps()
	{
		boolean loggedIn=false;
		while(!loggedIn)
		{
			//For choosing login type
			System.out.println("Select login type: 1. Admin  2. Customer");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				//For admin login
				loggedIn=adminLogin();
				System.out.println("=======================================");
				break;
			case 2:
				//For customer login
				loggedIn=customerLogin();
				System.out.println("=======================================");
				break;
			default:
				System.out.println("Invalid choice. Please try again." );
			}
		}
	}
	public static void main(String[] args)
	{		
		mainOps();
	}
}
