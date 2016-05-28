package savePackage;



import java.sql.*;
import java.util.List;
import java.util.ListIterator;



public class run {
	public static void main(String args[]){
		InventorryAccess ia = new InventorryAccess();
		List<Item> answer = null;
		answer = ia.callGetAllItems();
		ListIterator <Item>iter = answer.listIterator();
		while(iter.hasNext()){
			Item test = iter.next();
			System.out.println(test.getName() + " purchased  on "+test.getPurchaseDate());
		}
		Date d1 = new Date(2016-05-24);
		Date d2 = new Date(2016-06-02);
		Item add = new Item();
		add.setName("tomato");
		add.setPurchaseDate(d1);
		add.setExpectedFinishDate(d2);
		add.setOriginalQty(1000);
		add.setRemainingQty(500);
		add.unitOfItem = units.Kgs;
		add.statusOfItem = status.inStock;
		ia.callAddItem(add);
		answer = ia.callGetAllItems();
		iter = answer.listIterator();
		while(iter.hasNext()){
			Item tempor = iter.next();
			System.out.println(tempor.getName() + " purchased  on "+tempor.getPurchaseDate()+" with a remaining quantity of "+tempor.getRemainingQty()+tempor.unitOfItem);
					
		}
	}
}
