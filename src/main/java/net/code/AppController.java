package net.code;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * コントローラー
 * @author SatoYusuke0228
 */
@Controller
public class AppController {

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
	public String showTopPage(Model model) {

		//全商品取得
		List<TrProductEntity> recommendedProductList = productService.findAll();

		//取得した全販売商品データをmodelに保存
		model.addAttribute("recommendedProductList", recommendedProductList);

		return "index";
	}

	/**
	 * 商品一覧ページをカテゴリーごとに表示するためのメソッド
	 * @author SatoYusuke0228
	 */
	@RequestMapping("/item-list/{category}")
	public String showItemListPageByCategory(@PathVariable int category) {

		Optional<MsProductCategoryInventoryEntity> categoryList = categoryService.findById(category);
		session.setAttribute("categoryList", categoryList);

		return "item-list";
	}

	/**
	 * 商品一覧ページを検索ワードごとに表示するためのメソッド
	 * @author SatoYusuke0228
	 */
	 @RequestMapping("/item-list2/{nameQuery}")
	 public String showItemListPageByKeyword(@PathVariable String nameQuery, Model model) {
		//List<TrProductEntity> entity= productService.findAll(nameQuery, Pageable pageable);
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

	/**
	 * カート画面を表示するメソッド
	 * @author SatoYusuke0228
	 */
	@RequestMapping("/cart")
	public String showCartItem() {

		return "cart";
	}

	/**
	 * カートに商品を追加するメソッド
	 * @author SatoYusuke0228
	 */
	@RequestMapping("/cart/add/{id}")
	public String addCartItem(@PathVariable String id) {

		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null) {
			// セッションにカートの登録がなければ新規作成
			cart = new Cart();
		}

		//カートにアイテムを追加
		TrProductEntity selectedItem = productService.getOne(id);
		CartItem cartItem = new CartItem(selectedItem);
		cart.addCartItem(cartItem);

		//カートをsessionスコープに保存
		session.setAttribute("cart", cart);

		return "redirect:/cart";
	}

	/**
	 * カートに商品を削除するメソッド
	 * @author SatoYusuke0228
	 */
	@RequestMapping("/cart/remove/{id}")
	public String removeCartItem(@PathVariable String id) {

		//カートから商品を削除
		Cart cart = (Cart) session.getAttribute("cart");
		cart.removeCartItem(id);

		//カートをsessionスコープに保存
		session.setAttribute("cart", cart);

		return "redirect:/cart";
	}

	/**
	 * Form入力欄にスペース等が入れられた場合にトリミングするメソッド
	 * @author SatoYusuke0228
	 */
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, editor);
	}

	/**
	 * checkout画面を表示するメソッド
	 *
	 * @author SatoYusuke0228
	 */
	@RequestMapping("/showform")
	public String showForm(Model model) {
		//購入情報オブジェクトを作成してモデルに登録
		model.addAttribute("checkout", new Checkout());

		return "checkout";
	}

	/**
	 * 「購入」ボタンがクリックされた時の処理メソッド
	 *
	 * @parm checkout
	 * 引数1
	 * 名前やクレジットカードなど
	 * 入力されたデータを持っているオブジェクト.
	 *
	 * @parm result
	 * 引数2
	 * バリデーションチェックの結果が格納されています。
	 * hasErrors()メソッドの戻り値がtrueの場合は、
	 * バリデーションチェックがエラーということで、
	 * もういちどcheckout画面へ遷移してエラーメッセージを表示。
	 * OKの場合はカートを空にして購入完了画面purchase.jspへ遷移。
	 *
	 * @author SatoYusuke0228
	 */
	@RequestMapping("/purchase")
	public String purchase(
			@Valid @ModelAttribute("checkout") Checkout checkout,
			BindingResult result) {

		if (result.hasErrors()) {
			// 元の画面にエラーメッセージを表示
			return "checkout";
		}

		// カートの中身を初期化
		Cart cart = new Cart();
		session.setAttribute("cart", cart);

		return "purchase";
	}
}