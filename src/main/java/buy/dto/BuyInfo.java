package buy.dto;

import java.time.LocalDateTime;

public class BuyInfo {
	private int buyIdx;
	private int memberIdx;
	private int productIdx;
	private String paymentMethod;
	private LocalDateTime buyDate;
	
	public BuyInfo() {

	}
	public BuyInfo(int buyIdx, int memberIdx, int productIdx, String paymentMethod, LocalDateTime buyDate) {
		this.buyIdx = buyIdx;
		this.memberIdx = memberIdx;
		this.productIdx = productIdx;
		this.paymentMethod = paymentMethod;
		this.buyDate = buyDate;
	}

	public int getBuyIdx() {
		return buyIdx;
	}

	public void setBuyIdx(int buyIdx) {
		this.buyIdx = buyIdx;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public int getProductIdx() {
		return productIdx;
	}

	public void setProductIdx(int productIdx) {
		this.productIdx = productIdx;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public LocalDateTime getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(LocalDateTime buyDate) {
		this.buyDate = buyDate;
	}
	
	
	
}
