package db_com.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
  
	
	public void localConnect() throws Exception{
	 
		// 1.Driver 등록
	Class.forName("oracle.jdbc.driver.OracleDriver");
	 
	// 2.DBMS 연결
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "puser1","puser1");	
	  
	// 3.Statement 생성
	 Statement stat = conn.createStatement();
	 
    // 4. SQL 질의문 전송 및 반환
	ResultSet rs = stat.executeQuery("SELECT 'Hello' FROM DUAL");
	if(rs.next()) {
		System.out.println(rs.getString(1));
	}
	 // 5. 객체 반환	
    rs.close();
    stat.close();
    conn.close();
    
		
		
	}
		public static void main(String[] args) throws Exception {
			DBConn myDB = new DBConn();
			myDB.localConnect();
		
	}
}

