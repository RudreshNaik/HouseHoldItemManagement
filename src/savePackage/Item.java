package savePackage;
import java.sql.*;


public class Item {
	private String name;
	private Date purchaseDate,expectedFinishDate;
	private int originalQty,remainingQty;
	public status statusOfItem;
	public units unitOfItem;
	public Item(){
		
	}
	protected String getName(){
		return this.name;
	}
	protected void setName(String given){
		this.name = given;
	}
	protected Date getPurchaseDate(){
		return this.purchaseDate;
	}
	protected void setPurchaseDate(Date d){
		this.purchaseDate = d;
	}
	protected Date getExpectedFinishDate(){
		return this.expectedFinishDate;
	}
	protected void setExpectedFinishDate(Date d){
		this.expectedFinishDate = d;
	}
	protected int getOriginalQty(){
		return this.originalQty;
	}
	protected void setOriginalQty(int Qty){
		this.originalQty = Qty;
	}
	protected int getRemainingQty(){
		return this.remainingQty;
	}
	protected void setRemainingQty(int Qty){
		this.remainingQty = Qty;
	}
	/*
	protected status getStatus(){
		return this.statusOfItem;
	}
	protected void setStatus(status s){
		this.statusOfItem = s;
	}
	protected units getUnitOfItem(){
		return this.unitOfItem;
	}
	protected void setUnitOfItem(units s){
		this.unitOfItem = s;
	}
	*/
}

