package DaoPackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ModelPackage.Student;

public class StudentDao {
	public int registerStudent (Student student) throws ClassNotFoundException {
			String sql = "INSERT INTO student_details" + 

	"(Name, Department, Email, Mobile, Address) VALUES " + 
	"(?, ?, ?, ?, ?);";

	int result = 0;

	Class.forName("com.mysql.jdbc.Driver");

	try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");

			PreparedStatement pstmt = conn.prepareStatement (sql)) 
	{


		pstmt.setString(2, student.getName()); 
		pstmt.setString(3, student.getDepartment());
		pstmt.setString(4, student.getEmail()); 
		pstmt.setString(5, student.getMobile());
		pstmt.setString(6, student.getAddress()); 
		
		System.out.println(pstmt);
		result = pstmt.executeUpdate();
	}

	catch (SQLException e) {
		e.printStackTrace();
	}

		return result;

	}
}
