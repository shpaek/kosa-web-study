import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class JDBCTest {
	public static void selectTest() {
		//1. JDBC드라이버 설치
		//2. 드라이버클래스들 JVM에 로드
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("JDBC드라이버 로드성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		//3. DB와 연결
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB와 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		/*
		//4. SQL문 DB에 송신하기
		Statement stmt = null;
		//5. SQL문 결과 수신하기
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			int dId = 60; //부서번호
			String fn = "D";
			String selectSQL = "SELECT employee_id, first_name, hire_date, salary\r\n"
					+ "FROM employees\r\n"
					+ "WHERE department_id=" + dId
					+ "AND SUBSTR(first_name, 1, 1) = '"+ fn + "'" ;
			rs = stmt.executeQuery(selectSQL); //송신, rs: 결과집합수신
			while(rs.next()) { //while(rs.next()==true){
				int eId = rs.getInt("employee_id");
				String eName = rs.getString(2); //rs.getString("first_name");
				Date eHdt = rs.getDate("hire_date");
				int eSal = rs.getInt("salary");
				System.out.println(eId + ":" + eName + ":" + eHdt + ":" + eSal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		*/
		
		
		//4. SQL문 DB에 송신하기
		PreparedStatement pstmt = null;
		//5. SQL문 결과 수신하기
		ResultSet rs = null;
		
		String selectSQL = "SELECT employee_id, first_name, hire_date, salary\r\n"
				+ "FROM employees\r\n"
				+ "WHERE department_id=?\r\n"
				+ "AND SUBSTR(first_name, 1, 1) = ?";
		try {
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setInt(1, 60);
			pstmt.setString(2, "D");
			rs = pstmt.executeQuery();
			while(rs.next()) { //while(rs.next()==true){
				int eId = rs.getInt("employee_id");
				String eName = rs.getString(2); //rs.getString("first_name");
				Date eHdt = rs.getDate("hire_date");
				int eSal = rs.getInt("salary");
				System.out.println(eId + ":" + eName + ":" + eHdt + ":" + eSal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void insertTest() {
		//2. JDBC드라이버 로드
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		//3. DB와 연결
		Connection conn = null;
		String url = "jdbc:oracle:thin:@192.168.1.84:1521:xe";
		String user = "hr";
		String password = "hr";
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB접속 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//4. SQL구문 송신
		PreparedStatement pstmt = null;
		String insertSQL = "INSERT INTO customer(id, pwd, name) VALUES (?,?,?)";
		try {
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, "id20");
			pstmt.setString(2, "p20");
			pstmt.setString(3, "백SH");
			int rowcnt = pstmt.executeUpdate();
			System.out.println(rowcnt + "건 추가성공");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public static void main(String[] args) {
		//selectTest();
		insertTest();

	}
	

}
