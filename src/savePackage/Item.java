package savePackage;
import java.sql.*;


public class Item {
	private String name;
	private Date purchaseDate,expectedFinishDate;
	private int originalQty,remainingQty;
	private status statusOfItem;
	private units unitOfItem;
	public Item(){
		
	}
	public String getName(){
		return this.name;
	}
	public void setName(String given){
		this.name = given;
	}
	public Date getPurchaseDate(){
		return this.purchaseDate;
	}
	public void setPurchaseDate(Date d){
		this.purchaseDate = d;
	}
	public Date getExpectedFinishDate(){
		return this.expectedFinishDate;
	}
	public void setExpectedFinishDate(Date d){
		this.expectedFinishDate = d;
	}
	public int getOriginalQty(){
		return this.originalQty;
	}
	public void setOriginalQty(int Qty){
		this.originalQty = Qty;
	}
	public int getRemainingQty(){
		return this.remainingQty;
	}
	public void setRemainingQty(int Qty){
		this.remainingQty = Qty;
	}
	public status getStatus(){
		return this.statusOfItem;
	}
	public void setStatus(status s){
		this.statusOfItem = s;
	}
	public units getUnitOfItem(){
		return this.unitOfItem;
	}
	public void setUnitOfItem(units s){
		this.unitOfItem = s;
	}
	
}

