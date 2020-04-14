package net.code;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	@Autowired
	HttpSession session;


	@RequestMapping("/")
	public String showTopPage(Model model) {

//		全商品取得
		List<TrProductEntity> recommendedProductList = productService.findAll();

//		取得した全販売商品データをmodelに保存
		model.addAttribute("recommendedProductList", recommendedProductList);

		return "index";
	}

	@RequestMapping("/item-list")
	public String showItemListPage(Model model) {

//		全商品取得
		List<TrProductEntity> productList = productService.findAll();

//		取得した全販売商品データをmodelに保存
		model.addAttribute("productList", productList);

		return "item-list";
	}

	@RequestMapping("/item/{id}")
	public String showItemPage(@PathVariable String id, Model model) {

//		指定されたIDの商品を取得
		TrProductEntity selectedItem = productService.getOne(id);

//		EntityをModelに登録
		model.addAttribute("selectedItem", selectedItem);

		return"item";
	}
}