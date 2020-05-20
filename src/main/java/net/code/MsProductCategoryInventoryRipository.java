package net.code;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MsProductCategoryInventoryRipository extends
		JpaRepository<MsProductCategoryInventoryEntity, Integer> {};