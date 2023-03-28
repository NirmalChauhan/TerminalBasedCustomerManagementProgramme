package com.qsp.customerManagementProject.controller;

import java.util.Scanner;

import com.qsp.customerManagementProject.dto.Admin;
import com.qsp.customerManagementProject.dto.Customer;
import com.qsp.customerManagementProject.service.AdminService;

public class AdminController {

	public void start() {
		
		Scanner sc = new Scanner(System.in);
		AdminService as = new AdminService();
		boolean exit = true;
		while(exit){
			
			System.out.println("Welcome to admin portal choose one action to perform on Customer Database\n1.AddCustomer\n2.DeleteCustomer\n3.UpdateCustomer\n4.Previous Menu");
			int ch = sc.nextInt();
			switch (ch) {
			//add customer
			case 1: {
				
				int temp;
				do {
					Customer customer = new Customer();
					
					System.out.println("Enter the Customer Id");
					customer.setCustomerId(sc.nextInt());
					
					System.out.println("Enter the Customer Name");
					
					String name = sc.next();
					name+=sc.nextLine();
					customer.setCustomerName(name);
					
					System.out.println("Enter the customer Email");
					customer.setCustomerEmail(sc.next());
					
					System.out.println("Enter the customer phone number ");
					customer.setCustomerPhone(sc.nextLong());
					
					System.out.println("enter the Assigned the product Id");
					
					int productId = sc.nextInt();
					
					String confirmation = as.insertCustomer(customer, productId);
					System.out.println(confirmation);
					System.out.println("Enter 0 to add again and 1 to go to previous menu");
					temp = sc.nextInt();
					 
				}while(temp==0);
				 
			}break;

			//delete customer
			case 2: {
				int temp;
				do {
					
					System.out.println("Enter the Customer Id");
					int customerId = sc.nextInt();
				 
					String confirmation = as.deleteCustomer(customerId);
					System.out.println(confirmation);
					System.out.println("Enter 0 to delete again and 1 to go to previous menu");
					temp = sc.nextInt();
					
				}while(temp==0);
				 
			}break;
			
			//update customer 
			case 3: {
			
				int temp=0;
				do {
					Customer customer = new Customer();
					
					System.out.println("Enter the Customer Id you want to update");
					customer.setCustomerId(sc.nextInt());
					
					System.out.println("Enter the new customer Email");
					String email = sc.next();
					email+=sc.nextLine();
					customer.setCustomerEmail(email);
					
					System.out.println("Enter the new customer phone number ");
					customer.setCustomerPhone(sc.nextLong());
					
					System.out.println("enter the Assigned the product Id ");
					int productId = sc.nextInt();
					
					String confirmation = as.updateCustomer(customer, productId );
					
					System.out.println(confirmation);
					System.out.println("Enter 0 to update another and 1 to go to previous menu");
					temp = sc.nextInt();
					
				} while (temp==0);
				 
			}break;
		
			case 4:{
				exit = false;
			}break;
	
		}
			
		}	
	}
}
