package net.code;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品テーブルのフィールドの宣言及びカプセル化
 * @author SatoYusuke0228
 */
@Entity
@Table(name="TR_PRODUCT")
public class TrProductEntity {

	@Id
	@Column(name="PRODUCT_ID", nullable=false, length=512)
	private String productId;

	@Column(name="PRODUCT_NAME", nullable=false, length=512)
	private String productName;

	@Column(name="PRODUCT_SELLING_PRICE", nullable=false, length=512)
	private int  productPrice;

	@Column(name="PRODUCT_CATEGORY_ID", nullable=false, length=512)
	private String productCategoryId;

	@Column(name="PRODUCT_STOCK", nullable=false, length=512)
	private int productStock;

	@Column(name="PRODUCT_COMMENT", nullable=false, length=512)
	private String productComment;

	@Column(name="PRODUCT_PHOTO_FILE_NAME1", nullable=false, length=512)
	private String productPhotoFileName1;

	@Column(name="PRODUCT_PHOTO_FILE_NAME2", nullable=false, length=512)
	private String productPhotoFileName2;

	@Column(name="PRODUCT_PHOTO_FILE_NAME3", nullable=false, length=512)
	private String productPhotoFileName3;

	@Column(name="PRODUCT_SHOW_FLAG", nullable=false, length=512)
	private String productShowFlag;

	@Column(name="INSERT_DATE", nullable=false, length=512)
	private Timestamp insertDate;

	@Column(name="INSERT_USER", nullable=false, length=512)
	private String insertUser;

	@Column(name="UPDATE_DATE", nullable=false, length=512)
	private Timestamp updateDate;

	@Column(name="UPDATE_USER", nullable=false, length=512)
	private String updateUser;

	@Column(name="DELETE_DATE", nullable=false, length=512)
	private Timestamp deleteDate;

	@Column(name="DELETE_USER", nullable=false, length=512)
	private String deleteUser;

	/**
	 * setter and getter
	 * @parm setter
	 * @return getter
	 */

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public String getProductComment() {
		return productComment;
	}

	public void setProductComment(String productComment) {
		this.productComment = productComment;
	}

	public String getProductPhotoFileName1() {
		return productPhotoFileName1;
	}

	public void setProductPhotoFileName1(String productPhotoFileName1) {
		this.productPhotoFileName1 = productPhotoFileName1;
	}

	public String getProductPhotoFileName2() {
		return productPhotoFileName2;
	}

	public void setProductPhotoFileName2(String productPhotoFileName2) {
		this.productPhotoFileName2 = productPhotoFileName2;
	}

	public String getProductPhotoFileName3() {
		return productPhotoFileName3;
	}

	public void setProductPhotoFileName3(String productPhotoFileName3) {
		this.productPhotoFileName3 = productPhotoFileName3;
	}

	public String getProductShowFlag() {
		return productShowFlag;
	}

	public void setProductShowFlag(String productShowFlag) {
		this.productShowFlag = productShowFlag;
	}

	public Timestamp getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}

	public String getInsertUser() {
		return insertUser;
	}

	public void setInsertUser(String insertUser) {
		this.insertUser = insertUser;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Timestamp getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Timestamp deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getDeleteUser() {
		return deleteUser;
	}

	public void setDeleteUser(String deleteUser) {
		this.deleteUser = deleteUser;
	}
}
