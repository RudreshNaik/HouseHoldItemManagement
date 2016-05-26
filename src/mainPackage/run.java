package mainPackage;



import java.sql.*;
import java.util.List;
import java.util.ListIterator;

import savePackage.InventorryAccess;
import savePackage.Item;


public class run {
	public static void main(String args[]){
		InventorryAccess ia = new InventorryAccess();
		List<Item> answer = null;
		answer = ia.call_getAllItems();
		ListIterator <Item>iter = answer.listIterator();
		while(iter.hasNext()){
			Item test = iter.next();
			System.out.println(test.name + " purchased  on "+test.purchaseDate);
		}
		Date d1 = new Date(2016-05-24);
		Date d2 = new Date(2016-06-02);
		Item add = new Item();
		add.name = "tomato";
		add.purchaseDate = d1;
		add.expectedFinishDate = d2;
		add.originalQty = "1 Kg";add.remainingQty = "0.5 kg";
		add.status="Y";
		ia.call_addItem(add);
	}
}
