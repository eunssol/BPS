package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil {
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection("jdbc:apache:commons:dbcp:webproject");
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {}
	}
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {}
	}
	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (Exception e) {}
	}
}
