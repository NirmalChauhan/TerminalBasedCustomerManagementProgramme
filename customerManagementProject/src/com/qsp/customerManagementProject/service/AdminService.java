package com.qsp.customerManagementProject.service;

import com.qsp.customerManagementProject.dao.AdminDao;
import com.qsp.customerManagementProject.dto.Admin;
import com.qsp.customerManagementProject.dto.Customer;
import com.qsp.customerManagementProject.dto.Product;

public class AdminService {
	
	AdminDao dao = new AdminDao();
	//super user methods 
	public String insertAdmin(Admin admin) {
		String confirmation = null;
		if(admin.getAdminName().length()<=8) {
			confirmation = dao.insertAdmin(admin);
			return confirmation;
		}else {
			System.err.println("Error : Name of the admin should be equal to or less then 8 characters. ");
		}
		return "something went Wrong in admin insert service"; 
	}
	
	public String update(Admin admin, Admin admin2) {
		if(dao.logIn(admin)) {
			dao.update(admin2);
			return "Admin updated successfully";
		}else {
			return "Provided Admin credetianls were not present";
		}
	}
	
	public String delete(int id) {
		if(dao.getById(id)==id) {
			dao.delete(id);
			return "Deletion was successfull";
		}
		else {
			 return "Provided ID was incorrect";
		}
	}
	
	//================admin roles=====================================//
	//admin login methods
	public boolean logIn(Admin admin) {
		if(dao.logIn(admin)) {
		 
			return true;
		}else {
			return false;
		}
	}
	
	//insert customer
	public String insertCustomer(Customer customer, int productId) {
		String confirmation = null;
		if(customer.getCustomerName().length()<=15) {
			confirmation = dao.insertCustomer(customer, productId);
			return confirmation;
		}else {
			System.err.println("Error : Name of the admin should be equal to or less then 8 characters. ");
		}
		return "something went Wrong in admin insert service";
	}
	
	//delete customer
	public String deleteCustomer(int customerId) {
		if(dao.getCustomerById(customerId)==customerId) {
			dao.deleteCustomer(customerId);
			return "Deletion was successfull";
		}
		else {
			 return "Provided ID was incorrect";
		}
	}

	//update customer	
	public String updateCustomer(Customer customer, int productId) {
		if(dao.getCustomerById(customer.getCustomerId())==customer.getCustomerId()) {
			dao.updateCustomer(customer, productId);
			
		}else {
			return "Provided Customer Id credetianls was incorrect or not present";
		}
		return null;
	}


	//================customer roles=====================================//

	//customer login methods
		public boolean customerLogIn(Customer customer) {
			if(dao.customerLogIn(customer)) {
				return true;
			}else {
				return false;
			}
		}
	//assigning product id to customer 
		public int getProductId(int customerId) {
			int temp =dao.getProductId(customerId);
			return temp;
		}
	
		//add product
		public String addProduct(Product product) {
			
			if(product.getProductPrice()<=7000) {
				
				String confirmation = dao.addProduct(product);
				return confirmation;
			}
			return "amount should be less then or equal to 7000";
			
		}
		
		//update price
		public String updatePrice(Product product) {
			
			if(product.getProductPrice()<=7000) {
				
				String confirmation = dao.updatePrice(product);
				return confirmation;
			}
			return "amount should be less then or equal to 7000";
			
		}
		//update availability
		public String updateAvailable(Product product) {
				String confirmation = dao.updateAvailable(product);
				return confirmation;
		}
		
		//update product Name
		public String updateName(Product product) {
			String confirmation = dao.updateName(product);
			return confirmation;
			
		}

		//display Customer
		public Customer displayCustomer(int customerId) {
			Customer customer = dao.displayCustomer(customerId);
			return customer;
			
		}
		//display product
		public Product displayProduct(int productId) {
			Product product = dao.displayProduct(productId);
			return product;
			
		}

	 










}
