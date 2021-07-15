package kr.bit.model;

// JDBC ->myBatis, JPA
import java.sql.*;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	// 데이터베이스 연결객체 생성
	public void getConnect() {
		String url = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimeZone=UTC";
		String user = "root";
		String password = "admin12345";
		// MySQL 드라이버 로딩
		try {
			// 동적로딩(실행시점에서 객체를 생성하는 방법)
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			ps = conn.prepareStatement("select * from member");
			rs = ps.executeQuery();
			if (rs.next()) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
