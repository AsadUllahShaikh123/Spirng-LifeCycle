package com.spring_life_cycle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {

	private String driver;
	private String url ;
	private String userName ;
	private String password ;
	
	
	Connection connection;
	

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);

	    connection = DriverManager.getConnection(url, userName, password);
	}
	
	
	public void selectAllRows() throws ClassNotFoundException, SQLException {
		
		String sql = " select * from student";
		getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			int id = result.getInt("id");
			String name = result.getString("name");
			String address = result.getString("address");

			System.out.println("Id : " + id + " Name : " + name + " Address : " + address);
		}
		connection.close();
	}

	public void deleteStudent(int id) throws ClassNotFoundException, SQLException {
		getConnection();
		String sql = " delete from student where id = ? ";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		statement.executeUpdate();
		
		connection.close();
	}

}
