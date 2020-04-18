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

	//商品テーブルに関わる処理のインスタンス
	@Autowired
	private TrProductService productService;

	//セッションスコープのインスタンス
	@Autowired
	private HttpSession session;

	/**
	 * TOPページで商品情報を取得するためのメソッド
	 * @author SatoYusuke0228
	 */
	@RequestMapping("/")
	public String showTopPage(Model model) {

		//		全商品取得
		List<TrProductEntity> recommendedProductList = productService.findAll();

		//		取得した全販売商品データをmodelに保存
		model.addAttribute("recommendedProductList", recommendedProductList);

		return "index";
	}

	/**
	 * 商品一覧ページを表示するためのメソッド
	 * @author SatoYusuke0228
	 */
	@RequestMapping("/item-list")
	public String showItemListPage(Model model) {

		//		全商品取得
		List<TrProductEntity> productList = productService.findAll();

		//		取得した全販売商品データをmodelに保存
		model.addAttribute("productList", productList);

		return "item-list";
	}

	/**
	 * 商品詳細ページを表示するためのメソッド
	 * @author SatoYusuke0228
	 */
	@RequestMapping("/item/{id}")
	public String showItemPage(@PathVariable String id, Model model) {

		//		指定されたIDの商品を取得
		TrProductEntity selectedItem = productService.getOne(id);

		//		EntityをModelに登録
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

		return "redirected:/cart";
	}
}