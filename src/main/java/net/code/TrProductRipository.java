package net.code;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 商品テーブルRepositoryインターフェース
 * @author SatoYusuke0228
 */
public interface TrProductRipository extends JpaRepository<TrProductEntity, String> {

}