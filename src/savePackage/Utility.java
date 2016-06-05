package savePackage;

import java.text.SimpleDateFormat;

import javax.ws.rs.core.Response;

public class Utility {

	public static final java.sql.Date stringToSqlDate(String str,String dateFormat){
		SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
		java.sql.Date sqlDate=null;
		try{
			sqlDate = new java.sql.Date(sf.parse(str).getTime());
		}catch(Exception e){
			e.printStackTrace();
		}
		return sqlDate;
	}
	public static final Response addCrossOriginHeader(Object response){
		 	return Response.ok() //200
				.entity(response)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
}
