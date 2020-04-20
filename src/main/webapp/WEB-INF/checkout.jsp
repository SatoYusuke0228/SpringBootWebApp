<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
<head>
<meta charset='UTF-8'>
<meta name=”viewport” content=”width=device-width,initial-scale=1.0″>
<title>ECサイト・テスト</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<!-- ヘッダー -->
	<header>
		<!-- メニューバー -->
		<div class="cp_navi">
			<!-- ヘッダーロゴ画像 -->
			<ul>
				<li class="logo"><img src="/image/test-rogo.PNG" alt="ロゴ">
				</li>
				<li class="search">
					<!-- 検索ワードで検索可能にするボックスを用意する -->
					<form method="get" action="#" class="search_container">
						<input type="text" size="25" placeholder="キーワードで探す"> <input
							type="submit" value="&#xF002">
					</form>
				</li>
				<li><a href="/">Home</a></li>
				<li><a href="">Category <span class="caret"></span>
				</a>
					<div>
						<ul>
							<li><a href="/item-list"> コーヒー豆 </a></li>
							<li><a href="/item-list"> 抽出器具 </a></li>
							<li><a href="/item-list"> その他 </a></li>
						</ul>
					</div></li>
				<li><a href="/cart">Cart</a></li>
			</ul>
		</div>
	</header>
	<!-- ヘッダーここまで -->
	<!-- メイン -->
	<main>
		<div class="maincol">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">商品名</th>
						<th scope="col">個数</th>
						<th scope="col">小計</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cart.cartItems}" var="item">
						<tr>
							<td>${item.value.getName()}</td>
							<td>${item.value.getQuantity()}</td>
							<td>&yen;${item.value.getQuantity() * item.value.getPrice()}-</td>
							<td>
								<button
									onclick="location.href='/cart/remove/item.value.getId()'">削除</button>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td>合計</td>
						<td></td>
						<td>&yen;${cart.grandTotal}-</td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<br> <br>
			<form:form action="purchase" modelAttribute="checkout">
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
						<form:input path="buildingAddress" type="text"
							class="form-control" />
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
				<br>
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
						<form:input path="creditCardMonth" type="text"
							class="form-control" placeholder="月" />
						<form:errors path="creditCardMonth" class="error" />
					</div>
					<br>
					<div class="form-group col-md-4">
						<label></label>
						<form:input path="creditCardYear" type="text" class="form-control"
							placeholder="年" />
						<form:errors path="creditCardYear" class="error" />
					</div>
					<br>
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
<%@include file="/WEB-INF/template/footer.jsp"%>