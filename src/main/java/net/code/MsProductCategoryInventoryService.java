package net.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsProductCategoryInventoryService {

	@Autowired
	private MsProductCategoryInventoryRipository productCategoryInventoryRepository;

	/**
	 * カテゴリーテーブルの中身を全て取得するメソッド
	 */
	public List<MsProductCategoryInventoryEntity> findAll() {
		return productCategoryInventoryRepository.findAll();
	}
}
