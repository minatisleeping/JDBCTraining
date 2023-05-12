package training;



import java.sql.Connection;
import java.sql.PreparedStatement;
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
			// Test using prepareStatement	
			
			PreparedStatement statement = conn.prepareStatement("insert into"
					+ " course(course_id, subject_id, course_code, title, number_of_credits) "
					+ "VALUES (?, ?, ?, ?, ?)");
			statement.setInt(1, 11120);
			statement.setString(2, "PRFF");
			statement.setInt(3, 192);
			statement.setString(4, "Programming Fundamentals");
			statement.setInt(5, 3);
			
			int flagCount = statement.executeUpdate();
			
			if(flagCount > 0)
				System.out.println("Inserted!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
