package net.code;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * 商品テーブルのメタモデルクラス
 *
 * アプリケーションの商品検索に使用する。
 * メタモデルクラスからカラム名を取得するやり方の方が
 * より変更に強く堅牢な作りになる（らしい）
 *
 * @author 佐藤由佑
 */

@StaticMetamodel(TrProductEntity.class)
public class TrProductEntity_ {

	public static volatile SingularAttribute<TrProductEntity, String> productId;
	public static volatile SingularAttribute<TrProductEntity, String> productName;
	public static volatile SingularAttribute<TrProductEntity, String> productPhotoFileName1;

	public static final String PRODUCT_ID = "productId";
	public static final String PRODUCT_Name = "productName";
	public static final String PRODUCT_PHOTO_FILE_NAME1 = "productPhotoFileName1";
}