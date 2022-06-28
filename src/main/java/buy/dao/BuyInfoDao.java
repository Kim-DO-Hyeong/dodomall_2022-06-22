package buy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import buy.dto.BuyInfo;
import util.DatabaseManager;

public class BuyInfoDao {
	public boolean addBuyInfo (BuyInfo buyInfo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DatabaseManager.getConnection();
			String sql = "INSERT INTO buy_info(memberIdx,productIdx,paymentMethod) VALUES(?,?,?)"; 
			
			pstmt = DatabaseManager.getPstmt(conn, sql);
			pstmt.setInt(1, buyInfo.getMemberIdx());
			pstmt.setInt(2, buyInfo.getProductIdx());
			pstmt.setString(3, buyInfo.getPaymentMethod());
			
			pstmt.executeUpdate();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseManager.closePstmt(pstmt);
			DatabaseManager.closeConn(conn);
		}
		
		return false;
		
	}
	

}
