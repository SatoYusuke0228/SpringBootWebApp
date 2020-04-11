package net.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * コントローラー
 * @author SatoYusuke0228
 */
@Controller
public class AppController {

	@Autowired
	private TrProductService productService;

//	セッションスコープ
//	@Autowired
//	HttpSession session;

	@RequestMapping("/")
	public String showTopPage(Model model) {

//		全商品取得
		List<TrProductEntity> productList = productService.findAll();

//		取得した全販売商品データをmodelに保存
		model.addAttribute("productList", productList);

		return "index";
	}
}