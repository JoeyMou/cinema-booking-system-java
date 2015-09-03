package valuebean;

public class OrderBean {
	String orderId ="";
	String customerId = "";
	String seatId = "";
	String date = "";
	String price ="";
	String isCommented = "";
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getIsCommented() {
		return isCommented;
	}
	public void setIsCommented(String isCommented) {
		this.isCommented = isCommented;
	}
	
}
