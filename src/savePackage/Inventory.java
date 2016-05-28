package savePackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Inventory implements configuration{
	
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
	protected static List<Item> getAllItems(){
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
				temp.setName(rs.getString("name"));
				temp.setPurchaseDate(rs.getDate("dateOfPurchase"));
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
				conn = DriverManager.getConnection(DB_URL,user,pass);
			Date d1,d2;
			d1 = i.getPurchaseDate();d2 = i.getExpectedFinishDate();
			String query = "INSERT INTO items(name,dateOfPurchase,expectedFinishDate,originalQty, remainingQty,units,status) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, i.getName());
			stmt.setDate(2, i.getPurchaseDate());stmt.setDate(3, i.getExpectedFinishDate());
			stmt.setInt(4, i.getOriginalQty());stmt.setInt(5, i.getRemainingQty());
			stmt.setObject(6, i.unitOfItem);stmt.setObject(7, i.statusOfItem);
			stmt.executeUpdate();
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
