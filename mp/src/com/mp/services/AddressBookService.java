package com.mp.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mp.javabean.AddressBookBean;

public class AddressBookService {
	static String url =("jdbc:mysql://localhost:3306/mp");
	static String username ="root";
	static String password = "password";
	
	public void addEmployee(AddressBookBean abb) {
		String sql = "INSERT INTO addressbook (name,contactnum, company, position, category)" +
					 "VALUES (?,?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, abb.getName());
			st.setString(2, abb.getContactnum());
			st.setString(3, abb.getCompany());
			st.setString(4, abb.getPosition());
			st.setString(5, "employee");
			st.executeUpdate();
			con.close();
			
		}catch (ClassNotFoundException | SQLException b) {
			// TODO Auto-generated catch block
			b.printStackTrace();
		}
	}
	
	public ArrayList getContact(int id) {
		String sql = "Select * from addressbook WHERE = " + id;
		ArrayList<AddressBookBean> getContact = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				AddressBookBean abb = new AddressBookBean();
				
				abb.setAddressbookid(rs.getInt("addressbookid"));
				abb.setName(rs.getString("name"));
				abb.setDegree(rs.getString("degree"));
				abb.setCompany(rs.getString("company"));
				abb.setDepartment(rs.getString("department"));
				abb.setContactnum(rs.getString("contactnum"));
				abb.setCategory(rs.getString("category"));
				abb.setPosition(rs.getString("position"));
				abb.setYear(rs.getString("year"));
				abb.setSchool(rs.getString("school"));
				
				getContact.add(abb);
			}
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return getContact;
	}
	public void addFaculty(AddressBookBean abb) {
		String sql = "INSERT INTO addressbook (name,contactnum, school, department, category)" +
					 "VALUES (?,?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, abb.getName());
			st.setString(2, abb.getContactnum());
			st.setString(3, abb.getSchool());
			st.setString(4, abb.getDepartment());
			st.setString(5, "faculty");
			st.executeUpdate();
			con.close();
			
		}catch (ClassNotFoundException | SQLException b) {
			// TODO Auto-generated catch block
			b.printStackTrace();
		}
	}
	
	public void addStudent(AddressBookBean abb) {
		String sql = "INSERT INTO addressbook (name,contactnum, school, degree, year, category)" +
					 "VALUES (?,?,?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, abb.getName());
			st.setString(2, abb.getContactnum());
			st.setString(3, abb.getSchool());
			st.setString(4, abb.getDegree());
			st.setString(5, abb.getYear());
			st.setString(6, "student");
			st.executeUpdate();
			con.close();
			
		}catch (ClassNotFoundException | SQLException b) {
			// TODO Auto-generated catch block
			b.printStackTrace();
		}
	}
	
	public void updateEmployee(int id, AddressBookBean abb) {
		String sql = "UPDATE addressbook SET name = ?, contactnum = ?, company = ?, degree = null, year = null, school = null, department = null" + 
				"position = ?, category = ? WHERE addressbookid = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, abb.getName());
			st.setString(2, abb.getContactnum());
			st.setString(3, abb.getCompany());
			st.setString(4, abb.getPosition());
			st.setString(5, "employee");
			st.setInt(6, id);
			st.executeUpdate();
			con.close();
			
		}catch (ClassNotFoundException | SQLException b) {
			// TODO Auto-generated catch block
			b.printStackTrace();
		}
		
	}
	
	public void updateFaculty(int id, AddressBookBean abb) {
		String sql = "UPDATE mp.addressbook SET name = ?, contactnum = ?, school = ?, department = ?"
				+ "company = null, degree = null, year = null,  category = ? WHERE addressbookid = ?";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, abb.getName());
			st.setString(2, abb.getContactnum());
			st.setString(3, abb.getSchool());
			st.setString(4, abb.getDepartment());
			st.setString(5, "faculty");
			st.setInt(6, id);
			st.executeUpdate();
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateStudent(int id, AddressBookBean abb) {
		String sql = "UPDATE mp.addressbook SET name = ?, contactnum = ?, school = ?, degree = ?. year = ?"
				+ "   WHERE addressbookid = ?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, abb.getName());
			st.setString(2, abb.getContactnum());
			st.setString(3, abb.getSchool());
			st.setString(4, abb.getDegree());
			st.setString(5, abb.getYear());
			st.setString(6, "student");
			st.setInt(7, abb.getAddressbookid());
			st.executeUpdate();
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList getSearchedAddressBookService(String type, String search) {
		ArrayList<AddressBookBean> abLists = new ArrayList<>();
		
		String sql = "select * from addressbook WHERE " + type + " LIKE ? ";
		String Like;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			Like = "%" + search + "%";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, Like);
			System.out.print("Eto na po!!  " + st);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				AddressBookBean a = new AddressBookBean();
				
				a.setName(rs.getString("name"));
				a.setContactnum(rs.getString("contactnum"));
				a.setCategory(rs.getString("category"));
				a.setAddressbookid(rs.getInt("addressbookid"));
				
				abLists.add(a);
				}
			}catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		return abLists;
	}
	
	public ArrayList getAllAddressBookService() {
		ArrayList<AddressBookBean> abLists = new ArrayList<>();
		
		String sql = "select * from addressbook";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				AddressBookBean a = new AddressBookBean();
				
				a.setName(rs.getString("name"));
				a.setContactnum(rs.getString("contactnum"));
				a.setCategory(rs.getString("category"));
				a.setAddressbookid(rs.getInt("addressbookid"));
				
				abLists.add(a);
				}
			}catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		return abLists;
	}
	
	public void deleteContact(int id) {
		
		String sql = "DELETE FROM addressbook where addressbookid = " + id;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.executeUpdate();	
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
