package net.code;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商品表示関係のコントローラー
 * @author SatoYusuke0228
 */
@Controller
public class ShowItemsController {

	//商品テーブルに関わる処理のインスタンス
	@Autowired
	private TrProductService productService;

	@Autowired
	private MsProductCategoryInventoryService categoryService;

	//セッションスコープのインスタンス
	@Autowired
	private HttpSession session;

	/**
	 * TOPページで商品情報を取得するためのメソッド
	 * @author SatoYusuke0228
	 */
	@RequestMapping("/")
	public String showRecommendedItems (Model model) {

		//全商品取得
		List<TrProductEntity> recommendedItems = productService.findAll();

		//取得した全販売商品データをmodelに保存
		model.addAttribute("recommendedItems", recommendedItems);

		return "index";
	}

	/**
	 * 商品一覧ページをカテゴリーごとに表示するためのメソッド
	 * @author SatoYusuke0228
	 */
	@RequestMapping("/item-list/{category}")
	public String showItemsByCategory(@PathVariable int category) {

		Optional<MsProductCategoryInventoryEntity> itemsByCategory = categoryService.findById(category);
		session.setAttribute("itemsByCategory", itemsByCategory);

		return "item-list";
	}

	/**
	 * 商品一覧ページを検索ワードごとに表示するためのメソッド
	 * @author SatoYusuke0228
	 */
	 @RequestMapping("/item-list2/search{nameQuery}")
	 public String showItemsByKeyword(@PathVariable String nameQuery, Model model) {
		List<TrProductEntity> itemsByKeyword = productService.findAll(nameQuery);
		model.addAttribute("itemsByKeyword", itemsByKeyword);
		return  "item-list2";
	 }

	/**
	 * 商品詳細ページを表示するためのメソッド
	 * @author SatoYusuke0228
	 */
	@RequestMapping("/item/{id}")
	public String showItemPage(@PathVariable String id, Model model) {

		//指定されたIDの商品を取得
		TrProductEntity selectedItem = productService.getOne(id);

		//EntityをModelに登録
		model.addAttribute("selectedItem", selectedItem);
		return "item";
	}
}