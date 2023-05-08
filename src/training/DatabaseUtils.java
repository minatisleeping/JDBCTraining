package training;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class DatabaseUtils {
	public static Connection getConnection() {
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver"); 
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:1433/TrainingDB",
//		        	"sa", "Minat-123"); 
			
			
			// MS SQL Server
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://localhost"
					+ ":1433;databaseName=TrainingDB;encrypt=false";
			
			Connection conn = DriverManager.getConnection(connectionUrl,
					"sa","Minat-123");
			return conn;
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
