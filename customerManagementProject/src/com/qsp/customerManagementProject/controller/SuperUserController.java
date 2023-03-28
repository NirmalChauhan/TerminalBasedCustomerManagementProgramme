package com.qsp.customerManagementProject.controller;

import java.util.Scanner;

import com.qsp.customerManagementProject.dto.Admin;
import com.qsp.customerManagementProject.service.AdminService;

public class SuperUserController {

	public void superUserController() {
		
		Scanner sc = new Scanner(System.in);
		AdminService as = new AdminService();
		boolean exit = true;
		while(exit){
			
			System.out.println("Welcome to Super User portal choose one action to perform on admins Database\n1.InsertAdmin\n2.UpdateAdmin\n3.DeleteAdmin\n4.Previous Menu");
			int ch = sc.nextInt();
			switch (ch) {
			case 1: {
				
				int temp;
				do {
					Admin admin = new Admin();
					
					System.out.println("Enter the Admin Id");
					admin.setAdminId(sc.nextInt());
					
					System.out.println("Enter the 8 character Admin Name");
					
					String name = sc.next();
					name+=sc.nextLine();
					admin.setAdminName(name);
					
					System.out.println("Enter the Admin Email");
					admin.setAdminEmail(sc.next());
					
					String confirmation = as.insertAdmin(admin);
					System.out.println(confirmation);
					System.out.println("Enter 0 to add again and 1 to go to previous menu");
					temp = sc.nextInt();
					 
				}while(temp==0);
				 
			}break;
			case 2: {
				int temp;
				do {
					Admin admin = new Admin();
					
					System.out.println("Enter the Admin Id");
					int adminId = sc.nextInt();
					admin.setAdminId(adminId);
					System.out.println("Enter Confrim Old the 8 character Admin Name");					
					String name = sc.next();
					name+=sc.nextLine();
					admin.setAdminName(name);	
					System.out.println("Enter Confirm old the Admin Email");
					admin.setAdminEmail(sc.next());
					
					Admin admin2 = new Admin();
					admin2.setAdminId(adminId);
					System.out.println("Enter New the 8 character Admin Name");					
					admin2.setAdminName(sc.next());	
					System.out.println("Enter New the Admin Email");
					admin2.setAdminEmail(sc.next());
					
					String confirmation = as.update(admin, admin2);
					System.out.println(confirmation);
					System.out.println("Enter 0 to update another and 1 to go to previous menu");
					temp = sc.nextInt();
					
				}while(temp==0);
				 
			}break;
			case 3: {
			
				int temp=0;
				do {
					System.out.println("Please enter the Admin Id you wish to remove");
					int adminId = sc.nextInt();
					
					String confirmation = as.delete(adminId);
					
					System.out.println(confirmation);
					System.out.println("Enter 0 to Delete another and 1 to go to previous menu");
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
