<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
						<td>&yen;${item.value.getQuantity() * item.value.getPrice()}-</td>
						<td>
							<button onclick="location.href='/cart/remove/${item.value.getId()}'">削除</button>
						</td>
					</tr>
				</c:forEach>
				<tr class="total">
					<td>合計</td>
					<td></td>
					<td>&yen;${cart.grandTotal}-</td>
					<td>
						<button onclick="location.href='/'"><strong>買い物を続ける</strong></button>
						<c:if test="${cart.grandTotal > 0}">
							<button onclick="location.href='/showform'"><strong>購入画面へ進む</strong></button>
						</c:if>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</main>
<!-- メイン終了 -->
<%@include file="/WEB-INF/template/footer.jsp"%>