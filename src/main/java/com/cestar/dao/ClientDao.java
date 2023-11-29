package com.cestar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cestar.model.Client;

public class ClientDao {

	public Connection setupConnection() {

		Connection con = null;

		String url = "jdbc:mysql://localhost:3306/shipping_records";

		String user = "root";

		String pwd = "";

		// Load the Driver

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pwd);

			System.out.println("Connection Successfull !!!");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

	public List<Client> displayRecs() {

		List<Client> emps = new ArrayList<>();

		Connection con = setupConnection();

		String sql = "select * from clients";

		try {

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Client emp_from_resultset_top_row = new Client(rs.getInt("id"), rs.getString("name"),
						rs.getString("contact"), rs.getString("itemshipped"), rs.getString("datereceived"), rs.getString("dateshipped"));

				emps.add(emp_from_resultset_top_row);
			}

			System.out.println(emps);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emps;

	}
	
	
	public int insertRec(Client emp_from_insert_dot_jsp) {
		
		int status = 0 ;
		
		Connection con = setupConnection();
		
		String sql = "insert into clients (id,name,contact,itemshipped,datereceived,dateshipped) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,emp_from_insert_dot_jsp.getId() );
			
			pstmt.setString(2, emp_from_insert_dot_jsp.getName());
			
			pstmt.setString(3, emp_from_insert_dot_jsp.getContact());
			
			pstmt.setString(4, emp_from_insert_dot_jsp.getItemshipped());
			
			pstmt.setString(5, emp_from_insert_dot_jsp.getDatereceived());
			
			pstmt.setString(6, emp_from_insert_dot_jsp.getDateshipped());
			
			status = pstmt.executeUpdate();
			
			if(status>0) {
				
				System.out.println("Record Inserted !!!");
			}
			else {
				
				System.out.println("Try Again Please !!!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public int deleteRec(int id_from_delete_btn) {
		
		int status = 0 ;
		
		Connection con = setupConnection();
		
		String sql = "delete from clients where id=?";
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id_from_delete_btn);
			
			status = pstmt.executeUpdate();
			
			if(status>0) {
				
				System.out.println("Record Deletd Successfully !!!");
			}
			else {
				
				System.out.println("Please Try Agaian there is an error !!!");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
	
	public Client getRecById(int id_from_edit_btn) {
		
		Client emp = null ;
		
		Connection con = setupConnection();
		
		String sql = "select * from clients where id = ?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id_from_edit_btn);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				 emp = new Client(rs.getInt("id"),rs.getString("name"),rs.getString("contact"),rs.getString("itemshipped"),rs.getString("datereceived"),rs.getString("dateshipped"));
				
				
			}
			System.out.println(emp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;		
		
	}
	
	public int updateById(Client updated_emp_from_edit_jsp,int old_id_from_session) {
		
		int status = 0 ;
		
		String sql = "update clients set id=? ,name=? ,contact=?,itemshipped=?,datereceived=?,dateshipped=? where id=?";
		
		Connection con = setupConnection();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
		
		    pstmt.setInt(1, updated_emp_from_edit_jsp.getId());
		    
		    pstmt.setString(2, updated_emp_from_edit_jsp.getName());
		    
		    pstmt.setString(3, updated_emp_from_edit_jsp.getContact());
		    
		    pstmt.setString(4, updated_emp_from_edit_jsp.getItemshipped());
		    
		    pstmt.setString(5, updated_emp_from_edit_jsp.getDatereceived());
		    
		    pstmt.setString(6, updated_emp_from_edit_jsp.getDateshipped());
		    
		    pstmt.setInt(7,old_id_from_session );
		
		    status = pstmt.executeUpdate();
		    
		    
		    if(status>0) {
		    	
		    	System.out.println("Record Updated Successfully!!!");
		    }else {
		    	
		    	System.out.println("Please Try Again !!!error!!!");
		    }
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	
	}
	
	

}
