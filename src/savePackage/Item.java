package savePackage;
import java.sql.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {
	
	private String name;
	private String purchaseDate,expectedFinishDate;
	private int originalQty,remainingQty;
	private String statusOfItem;
	private String unitOfItem;
	
	public Item(){
		
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String given){
		this.name = given;
	}
	public String getPurchaseDate(){
		return this.purchaseDate;
	}
	public void setPurchaseDate(String d){
		this.purchaseDate = d;
	}
	public String getExpectedFinishDate(){
		return this.expectedFinishDate;
	}
	public void setExpectedFinishDate(String d){
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
	public String getStatusOfItem(){
		return this.statusOfItem;
	}
	public void setStatusOfItem(String s){
		this.statusOfItem = s;
	}
	public String getUnitOfItem(){
		return this.unitOfItem;
	}
	public void setUnitOfItem(String s){
		this.unitOfItem = s;
	}
	
}

