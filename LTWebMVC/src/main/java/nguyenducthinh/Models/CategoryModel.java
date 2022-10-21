package nguyenducthinh.Models;
public class CategoryModel {
	
	//bước 1: khai báo biến đại diện đưa vào db
	private int cateId;
	private String cateName;
	private String images;
	private int Status;
	
	//bước 2: tạo các constructor sẽ truy xuất dữ liệu
	public CategoryModel() {
	}
	
	//bước 3: tạo getter và setter để truy xuất các trường cụ thể 
	public int getCateId() {
		return cateId;
	}
	
	public void setCateId(int cateId) {
		this.cateId = cateId;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	
	//bước 4: tạo hàm toString để chuyển đổi dữ liệu object theo String
	@Override
	public String toString() {
		return "CategoryModel [cateId=" + cateId + ", cateName=" + cateName + ", images=" + images + ", Status="
				+ Status + "]";
	}
}