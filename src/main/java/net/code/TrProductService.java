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
	 * 商品テーブルの中身をProductId別で取得するメソッド
	 */
	public TrProductEntity getOne(String id) {
		return productRepository.getOne(id);
	}

	/**
	 * 商品テーブルの中身をProductCategoryId別で取得するメソッド
	 */
	public List<TrProductEntity> search(int ProductCategoryId) {
		List<TrProductEntity> resultByCategory = productRepository.findAll();
		return resultByCategory;
	}
}
