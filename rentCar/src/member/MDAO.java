package member;



import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import Rent.conn.db.DBConn;

public class MDAO {
   private DBConn db;
	
	public MDAO() {
	try{
		db = new DBConn(new File(System.getProperty("user.home") + "/oracle_db.conf"));
	}catch(Exception e) {
		e.printStackTrace();
	}
}	
	
	public boolean add(MVO data) {
		// 등록하기
		String query ="Insert INTO information VALUES(?,?,?,?,?)";
		
		try {
	         PreparedStatement pstat = db.getPstat(query);
	         pstat.setString(1, data.getId());
	         pstat.setString(2, data.getPwd());
	         pstat.setString(3, data.getName());
	         pstat.setInt(4, data.getLnumber());
	         pstat.setInt(5, data.getPhonenumber());
	    	         
	    	int result = db.sendInsertQuery();
	    		
	    		if(result ==1) {
	    			return true;
	    	   }
	    		
	    	}catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	return false;
	}

	public MVO get(String id) {
		// 단일 데이터 조회
		String query ="SELECT * FROM information  WHERE ID = ?";
		
		try {
		PreparedStatement pstat =db.getPstat(query);
  		pstat.setString(1,id);
  		
  		ResultSet rs = db.sendSelectQuery();
  		
  		if(rs.next()) {
  			MVO data = new MVO();
  			data.setId(rs.getString("ID"));
  			data.setPwd(rs.getString("PWD"));
  			data.setName(rs.getString("NAME"));
  			data.setLnumber(rs.getInt("LNUMBER"));
  			data.setPhonenumber(rs.getInt("PHONENUMBER"));
  		    return data;
  		}
  			
  	  
  	}catch (Exception e) {
  		e.printStackTrace();
  	}
  	return null;
    	
	}

	public boolean modify(MVO data) {
		String query = ""
    	        + "UPDATE  information"
    	        + "   SET  PWD = ?"
    	        + "      , NAME = ?"
    	        + "      , LNUMBER = ?"
    	        + "      , PHONENUMBER = ?"
    	        + " WHERE ID =?";
    	try {
    		PreparedStatement pstat = db.getPstat(query);
    		 pstat.setString(1, data.getPwd());
	         pstat.setString(2, data.getName());
	         pstat.setInt(3, data.getLnumber());
	         pstat.setInt(4, data.getPhonenumber());
	         pstat.setString(5, data.getId());
    		
    		int rs = db.sendUpdateQuery();
    		
    		if(rs ==1) {
    			return true;
    	   }
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    	return false;
	}

	 public boolean remove(MVO data) {
		 //삭제하기
		 
		 String query = "DELETE FROM information  WHERE ID =?";
	       
	    	try {
	    		PreparedStatement pstat = db.getPstat(query);
	    		pstat.setString(1,data.getId());
	    		
	    		int rs = db.sendDeleteQuery();
	    		
	    		if(rs ==1) {
	    			return true;
	    	   }
	    	}catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	return false;
	    
	    }
	} 



	





	
