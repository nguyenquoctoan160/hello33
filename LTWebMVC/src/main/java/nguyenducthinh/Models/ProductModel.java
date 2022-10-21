package nguyenducthinh.Models;

import java.sql.Date;

public class ProductModel {
	@Override
	public String toString() {
		return "ProductModel [productId=" + productId + ", productName=" + productName + ", productCode=" + productCode
				+ ", categoryId=" + categoryId + ", description=" + description + ", price=" + price + ", amount="
				+ amount + ", stock=" + stock + ", images=" + images + ", wishList=" + wishList + ", status=" + status
				+ ", createDate=" + createDate + ", sellerId=" + sellerId + "]";
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getWishList() {
		return wishList;
	}
	public void setWishList(String wishList) {
		this.wishList = wishList;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	
	int productId;
	String productName;
	int productCode;
	int categoryId;
	String description;
	float price;
	int amount;
	int stock;
	String images;
	String wishList;
	int status;
	Date createDate;
	int sellerId;
	
	
	
	
	
	
}
