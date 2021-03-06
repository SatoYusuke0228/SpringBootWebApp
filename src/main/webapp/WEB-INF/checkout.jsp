<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="/WEB-INF/template/header.jsp"%>
<!-- メイン -->
<main>
	<div class="maincol">
		<table class="table">
			<thead>
				<tr>
					<th class="name-space" scope="col">商品</th>
					<th class="quantity-space" scope="col">個数</th>
					<th class="price-space" scope="col">小計</th>
					<th class="button-space" scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cart.cartItems}" var="item">
					<tr>
						<td>${item.value.getName()}</td>
						<td>${item.value.getQuantity()}</td>
						<td>¥${item.value.getQuantity() * item.value.getPrice()}-</td>
						<td></td>
					</tr>
				</c:forEach>
				<tr class="total">
					<td>合計</td>
					<td></td>
					<td>¥${cart.grandTotal}-</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<!-- 購入者 入力フォーム -->
		<form:form action="purchase" modelAttribute="checkout">
			<h2>Address</h2>
			<br>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label>姓(*)入力必須です</label>
					<form:input path="firstName" type="text" class="form-control" />
					<form:errors path="firstName" class="error" />
				</div>
				<div class="form-group col-md-6">
					<label>名(*)入力必須です</label>
					<form:input path="lastName" type="text" class="form-control" />
					<form:errors path="lastName" class="error" />
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label>郵便番号(-なしで入力してください)(*)入力必須です</label>
					<form:input path="zipcode" type="text" class="form-control" />
					<form:errors path="zipcode" class="error" />
				</div>
			</div>
			<div class="form-group">
				<label>住所(*)入力必須です</label>
				<form:input path="mainAddress" type="text" class="form-control" />
				<form:errors path="mainAddress" class="error" />
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label>アパート名、号室など</label>
					<form:input path="buildingAddress" type="text" class="form-control" />
					<form:errors path="buildingAddress" class="error" />
				</div>
			</div>
			<div class="form-group">
				<label>電話番号(-なしで入力してください)(*)入力必須です</label>
				<form:input path="tell" type="text" class="form-control" />
				<form:errors path="tell" class="error" />
			</div>
			<div class="form-group">
				<label>メールアドレス(*)入力必須です</label>
				<form:input path="email" type="email" class="form-control" />
				<form:errors path="email" class="error" />
			</div>
			<h2>Credit Card Information</h2>
			<br>
			<div class="form-group">
				<label>カード番号(-なしで入力してください)(*)入力必須です</label>
				<form:input path="creditCardNum" type="text" class="form-control" />
				<form:errors path="creditCardNum" class="error" />
			</div>
			<div class="form-group">
				<label>カード名義(*)入力必須です</label>
				<form:input path="creditCardName" type="text" class="form-control" />
				<form:errors path="creditCardName" class="error" />
			</div>
			<div class="form-row">
				<div class="form-group col-md-4">
					<label>有効年月(*)入力必須です</label>
					<form:input path="creditCardMonth" type="text" class="form-control"
						placeholder="月" />
					<form:errors path="creditCardMonth" class="error" />
				</div>
				<div class="form-group col-md-4">
					<label></label>
					<form:input path="creditCardYear" type="text" class="form-control"
						placeholder="年" />
					<form:errors path="creditCardYear" class="error" />
				</div>
				<div class="form-group col-md-4">
					<label>セキュリティコード(CVS)(*)入力必須です</label>
					<form:input path="creditCardCvs" type="text" class="form-control" />
					<form:errors path="creditCardCvs" class="error" />
				</div>
			</div>
			<input class="btn btn-primary" type="submit" value="購入" />
		</form:form>
	</div>
</main>
<!-- メイン終了 -->
<%@include file="/WEB-INF/template/footer.jsp"%>