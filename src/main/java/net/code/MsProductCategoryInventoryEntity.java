package net.code;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

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
	@Getter
	@Setter
	private String productCategoryId;

	@Column(name = "PRODUCT_CATEGORY_NAME", nullable = false, length = 64)
	@Getter
	@Setter
	private String productCategoryName;

	@Column(name = "INSERT_DATE", nullable = false)
	@Getter
	@Setter
	private Timestamp insertDate;

	@Column(name = "INSERT_USER", nullable = false, length = 64)
	@Getter
	@Setter
	private String insertUser;

	@Column(name = "UPDATE_DATE", nullable = false)
	@Getter
	@Setter
	private Timestamp updateDate;

	@Column(name = "UPDATE_USER", nullable = false, length = 64)
	@Getter
	@Setter
	private String updateUser;

	@Column(name = "DELETE_DATE", nullable = true)
	@Getter
	@Setter
	private Timestamp deleteDate;

	@Column(name = "DELETE_USER", nullable = true, length = 64)
	@Getter
	@Setter
	private String deleteUser;

	@OneToMany //(mappedBy = "fk")
	@JoinColumn(name="PRODUCT_CATEGORY_ID")
	private List<TrProductEntity> trProductEntity;
}
