package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			String sql ="INSERT INTO product_info(name,category,stock,price,img) VALUES(?,?,?,?,?)";
			
			pstmt = DatabaseManager.getPstmt(conn, sql);
			
			pstmt.setString(1, productInfo.getName());
			pstmt.setString(2, productInfo.getCategory());
			pstmt.setInt(3, productInfo.getStock());
			pstmt.setInt(4, productInfo.getPrice());
			pstmt.setString(5, productInfo.getImg());
			
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

	public boolean update(ProductInfo productInfo){
		Connection conn =null;
		PreparedStatement pstmt= null;
		
		try {
			conn = DatabaseManager.getConnection();
					
			String sql = "UPDATE product_info SET name = ?, category = ?, stock = ?, price = ?, img = ? WHERE productIdx = ?";
			
			pstmt = DatabaseManager.getPstmt(conn, sql);
			pstmt.setString(1, productInfo.getName());
			pstmt.setString(2, productInfo.getCategory());
			pstmt.setInt(3, productInfo.getStock());
			pstmt.setInt(4, productInfo.getPrice());
			pstmt.setString(5, productInfo.getImg());
			pstmt.setInt(6, productInfo.getProductIdx());
			
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

	public ProductInfo selectByProductIdx(int productIdx) {
		Connection conn =null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		ProductInfo productInfo = null;
		
		try {
			conn = DatabaseManager.getConnection();
					
			String sql = "SELECT * FROM product_info WHERE productIdx =?";
			
			pstmt = DatabaseManager.getPstmt(conn, sql);
			pstmt.setInt(1,productIdx);
			
			rs=pstmt.executeQuery();
			
			rs.next();
			productInfo = new ProductInfo();
			productInfo.setProductIdx(productIdx);
			productInfo.setName(rs.getString("name"));
			productInfo.setCategory(rs.getString("category"));
			productInfo.setStock(rs.getInt("stock"));
			productInfo.setPrice(rs.getInt("price"));
			productInfo.setImg(rs.getString("img"));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseManager.closeResultSet(rs);
			DatabaseManager.closePstmt(pstmt);
			DatabaseManager.closeConn(conn);
		}
	
		return productInfo;
	}

	public boolean setImgNull(int productIdx) {
		Connection conn =null;
		PreparedStatement pstmt= null;
		
		try {
			conn = DatabaseManager.getConnection();
					
			String sql = "UPDATE product_info SET img = NULL WHERE productIdx = ?";
			
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
	
	public boolean updateImg(int productIdx, String img) {
		Connection conn =null;
		PreparedStatement pstmt= null;
		
		try {
			conn = DatabaseManager.getConnection();
					
			String sql = "UPDATE product_info SET img = ? WHERE productIdx = ?";
			
			pstmt = DatabaseManager.getPstmt(conn, sql);
			pstmt.setString(1, img);
			pstmt.setInt(2, productIdx);
			
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

	public boolean delete(int productIdx) {
		Connection conn =null;
		PreparedStatement pstmt= null;
		
		try {
			conn = DatabaseManager.getConnection();
					
			String sql = "DELETE FROM product_info WHERE productIdx = ?";
			
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



