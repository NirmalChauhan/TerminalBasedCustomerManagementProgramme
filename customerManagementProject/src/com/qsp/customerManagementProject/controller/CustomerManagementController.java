package com.qsp.customerManagementProject.controller;

import java.util.*;

import com.qsp.customerManagementProject.dao.AdminDao;
import com.qsp.customerManagementProject.dto.Admin;
import com.qsp.customerManagementProject.dto.Customer;
import com.qsp.customerManagementProject.service.AdminService;

public class CustomerManagementController {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println(" Welcome to Customer Management portal choose one action to perform "
					+ "\n1.Edit Admin\n2.Login as Admin\n3.LogIn as Customer(under maintenance) not completed yet\n4.Exit");
			int ch = sc.nextInt();
			
			switch (ch) {
			
			//go to super user methods
			case 1: {
				
				SuperUserController suc= new SuperUserController();
				suc.superUserController();
			
			}break;
			
			//log in as admin 
			case 2: {
				
				Admin admin = new Admin();
				AdminService as = new AdminService();
				System.out.println("Welcome to admin login Page \nPlease enter your adminId, adminName and adminEmail");
				System.out.println("Enter the Admin Id");
				admin.setAdminId(sc.nextInt());
				System.out.println("Enter you Admin Name");
				String name = sc.next();
				name+=sc.nextLine();
				admin.setAdminName(name);
				System.out.println("Enter your Admin Email");
				admin.setAdminEmail(sc.next());
				
				boolean logedIn = as.logIn(admin);
				
				if(logedIn) {
					System.out.println("Welcome "+ name);
					AdminController ac = new AdminController();
					
					//admin methods branch to controller customer data base
				
					ac.start();
				
				}else {
					System.out.println("We don't know you");
				}

			}break;
			
			//log in as customer
			case 3: {
				  
				System.err.println("This option has been taken down it will come back after some time");
				Customer customer = new Customer();
				CustomerController cc = new CustomerController();
				AdminService as = new AdminService();
				System.out.println("Welcome to cutomer login Page \nPlease enter your CustomerId, CustomerName and CustomerEmail");
				System.out.println("Enter the Customer Id");
				customer.setCustomerId(sc.nextInt());
				System.out.println("Enter you Customer Name");
				String name = sc.next();
				name+=sc.nextLine();
				customer.setCustomerName(name);
				System.out.println("Enter your Customer Email");
				customer.setCustomerEmail(sc.next());
			
				boolean logedIn = as.customerLogIn(customer);
				
				if(logedIn) {
					System.out.println("Welcome "+ name);
					//customer methods branch to controller product data base
					System.out.println("fething your Product Id");
					
					int productId =  as.getProductId(customer.getCustomerId());
					cc.controllCustomer(productId,customer.getCustomerId());
				
				}else {
					System.out.println("We don't know you");
				}
				
			}break;
			
			//close the whole application 
			case 4: {
				System.exit(0);
			}break;
			
			}

		}
	}
}
