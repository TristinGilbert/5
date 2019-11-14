package entities;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButility {

	
	Connection conn = null;
	Statement stmt = null;
	
	
	
	//JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/CSE_Login";
    
    
    //Database credentials
    static final String USER = "tgilbert";
    static final String PASS = "BWh-74";

	public void connectMeIn() {
		try{
			Class.forName(JDBC_DRIVER);			
		}catch(ClassNotFoundException e){
			System.err.println(e);
			System.exit (-1);
		}
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void removeAllPersons() {
		Connection conn = getConnection();
		
	}
	
private static Connection getConnection() {
	Connection conn = null;
	String url = "jdbc:mysql://cse.unl.edu/tgilbert";
	String user = "tgilbert";
	String password = "BWh-74";
	
	try {
		conn = DriverManager.getConnection(url, user, password);
		DataBaseInfo runner = new DataBaseInfo();
		runner.loadAll(conn);
	} catch (SQLExceptione ) {
		throw new RuntimeException(e);
	}
	return conn;
}

}

