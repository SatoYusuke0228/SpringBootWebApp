package net.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *Repositoryインターフェースに実行させたいメソッドを記述していく
 * @author SatoYusuke0228
 */
@Service
public class TrProductService {

	@Autowired
	private TrProductRipository productRepository;

	/**
	 * 商品テーブルの中身を全て取得するメソッド
	 */
	public List<TrProductEntity> findAll() {
		return productRepository.findAll();
	}

	/**
	 * 商品テーブルの中身をproductCategoryId別に取得するメソッド
	 */
	public List<TrProductEntity> findAll(String productCategoryId) {

		//商品カテゴリID==0のListを作成
		if ("0".equals(productCategoryId)) {

		//商品カテゴリID==1のListを作成
		} else if ("1".equals(productCategoryId)) {

		//商品カテゴリID==2のListを作成
		} else if ("2".equals(productCategoryId)) {

		}
		return productRepository.findAll();
	}

	/**
	 * 商品テーブルの中身をProductId別で取得するメソッド
	 */
	public TrProductEntity getOne(String id) {
		return productRepository.getOne(id);
	}
}
