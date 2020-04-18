<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/template/header.jsp"%>
<!-- メイン -->
<main>
	<div class="items-page">
		<div class="items-info">
			<img src="/image/${selectedItem.productPhotoFileName1}" alt="商品の写真"
				class="items-image">
			<div class="items-detail">
				<table>
					<tr>
						<th>商品名</th>
						<td>${selectedItem.productName}</td>
					</tr>
					<tr>
						<th>価格</th>
						<td>\ ${selectedItem.productPrice}-</td>
					</tr>
					<tr class="items-comment">
						<th>商品説明</th>
						<td>${selectedItem.productComment}</td>
					</tr>
				</table>
				<button onclick="location.href='/cart/add/${selectedItem.productId}'">カートに入れる</button>
			</div>
		</div>
	</div>
</main>
<!-- メイン終了 -->
<%@include file="/WEB-INF/template/footer.jsp"%>