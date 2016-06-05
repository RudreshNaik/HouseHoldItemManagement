package savePackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Inventory{
	
	static Connection conn = null;
	public Inventory(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(configuration.DB_URL,configuration.USER,configuration.PASS);
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
	protected static List<Item> getAllItems(){
		List<Item> list = new ArrayList<Item>() ;
		Item temp = null;
		try{
			if(conn.isClosed())
				conn = DriverManager.getConnection(configuration.DB_URL,configuration.USER,configuration.PASS);
			
			String query = "SELECT * FROM items";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				temp = new Item();
				temp.setName(rs.getString("name"));
				temp.setPurchaseDate(rs.getDate("dateOfPurchase").toString());
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
	
	protected static void addItem(Item i){
		
		try{
			if(conn.isClosed())
				conn = DriverManager.getConnection(configuration.DB_URL,configuration.USER,configuration.PASS);
			String query = "INSERT INTO items(name,dateOfPurchase,expectedFinishDate,originalQty, remainingQty,units,status) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, i.getName());
			stmt.setDate(2, Utility.stringToSqlDate(i.getPurchaseDate(),"yyyy-dd-MM"));
			stmt.setDate(3, Utility.stringToSqlDate(i.getExpectedFinishDate(),"yyyy-dd-MM"));
			stmt.setInt(4, i.getOriginalQty());stmt.setInt(5, i.getRemainingQty());
			stmt.setString(6, i.getUnitOfItem());
			stmt.setString(7, i.getStatusOfItem());
			stmt.executeUpdate();
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			try {
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
