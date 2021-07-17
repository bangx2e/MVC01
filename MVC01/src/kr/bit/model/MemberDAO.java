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
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//회원 저장 동작
	public int memberInsert(MemberVO vo) {
		String sql="insert into member(id,pass,name,age,email,phone) values(?,?,?,?,?,?)";
		int cnt=-1;
		getConnect();
		// SQL 쿼리문 전송 객체 생성
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,vo.getId());
			ps.setString(2,vo.getPass());
			ps.setString(3,vo.getName());
			ps.setInt(4,vo.getAge());
			ps.setString(5,vo.getEmail());
			ps.setString(6,vo.getPhone());
			//쿼리문 실행
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
}
