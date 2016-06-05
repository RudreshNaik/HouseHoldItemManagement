package savePackage;



import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;


public class run {
	public static void main(String args[]){
	JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
	sf.setResourceClasses(InventorryAccess.class);
	sf.setAddress("http://localhost:8090");
	sf.create();
	
	/*
		InventorryAccess ia = new InventorryAccess();
		List<Item> answer = null;
		answer = ia.callGetAllItems();
		ListIterator <Item>iter = answer.listIterator();
		while(iter.hasNext()){
			Item test = iter.next();
			System.out.println(test.getName() + " purchased  on "+test.getPurchaseDate());
		}
		
		String currentDateString1 = "02/27/2012 17:00:00",currentDateString2 = "03/15/2012";
		SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
		//java.sql.date
		Date currentDate1= null,currentDate2 = null;
		   
		try {
			//sd.parse return java.util.date.
			currentDate1 = new Date(sd.parse(currentDateString1).getTime());
			currentDate2 = new Date(sd.parse(currentDateString2).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Adding the attributes of the item to be added.
		Item add = new Item();
		add.setName("tomato");
		add.setPurchaseDate(currentDate1);
		add.setExpectedFinishDate(currentDate2);
		add.setOriginalQty(1000);
		add.setRemainingQty(500);
		add.setUnitOfItem(units.KG);
		add.setStatus(status.IN_STOCK);
		ia.callAddItem(add);	
		answer = ia.callGetAllItems();
		iter = answer.listIterator();
		while(iter.hasNext()){
			Item tempor = iter.next();
			System.out.println(tempor.getName() + " purchased  on "+tempor.getPurchaseDate()+" with a remaining quantity of "+tempor.getRemainingQty()+tempor.getUnitOfItem());
		}
	*/	
	}
}
