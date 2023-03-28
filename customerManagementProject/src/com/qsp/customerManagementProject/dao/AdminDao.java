package com.qsp.customerManagementProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.qsp.customerManagementProject.connection.JDBCConnection;
import com.qsp.customerManagementProject.dto.Admin;
import com.qsp.customerManagementProject.dto.Customer;
import com.qsp.customerManagementProject.dto.Product;

public class AdminDao {

	Connection connection = null;

//super user methods=============================================================================// 	
	// insert admin method
	public String insertAdmin(Admin admin) {

		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;

		if (connection != null) {
			try {

				String InsertAdmin = "INSERT INTO admin VALUES(?,?,?)";
				ps = connection.prepareStatement(InsertAdmin);
				ps.setInt(1, admin.getAdminId());
				ps.setString(2, admin.getAdminName());// this should be of 8
				ps.setString(3, admin.getAdminEmail());

				ps.execute();

				return "Admin was successfully stored";
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		} else {
			System.out.println("Please check your url or username or password");
		}

		return "Something went wrong in Admin Insert dao";
	}

	// update admin with name and email
	public void update(Admin admin) {

		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;
		if (connection != null) {
			try {

				String update = "UPDATE admin SET adminName=?, adminEmail=? WHERE adminId=?";

				ps = connection.prepareStatement(update);

				ps.setString(1, admin.getAdminName());
				ps.setString(2, admin.getAdminEmail());
				ps.setInt(3, admin.getAdminId());

				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		} else {
			System.out.println("Please check your url or username or password");
		}

	}

	// delete admin
	public void delete(int adminId) {

		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;

		if (connection != null) {
			try {

				String delete = "DELETE FROM admin WHERE adminId=?";

				ps = connection.prepareStatement(delete);

				ps.setInt(1, adminId);

				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		} else {
			System.out.println("Please check your url or username or password");
		}
	}

	// get by admin id
	public int getById(int id) {

		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;

		int temp = 0;

		if (connection != null) {
			try {

				String getById = "SELECT * from admin where adminId = ?";

				ps = connection.prepareStatement(getById);
				ps.setInt(1, id);
				ResultSet resultSet = ps.executeQuery();
				while (resultSet.next()) {
					temp = resultSet.getInt("adminId");
				}
				return temp;

			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}

		} else {
			System.out.println("Please check your url or username or password");
		}

		return 0;
	}

//logged in addmin dao methods=============================================================================//

	// admin login name and email confirmation
	public boolean logIn(Admin admin) {

		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;

		String tempName = null;
		String tempEmail = null;

		if (connection != null) {
			try {

				String getById = "SELECT * from admin where adminId = ?";

				ps = connection.prepareStatement(getById);
				ps.setInt(1, admin.getAdminId());
				ResultSet resultSet = ps.executeQuery();
				while (resultSet.next()) {
					tempName = resultSet.getString("adminName");
					tempEmail = resultSet.getString("adminEmail");
				}
				if ( tempName.equals(admin.getAdminName()) && tempEmail.equals(admin.getAdminEmail()) ) {
						return true;
				}

			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}

		} else {
			System.out.println("Please check your url or username or password");
		}

		return false;
	}

	// insert Customer
	public String insertCustomer(Customer customer, int productId) {
		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;
		
		if (connection != null) {
			try {
				
				String inserProductId = "INSERT INTO product (productId) VALUES(?)";
				ps = connection.prepareStatement(inserProductId);
				ps.setInt(1, productId);
				ps.execute();
				System.out.println("1");
				
				String insertCustomer = "INSERT INTO customer VALUES(?,?,?,?,?)";
				ps = connection.prepareStatement(insertCustomer);
				System.out.println("2");
				ps.setInt(1, customer.getCustomerId());
				ps.setString(2, customer.getCustomerName());//this should be of 15
				ps.setString(3, customer.getCustomerEmail());
				ps.setLong(4, customer.getCustomerPhone());
				ps.setInt(5, productId);
				System.out.println("3");
				ps.execute();
				System.out.println("4");
			
				
				return "Customer was successfully stored";
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		} else {
			System.out.println("Please check your url or username or password");
		}
		
		return "Something went wrong in CustomerInsert dao";
	}

	// get by Customer id
	public int getCustomerById(int customerId) {

			connection = JDBCConnection.getJdbcConnection();
			PreparedStatement ps = null;

			int temp = 0;

			if (connection != null) {
				try {

					String getById = "SELECT * from customer where customerId = ?";

					ps = connection.prepareStatement(getById);
					ps.setInt(1, customerId);
					ResultSet resultSet = ps.executeQuery();
					while (resultSet.next()) {
						temp = resultSet.getInt("customerId");
					}
					return temp;

				} catch (SQLException e) {
					e.printStackTrace();

				} finally {
					try {
						connection.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}

			} else {
				System.out.println("Please check your url or username or password");
			}
			return 0;
		}

	// delete Customer
	public void deleteCustomer(int customerId) {
		
		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;

		if (connection != null) {
			try {

				String delete = "DELETE customer.*,product.* FROM customer "
						+ "INNER JOIN product on customer.productId=product.productId "
						+ "WHERE customerId=?"; 
				ps = connection.prepareStatement(delete);

				ps.setInt(1, customerId);

				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		} else {
			System.out.println("Please check your url or username or password");
		}

		
	}

	// update Customer
	public void updateCustomer(Customer customer, int productId) {
		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;
		if (connection != null) {
			try {

				String update = "UPDATE customer INNER JOIN product ON " + "customer.productId=product.productId "
						+ "SET customer.customerId=?,"
						+ "customer.customerEmail=?,customer.customerPhone=? "
						+ "WHERE customer.productId=?";

				ps = connection.prepareStatement(update);

				ps.setInt(1, customer.getCustomerId());
				ps.setString(2, customer.getCustomerEmail());
				ps.setLong(3, customer.getCustomerPhone());
				ps.setInt(4, productId);

				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		} else {
			System.out.println("Please check your url or username or password");
		 }
	}

//logged in customer dao methods=============================================================================//
	
	//customer login method 
	public boolean customerLogIn(Customer customer) {

		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;

		String tempName = null;
		String tempEmail = null;

		if (connection != null) {
			try {

				String getById = "SELECT * from customer where customerId = ?";

				ps = connection.prepareStatement(getById);
				ps.setInt(1, customer.getCustomerId());
				ResultSet resultSet = ps.executeQuery();
				while (resultSet.next()) {
					tempName = resultSet.getString("customerName");
					tempEmail = resultSet.getString("customerEmail");
				}
				if ( tempName.equals(customer.getCustomerName()) && tempEmail.equals(customer.getCustomerEmail()) ) {
						return true;
				}

			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}

		} else {
			System.out.println("Please check your url or username or password");
		}

		return false;
	}

	//get product Id
	public int getProductId(int customerId) {

		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;

		int temp = 0;

		if (connection != null) {
			try {

				String getProductId = "SELECT * from customer where customerId = ?";

				ps = connection.prepareStatement(getProductId);
				ps.setInt(1, customerId);
				ResultSet resultSet = ps.executeQuery();
				while (resultSet.next()) {
					temp = resultSet.getInt("productId");
				}
				return temp;

			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}

		} else {
			System.out.println("Please check your url or username or password");
		}
		return 0;
	} 
 

	//add Product 
	public String addProduct(Product product) {
		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;
		if (connection != null) {
			try {

				String update = "UPDATE product SET productName=?, productPrice=?, productAvailable=? WHERE productId=?";

				ps = connection.prepareStatement(update);

				ps.setString(1, product.getProductName() );
				ps.setDouble(2, product.getProductPrice());
				ps.setBoolean(3, product.getProductAvailable());
				ps.setInt(4, product.getProductId());

				ps.executeUpdate();
			
				return "data inserted";
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			
		} else {
			System.out.println("Please check your url or username or password");
		 }
		return "data not inserted";
	}
	
	//update product price 
	public String updatePrice(Product product) {
		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;
		if (connection != null) {
			try {

				String update = "UPDATE product SET productPrice=? WHERE productId=?";

				ps = connection.prepareStatement(update);
				
				ps.setDouble(1, product.getProductPrice());
				
				ps.setInt(2, product.getProductId());

				ps.executeUpdate();
			
				return "data updated";
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			
		} else {
			System.out.println("Please check your url or username or password");
		 }
		return "data not inserted";
	}
	
	//update product availability 
	public String updateAvailable(Product product) {
		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;
		if (connection != null) {
			try {

				String update = "UPDATE product SET productAvailable=? WHERE productId=?";

				ps = connection.prepareStatement(update);
				
				ps.setBoolean(1, product.getProductAvailable());
				
				ps.setInt(2, product.getProductId());

				ps.executeUpdate();
			
				return "data updated";
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			
		} else {
			System.out.println("Please check your url or username or password");
		 }
		return "data not updated";
	}

	// update name 
	public String updateName(Product product) {
		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;
		if (connection != null) {
			try {

				String update = "UPDATE product SET productName=? WHERE productId=?";

				ps = connection.prepareStatement(update);

				ps.setString(1, product.getProductName());
				ps.setInt(2, product.getProductId());

				ps.executeUpdate();
			
				return "Name updated ";
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			
		} else {
			System.out.println("Please check your url or username or password");
		 }
		return "Name not updated";
		
	}
	
	//display customer
	public Customer displayCustomer(int customerId) {

		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;
		if (connection != null) {
			try {
				System.out.println("in display customer try block");
				String displayCustomer = "SELECT * from customer where customerId = ?";
				
				ps = connection.prepareStatement(displayCustomer);
				
				ps.setInt(1, customerId);
				
				ResultSet resultSet = ps.executeQuery();

				Customer customer = new Customer();

				while (resultSet.next()) {
					customer.setCustomerName(resultSet.getString("customerName"));
					customer.setCustomerEmail(resultSet.getString("customerEmail"));
					customer.setCustomerPhone(resultSet.getLong("customerPhone"));
				}

				return customer;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		} else {
			System.out.println("Please check your url or username or password");
		}

		return null;
	}

	//display product
	public Product displayProduct(int productId) {
		
		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;
		if (connection != null) {
			try {
				System.out.println("in display product try block");
				String displayCustomer = "SELECT * from product where productId = ?";
				
				ps = connection.prepareStatement(displayCustomer);
				
				ps.setInt(1, productId);
				
				ResultSet resultSet = ps.executeQuery();

				Product product = new Product(); 

				while (resultSet.next()) {
				 product.setProductName(resultSet.getString("productName"));
				 product.setProductPrice(resultSet.getDouble("productPrice"));
				 product.setProductAvailable(resultSet.getBoolean("productAvailable"));
				}

				return product;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		} else {
			System.out.println("Please check your url or username or password");
		}

		
		return null;
	}
	
}//class
