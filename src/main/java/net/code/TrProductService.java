package net.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SatoYusuke0228
 */
@Service
public class TrProductService {
	
	@Autowired
	private TrProductRipository productRepository;
	
	public List<TrProductEntity> findAll() {
		return productRepository.findAll();
	}
}
