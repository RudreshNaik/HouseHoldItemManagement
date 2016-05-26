package savePackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/records";
	static final String user = "root";
	static final String pass = "";
	static Connection conn = null;
	
	public Inventory(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,user,pass);
		}/*
		catch(SQLException se){
			se.printStackTrace();
		}catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}*/catch(Exception e){
			e.printStackTrace();
		}finally{
			/*try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}*/
		}
	}
	public static List<Item> getAllItems(){
		List<Item> list = new ArrayList<Item>() ;
		Item temp = null;
		try{
			if(conn.isClosed())
				conn = DriverManager.getConnection(DB_URL,user,pass);
			
			String query = "SELECT * FROM items";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				temp = new Item();
				temp.name = rs.getString("name");
				temp.purchaseDate = rs.getDate("dateOfPurchase");
				list.add(temp);
			}
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		return list;
	}
	
	public static void addItem(Item i){
		try{
			if(conn.isClosed())
				conn = DriverManager.getConnection(DB_URL,user,pass);
			Date d1,d2;
			d1 = i.purchaseDate;d2 = i.expectedFinishDate;
			String query = "INSERT INTO items(name,dateOfPurchase,expectedFinishDate,originalQty, remainingQty,status) VALUES (?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, i.name);
			stmt.setDate(2, i.purchaseDate);stmt.setDate(3, i.expectedFinishDate);
			stmt.setString(4, i.originalQty);stmt.setString(5, i.remainingQty);
			stmt.setString(6, i.status);
			stmt.executeUpdate();
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			
		}
		
	}
}
