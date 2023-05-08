package training;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnect {
	
	public static void main(String[] args) throws SQLException {
		
		try {
			Connection conn = DatabaseUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select course_id, title from course");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " - " + rs.getString(2));
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
