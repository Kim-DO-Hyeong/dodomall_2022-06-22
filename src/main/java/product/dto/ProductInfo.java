package product.dto;

import java.time.LocalDateTime;

public class ProductInfo {
	private int productIdx;
	private String name;
	private String category;
	private int stock;
	private int price;
	private String img;
	private LocalDateTime insertDate;
	
	public ProductInfo() {
		
	}
	
	public ProductInfo(int productIdx, String name, String category, int stock, int price, String img, LocalDateTime insertDate) {
		this.productIdx = productIdx;
		this.name = name;
		this.category = category;
		this.stock = stock;
		this.price = price;
		this.img = img;
		this.insertDate = insertDate;
	}

	public int getProductIdx() {
		return productIdx;
	}

	public void setProductIdx(int productIdx) {
		this.productIdx = productIdx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public LocalDateTime getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(LocalDateTime insertDate) {
		this.insertDate = insertDate;
	}
	
	
	
		
	
}
