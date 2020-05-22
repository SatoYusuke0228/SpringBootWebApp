package net.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

/**
 * 商品表示関係のコントローラー
 * @author SatoYusuke0228
 */
@Controller
public class ShowItemsController {

	//商品テーブルに関わる処理のインスタンス
	@Autowired
	private TrProductService productService;

	//商品カテゴリーテーブルに関わる処理のインスタンス
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
	public String showRecommendedItems(Model model) {

		//全商品取得
		List<TrProductEntity> items = productService.findAll();

		List<TrProductEntity> recommendedItems = new ArrayList<TrProductEntity>();

		Random random = new Random();

		while (items!=null) {

			int recommendedItemsRandomID = random.nextInt(items.size());

			recommendedItems.add(items.get(recommendedItemsRandomID));
			System.out.println(recommendedItems.get(recommendedItemsRandomID).getProductName());

			if (recommendedItems.size() == 3) {
				break;
			}
		}

		//取得した全販売商品データをmodelに保存
		model.addAttribute("recommendedItems", recommendedItems);

		return "index";
	}

	/**
	 * 商品一覧ページをカテゴリーごとに表示するためのメソッド
	 * @author SatoYusuke0228
	 */
	@RequestMapping("/{pageName}/category/{categoryId}")
	public String showItemsByCategory(
			@PathVariable String pageName,
			@PathVariable int categoryId) {

		Optional<MsProductCategoryInventoryEntity> itemsByCategory = categoryService.findById(categoryId);

		try {
			if (0 < itemsByCategory.get().getTrProductEntity().size()) {
				pageName = "item-list";
				session.setAttribute("itemsByCategory", itemsByCategory);
			} else {
				pageName = notFoundItemPage();
			}
		} catch (InternalServerError e) {
			pageName = notFoundItemPage();
		}

		return pageName;
	}

	/**
	 * 商品一覧ページを検索ワードごとに表示するためのメソッド
	 * @author SatoYusuke0228
	 */
	//	@RequestMapping("/item-list2")
	//	public ModelAndView sendItemsByKeyword(@RequestParam String keyword, ModelAndView mav) {
	//
	//		List<TrProductEntity> itemsByKeyword = productService.findByKeyword(keyword);
	//		mav.setViewName("item-list2");
	//		mav.addObject("itemsByKeyword", itemsByKeyword);
	//
	//		return mav;

	/**
	 * 商品一覧ページを検索ワードごとに表示するためのメソッド
	 * @author SatoYusuke0228
	 */
	@RequestMapping("/{pageName}")
	public String sendItemsByKeyword(
			@PathVariable String pageName,
			@RequestParam String keyword,
			Model model) {

		List<TrProductEntity> itemsByKeyword = productService.findByKeyword(keyword);

		//		もしListの中に商品があれば、商品一覧ページに遷移
		//		しかし、Listの中に商品がなければ、商品が見つからないという結果を表示するページに遷移
		if (0 < itemsByKeyword.size()) {
			model.addAttribute("itemsByKeyword", itemsByKeyword);
			pageName = "item-list2";
		} else {
			pageName = notFoundItemPage();
		}

		return pageName;
	}

	/**
	 * 商品詳細ページを表示するためのメソッド
	 * @author SatoYusuke0228
	 */
	@RequestMapping("/item/{id}")
	public String showItemPage(@PathVariable String id, Model model) {

		//指定されたIDの商品を取得
		TrProductEntity selectedItem = productService.getItemInfo(id);

		//EntityをModelに登録
		model.addAttribute("selectedItem", selectedItem);
		return "item";
	}

	/**
	 * 商品がつからない場合に表示するページに遷移するために使用するメソッド
	 * @author SatoYusuke0228
	 */
	@RequestMapping("/notFound")
	public String notFoundItemPage() {
		return "notFound";
	}

}