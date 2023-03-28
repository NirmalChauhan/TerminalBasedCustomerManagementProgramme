package com.qsp.customerManagementProject.dto;

public class Customer {
	
	private int customerId;
	private String customerName;
	private String customerEmail;
	private Long customerPhone;
	private Product product;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public Long getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(Long customerPhone) {
		this.customerPhone = customerPhone;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
