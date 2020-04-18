package net.code;

 /**
 * カート画面のバックエンド処理に使用するEntity
 *
 * @param id
 *  商品ID
 *
 * @param name
 *  商品名
 *
 * @param quantity
 *  商品個数
 *
 * @param price
 *  商品単価
 *
 * @see net.code.Cart
 *
 * @author SatoYusuke0228
 */
public class CartItem {

	private String id;
	private String name;
	private int quantity;
	private int price;

	/**
	 * コンストラクタ
	 */
	public CartItem() {}

	public CartItem(TrProductEntity item) {
		super();
		this.id = item.getProductId();
		this.name = item.getProductName();
		this.quantity = 1;
		this.price =  item.getProductPrice();
	}


	/*********************
	 * getter and setter *
	 ********************/

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}