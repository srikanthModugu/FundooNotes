package com.bridgeit.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCHelper {

	public void close(ResultSet rs)
		{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
		public void close(PreparedStatement stm)
		{
			if(stm!=null)
				try {
					stm.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
		public void close(Connection con)
		{
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
	 public Connection getConnection()
		{
			Connection con = null;
			try
			{
				Class.forName(DBConstants.DRIVERNAME);
				con = DriverManager.getConnection(DBConstants.URL,DBConstants.UID,DBConstants.PASS);
				System.out.println("established connection...con "+con);
				
				return con;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return null;
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
				return null;
			}
			
		}
}
