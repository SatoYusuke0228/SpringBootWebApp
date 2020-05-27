package net.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	//リクエストスコープのインスタンス
	@Autowired
	private HttpServletRequest request;

	/**
	 * TOPページで商品情報を取得するためのメソッド。
	 * このメソッドで取得した商品情報は、TOPページのスライド写真として掲載される。
	 *
	 * @author SatoYusuke0228
	 */
	@RequestMapping("/")
	public String showRecommendedItems() {

		//全商品取得
		List<TrProductEntity> items = productService.findAll();

		//取得した全販売商品データをランダムで商品ピックアップするメソッドに渡してmodelに保存
		request.setAttribute("recommendedItems", randomPickupRecommendedItems(items));

		return "index";
	}

	/**
	 * TOPページで商品情報を取得するためのヘルパー関数。
	 * 全商品Listを受け取り、ランダムで４種オススメ商品をピックアップして格納したListを戻り値として返す。
	 *
	 * @param items
	 * 引数。全商品が格納されているList
	 *
	 * @author SatoYusuke0228
	 */
	private List<TrProductEntity> randomPickupRecommendedItems(List<TrProductEntity> items) {

		//オススメの商品リストのインスタンスを作成
		List<TrProductEntity> recommendedItems = new ArrayList<TrProductEntity>();

		//ランダムクラスのインスタンスを作成
		Random random = new Random();

		//オススメ商品Listのサイズが４つになるまで商品IDをランダム抽選
		while (recommendedItems.size() < 4) {

			//ランダムに抽出した商品と、すでにオススメ商品Listに含まれる商品の重複数
			int duplication = 0;

			//商品をランダム抽選
			int randomIndex = random.nextInt(items.size() - 1);

			//ランダムに抽出した商品と、すでにオススメ商品Listに含まれる商品が重複していないかチェック
			for (int i = recommendedItems.size(); 0 < i; i--) {
				if (items.get(randomIndex) == recommendedItems.get(i - 1)) {
					duplication++;
				}
			}
			//重複していない、かつ商品カテゴリーが(0)の場合のみ、オススメ商品Listに格納する
			if (duplication == 0 && items.get(randomIndex).getProductCategoryId() == 0) {
				recommendedItems.add(items.get(randomIndex));
			}
		}
		return recommendedItems;
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

		if (0 < itemsByCategory.get().getTrProductEntity().size()) {
			pageName = "item-list";
			session.setAttribute("itemsByCategory", itemsByCategory);
		} else {
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
	 *
	 * @author SatoYusuke0228
	 */
	@RequestMapping("/{pageName}")
	public String sendItemsByKeyword(
			@PathVariable String pageName,
			@RequestParam String keyword,
			Model model) {

		List<TrProductEntity> itemsByKeyword = productService.findByKeyword(keyword);

		//もしListの中に商品があれば、商品一覧ページに遷移
		//しかし、Listの中に商品がなければ、商品が見つからないという結果を表示するページに遷移
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