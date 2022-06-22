package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import member.dto.MemberInfo;
import util.DatabaseManager;

public class MemberInfoDao {
	
	public boolean insert(MemberInfo memberInfo) {
		// insert 메서드가 전달받은 memberInfo 를 사용해서 
		// 회원 가입이 이뤄 지도록 코드를 완성하세요
		// 리턴 고민 하지 말기 
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// DB 접속
			conn = DatabaseManager.getConnection();
			
			// 쿼리 준비
			String sql ="INSERT INTO member_info(id,pw,name,tel,addr,email,joinDate) VALUES(?,?,?,?,?,?,?)";
			
			pstmt = DatabaseManager.getPstmt(conn, sql);
			pstmt.setString(1, memberInfo.getId());
			pstmt.setString(2, memberInfo.getPw());
			pstmt.setString(3, memberInfo.getName());
			pstmt.setString(4, memberInfo.getTel());
			pstmt.setString(5, memberInfo.getAddr());
			pstmt.setString(6, memberInfo.getEmail());
			pstmt.setString(7, memberInfo.getJoinDate().toString());
			
			// 쿼리 실행 
			pstmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			DatabaseManager.closePstmt(pstmt);
			DatabaseManager.closeConn(conn);
		}
	}
}
