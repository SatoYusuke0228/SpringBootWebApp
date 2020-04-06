package net.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * コントローラー
 * @author SatoYusuke0228
 */
@Controller
public class AppController {

	@Autowired
	private TrProductService productService;

	@RequestMapping("/")
	public String showTopPage() {

		System.out.println("コンソールコンソールコンソール");
//		//全商品取得
//		List<TrProductEntity> productList = productService.findAll();
//
//		for (int i = 0; i < productList.size(); i++) {
//			System.out.println("取得したファイル名");
//			System.out.println(productList.get(i).getProductPhotoFileName1());
//		}

		return "WEB-INF/index.jsp";
	}
}
