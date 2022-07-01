package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import buy.dto.BuyInfo;
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
			String sql = "SELECT * FROM product_info ORDER BY insertDate DESC LIMIT ?, 8"; 
			
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
				nth.setImg(rs.getString("img"));
				nth.setInsertDate(rs.getTimestamp("insertDate").toLocalDateTime());
				
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
	
	public int getAmount() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		int amount = 0;
		try {
			conn = DatabaseManager.getConnection();
			String sql = "SELECT COUNT(*) AS amount FROM product_info"; 
			
			pstmt = DatabaseManager.getPstmt(conn, sql);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			amount= rs.getInt("amount");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseManager.closeResultSet(rs);
			DatabaseManager.closePstmt(pstmt);
			DatabaseManager.closeConn(conn);
		}
		
		return amount;
	}
	
	public ProductInfo selectByProductIdx(int productIdx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		ProductInfo productInfo = null;
		
		try {
			conn = DatabaseManager.getConnection();
			String sql = "SELECT *FROM product_info WHERE productIdx = ?"; 
			
			pstmt = DatabaseManager.getPstmt(conn, sql);
			pstmt.setInt(1, productIdx);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			productInfo = new ProductInfo();
			productInfo.setProductIdx(productIdx);
			productInfo.setName(rs.getString("name"));
			productInfo.setCategory(rs.getString("category"));
			productInfo.setStock(rs.getInt("stock"));
			productInfo.setPrice(rs.getInt("price"));
			productInfo.setImg(rs.getString("img"));
			productInfo.setInsertDate(rs.getTimestamp("insertDate").toLocalDateTime());
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseManager.closeResultSet(rs);
			DatabaseManager.closePstmt(pstmt);
			DatabaseManager.closeConn(conn);
		}
		
		return productInfo;
		
	}
	
	public boolean decreaseStock(int productIdx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DatabaseManager.getConnection();
			String sql = "UPDATE product_info SET stock = stock -1 WHERE productIdx =?"; 
			
			pstmt = DatabaseManager.getPstmt(conn, sql);
			pstmt.setInt(1, productIdx);
			
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
