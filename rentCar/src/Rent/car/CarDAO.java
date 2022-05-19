package Rent.car;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import Rent.conn.db.DBConn;
import member.MVO;

public class CarDAO{
 
	private DBConn db;
	
	public CarDAO() {
	try{
		db = new DBConn(new File(System.getProperty("user.home") + "/oracle_db.conf"));
	}catch(Exception e) {
		e.printStackTrace();
      }
	}
	
	
	
	
	
	 //데이터 추가,주문
	public boolean add(CarOrderVO data) {
		String query = " Insert INTO ORDERS VALUES(?,?,?,?,?)";
	    
	
		
		try {
		    PreparedStatement pstat =db.getPstat(query);
		    pstat.setInt(1,data.getNum());
		    pstat.setString(2,data.getId());
		    pstat.setString(3,data.getCarName());
		    pstat.setString(4,data.getDates());
		    pstat.setString(5,data.getOTime());
		    
		    
           int result = db.sendInsertQuery();
		
       	
   		   if(result ==1) {
   			return true;
   	   }
   		
   	}catch (Exception e) {
   		e.printStackTrace();
   	}
   	return false;
}
     
	//수정
	public boolean modify(CarOrderVO data) {
		String query = ""
    	        + "UPDATE  ORDERS"
    	        + "   SET  ID = ?"
    	        + "        CARNAME = ?"
    	        + "      , DATES = ?"
    	        + "      , TIME = ?"
    	        + " WHERE NUM =?";
    	try {
    		PreparedStatement pstat = db.getPstat(query);
    		pstat.setString(1, data.getId());
    		pstat.setString(2, data.getCarName());
    		pstat.setString(3, data.getDates());
    		pstat.setString(4, data.getOTime());
    		pstat.setInt(5, data.getNum());
    		
    		int rs = db.sendUpdateQuery();
    		
    		if(rs ==1) {
    			return true;
    	   }
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    	return false;
    }
		
	//데이터 삭제
	public boolean remove(CarOrderVO data) {
		
	
		
		 String query = "DELETE FROM ORDERS  WHERE NUM =?";
	       
	    	try {
	    		PreparedStatement pstat = db.getPstat(query);
	    		pstat.setInt(1,data.getNum());
	    		
	    		int rs = db.sendDeleteQuery();
	    		
	    		if(rs ==1) {
	    			return true;
	    	   }
	    	}catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	return false;
	    
	    }
	 

	public CarOrderVO get(String id) {
	//데이터 조회	
	  	
    	String query ="SELECT * FROM ORDERS WHERE ID= ?";
  	
  	try {
  		PreparedStatement pstat =db.getPstat(query);
  		pstat.setString(2,id);
  		
  		ResultSet rs = db.sendSelectQuery();
  		
  		if(rs.next()) {
  			CarOrderVO data = new CarOrderVO();
  			data.setId(rs.getString("ID"));
  		    data.setCarName(rs.getString("CARNAME"));
  			data.setDates(rs.getString("DATES"));
  			data.setOTime(rs.getString("OTIME"));
  			return data;
  		}
  			
  	  
  	}catch (Exception e) {
  		e.printStackTrace();
  	}
  	return null;
    	
    	
    	
    }
    
	}
