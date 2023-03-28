package com.qsp.customerManagementProject.controller;

import java.util.Scanner;

import com.qsp.customerManagementProject.dto.Customer;
import com.qsp.customerManagementProject.dto.Product;
import com.qsp.customerManagementProject.service.AdminService;

public class CustomerController {

	
	public void controllCustomer(int productId, int customerId) {
	
		AdminService as = new AdminService();
		
		Product product = new Product();
				
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Product Id assigned to you by admin is "+productId);

		
		boolean keepIt = true;
		while (keepIt) {
			
			System.out.println("Choose one option \n1. UpdateWholeProduct\n2. UpdateProductPrice \n3. UpdateProductAvailabile \n4. updateProductName\n5. DisplayCustomerDetails \n6. DisplayProductDetails \n7. Previous Menu");
			int ch = sc.nextInt();
			
			switch (ch) {
			
			//add product
			case 1: {
					
					product.setProductId(productId);
					
					System.out.println("Enter the Product name ");
					String pName = sc.next();
					pName+=sc.nextLine();
					product.setProductName(pName);
					
					System.out.println("Is this product availabe currently(yes or no)");
					String availabe = sc.next();
					if(availabe.equalsIgnoreCase("yes")) {
						product.setProductAvailable(true);
					}else {
						product.setProductAvailable(false);
					}
						
					System.out.println("Enter the Product Price");
					product.setProductPrice(sc.nextDouble());
											
					String confirmation = as.addProduct(product);
					
					System.out.println(confirmation);
				
			}break;
			
			//update product price
			case 2: {
				System.out.println("Enter the new Price");
				
				product.setProductPrice(sc.nextDouble());
				product.setProductId(productId);
				System.out.println(as.updatePrice(product));				
				
			}break;
			
			//update product availability
			case 3: {

				System.out.println("Is your product availabe currently(yes or no)");
				String availabe = sc.next();
				if(availabe.equalsIgnoreCase("yes")) {
					product.setProductAvailable(true);
				}else {
					product.setProductAvailable(false);
				}
				product.setProductId(productId);
				System.out.println(as.updateAvailable(product));
				
			}break;
			
			//update product name
			case 4: {
				
				System.out.println("Enter the new Product name ");
				String pName = sc.next();
				pName+=sc.nextLine();
				product.setProductName(pName);
				
				product.setProductId(productId);
				
				String confirmation = as.updateName(product);
				
				System.out.println(confirmation);
				
			}break;
			
			//display customer details
			case 5:{
				Customer customer = as.displayCustomer(customerId);
				System.out.println("Customer Id : " +customerId);
				System.out.println("Customer Name : "+customer.getCustomerName());
				System.out.println("Customer email : "+ customer.getCustomerEmail());
				System.out.println("Customer Phone : "+ customer.getCustomerPhone());
				System.out.println("Assigned product id : "+ productId);
				
			}break;
			
			//display product details
			case 6: {
				Product product1  = as.displayProduct(productId);
				
				System.out.println("Product Id : " +productId);
				System.out.println("Product Name : "+product1.getProductName());
				System.out.println("Product Price : "+ product1.getProductPrice());
				System.out.println("Product Availabilty : "+ product1.getProductAvailable());
		
			}break;
			
			//previous menu
			case 7: {
				keepIt = false;
			}break;
			

			}//switch
			
			
		}//main while loop
	
		
	}//method
	
}//class
