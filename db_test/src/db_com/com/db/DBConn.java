package db_com.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConn{
		  
		private final static String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
		private final static String BASE_URL = "jdbc:oracle:thin:@";
		
		
		private String url_address;
		private Connection conn;
		private Statement stat;
		
		
		public DBConn(String address, String port, String serviceName, String username, String password) throws Exception {
			url_address = String.format("%s:%s/s", address,port, serviceName);
			this.createConnection(username, password);
		}
		private void createConnection( String username, String password) throws Exception {
	   public void localConnect() throws Exception {
		
		// 1.Driver 등록
		Class.forName(DRIVER_NAME);
		
		// 2.DBMS 연결
		conn = DriverManager.getConnection( BASE_URL + url_address,username ,password);	
		
		// 3.Statement 생성
	    stat = conn.createStatement();
	 
	 
	 
	 
	 public ResultSet sendSelectQuery(String query) throws Exception{ //send는 ResultSet으로 반환한다.
			return this.stat.executeQuery(query);
		}
		public int sendInsertQuery(String query)  throws Exception{ // INSERT,UPDATE,DELETE는 INT형으로 반환한다.
			return this.stat.executeUpdate(query);
		}
		public int sendUpdateQuery(String query)  throws Exception{
			return this.stat.executeUpdate(query);
		}
		public int sendDeleteQuery(String query)  throws Exception{
			return this.stat.executeUpdate(query);
		}
		
		 public void close()  throws Exception{
		    	this.stat.close();
		    	this.conn.close();
		}
	
}

