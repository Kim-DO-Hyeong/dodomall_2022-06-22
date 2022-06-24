package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import product.dto.ProductInfo;
import util.DatabaseManager;

public class MngProductDao {
	
	public boolean insert(ProductInfo productInfo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// DB 접속
			conn = DatabaseManager.getConnection();
			
			// 쿼리 준비
			String sql ="INSERT INTO product_info(name,category,stock,price,img,insertDate) VALUES(?,?,?,?,?,?)";
			
			pstmt = DatabaseManager.getPstmt(conn, sql);
			
			pstmt.setString(1, productInfo.getName());
			pstmt.setString(2, productInfo.getCategory());
			pstmt.setInt(3, productInfo.getStock());
			pstmt.setInt(4, productInfo.getPrice());
			pstmt.setString(5, productInfo.getImg());
			pstmt.setString(6, productInfo.getInsertDate().toString());
			
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

