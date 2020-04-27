package net.code;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 商品カテゴリーテーブルのフィールドの宣言及びカプセル化
 *
 *
 * CREATE TABLE MS_PRODUCT_CATEGORY_INVENTORY (
 * PRODUCT_CATEGORY_ID CHAR(1) NOT NULL PRIMARY KEY,
 * PRODUCT_CATEGORY_NAME VARCHAR(64) NOT NULL,
 * INSERT_DATE TIMESTAMP DEFAULT now() NOT NULL,
 * INSERT_USER VARCHAR(64) NOT NULL,
 * UPDATE_DATE TIMESTAMP DEFAULT now() NOT NULL,
 * UPDATE_USER VARCHAR(64) NOT NULL,
 * DELETE_DATE TIMESTAMP,
 * DELETE_USER VARCHAR(64)
 * );
 *
 *
 * PRODUCT_CATEGORY_ID == '0' == 'beans'
 * PRODUCT_CATEGORY_ID == '1' == 'extractor'
 * PRODUCT_CATEGORY_ID == '2' == 'other'
 *
 *
 * @author SatoYusuke0228
 */

@Entity
@Table(name = "MS_PRODUCT_CATEGORY_INVENTORY")
public class MsProductCategoryInventoryEntity {

	@Id
	@Column(name = "PRODUCT_CATEGORY_ID", nullable = false, length = 1)
	private String productCategoryId;

	@Column(name = "PRODUCT_CATEGORY_NAME", nullable = false, length = 64)
	private String productCategoryName;

	@Column(name = "INSERT_DATE", nullable = false)
	private Timestamp insertDate;

	@Column(name = "INSERT_USER", nullable = false, length = 64)
	private String insertUser;

	@Column(name = "UPDATE_DATE", nullable = false)
	private Timestamp updateDate;

	@Column(name = "UPDATE_USER", nullable = false, length = 64)
	private String updateUser;

	@Column(name = "DELETE_DATE", nullable = true)
	private Timestamp deleteDate;

	@Column(name = "DELETE_USER", nullable = true, length = 64)
	private String deleteUser;

	@OneToMany //(mappedBy = "fk")
	@JoinColumn(name="PRODUCT_CATEGORY_ID")
	private List<TrProductEntity> trProductEntity;

	/**
	 * getter and setter
	 */
	public String getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
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
