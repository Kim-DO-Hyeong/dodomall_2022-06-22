package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import product.dto.ProductInfo;
import util.DatabaseManager;

public class ProductInfoDao {
	
	public List<ProductInfo> getProductInfoList(int start) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List<ProductInfo> productInfoList = new ArrayList<>();
		
		try {
			conn = DatabaseManager.getConnection();
			String sql = "SELECT * FROM product_info LIMIT ?, 8"; 
			
			pstmt = DatabaseManager.getPstmt(conn, sql);
			pstmt.setInt(1, start);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductInfo nth = new ProductInfo();
				nth.setProductIdx(rs.getInt("productIdx"));
				nth.setName(rs.getString("name"));
				nth.setCategory(rs.getString("category"));
				nth.setStock(rs.getInt("stock"));
				nth.setPrice(rs.getInt("price"));
				nth.setInsertDate(rs.getTimestamp("insertTime").toLocalDateTime());
				
				productInfoList.add(nth);
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseManager.closeResultSet(rs);
			DatabaseManager.closePstmt(pstmt);
			DatabaseManager.closeConn(conn);
		}
		
		return productInfoList;
	}
}
