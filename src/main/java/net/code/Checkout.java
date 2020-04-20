package net.code;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 購入者情報の管理クラス
 * @author SatoYusuke0228
 */
public class Checkout {

	@NotNull(message="入力してください")
	@Size(min=1, message="入力してください")
	@Size(max=32, message="入力が長すぎます")
	private String firstName;

	@NotNull(message="入力してください")
	@Size(min=1, message="入力してください")
	@Size(max=32, message="入力が長すぎます")
	private String lastName;

	@NotNull(message="入力してください")
	@Pattern(regexp="[0-9]{7}", message="7桁の半角数字のみ入力して下さい")
	private String zipcode;

	@NotNull(message="入力してください")
	@Size(min=1, message="入力してください")
	@Size(max=64, message="入力が長すぎます")
	private String mainAddress;

	@Size(max=64, message="入力が長すぎます")
	private String buildingAddress;

    @NotNull(message="入力してください")
    @Size(min=1, message="入力してください")
    @Size(max=11, message="入力が長すぎます")
    @Pattern(regexp="[0-9]*", message="数字のみ入力してください")
    private String tell;

    @NotNull(message="入力してください")
    @Size(min=1, message="入力してください")
    @Size(max=128, message="入力が長すぎます")
    @Email
    private String email;

    @NotNull(message="入力してください")
    @Size(min=16, message="16桁入力してください")
    @Size(max=16, message="16桁入力してください")
    @Pattern(regexp="[0-9]*", message="数字のみ入力してください")
    private String creditCardNum;

    @NotNull(message="入力してください")
    @Size(min=1, message="入力してください")
    @Size(max=32, message="入力が長すぎます")
    @Pattern(regexp="[a-zA-Z]*", message="アルファベットと半角スペースのみ入力してください")
    private String creditCardName;

    @NotNull(message="入力してください")
    @Pattern(regexp="[0-1][0-9]", message="数字のみ2けた入力してください")
    private String creditCardMonth;

    @NotNull(message="入力してください")
    @Pattern(regexp="[0-9][0-9]", message="数字のみ2けた入力してください")
    private String creditCardYear;

    @NotNull(message="入力してください")
    @Pattern(regexp="[0-9]{3}", message="数字のみ3けた入力してください")
    private String creditCardCvs;

    /**
     * コンストラクタ
     * @author SatoYusuke0228
     */
    public Checkout() {}

    /**
     * getter and setter
     * @author SatoYusuke0228
     */
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getMainAddress() {
		return mainAddress;
	}

	public void setMainAddress(String mainAddress) {
		this.mainAddress = mainAddress;
	}

	public String getBuildingAddress() {
		return buildingAddress;
	}

	public void setBuildingAddress(String buildingAddress) {
		this.buildingAddress = buildingAddress;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreditCardNum() {
		return creditCardNum;
	}

	public void setCreditCardNum(String creditCardNum) {
		this.creditCardNum = creditCardNum;
	}

	public String getCreditCardName() {
		return creditCardName;
	}

	public void setCreditCardName(String creditCardName) {
		this.creditCardName = creditCardName;
	}

	public String getCreditCardMonth() {
		return creditCardMonth;
	}

	public void setCreditCardMonth(String creditCardMonth) {
		this.creditCardMonth = creditCardMonth;
	}

	public String getCreditCardYear() {
		return creditCardYear;
	}

	public void setCreditCardYear(String creditCardYear) {
		this.creditCardYear = creditCardYear;
	}

	public String getCreditCardCvs() {
		return creditCardCvs;
	}

	public void setCreditCardCvs(String creditCardCvs) {
		this.creditCardCvs = creditCardCvs;
	}

}
