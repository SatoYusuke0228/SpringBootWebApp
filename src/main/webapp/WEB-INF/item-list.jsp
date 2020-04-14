<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/template/header.jsp"%>
<!-- メイン -->
<main>
	<c:forEach items="${ProductList}" var="pl">
		<div class="product-list-container">
			<section class="product-list-area">
				<div class="slide-box">
					<a href="/item/${pl.productId}"> <img
						src="image/${pl.productPhotoFileName1}">
						<p>${pl.productName}</p>
					</a>
				</div>
			</section>
		</div>
	</c:forEach>
</main>
<!-- メイン終了 -->
<%@ include file="/WEB-INF/template/footer.jsp"%>