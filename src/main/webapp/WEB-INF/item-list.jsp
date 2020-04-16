<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="net.code.TrProductEntity"
	import="java.util.List"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<!-- メイン -->
<main>
	<div class="product-list-container">
		<section class="product-list-area">
			<ul>
			<c:forEach items="${productList}" var="pl">
				<li>
					<a href="/item/${pl.productId}">
						<img src="/image/${pl.productPhotoFileName1}">
						<p> ${pl.productName} </p>
					</a>
				</li>
			</c:forEach>
			</ul>
		</section>
	</div>
</main>
<!-- メイン終了 -->
<%@ include file="/WEB-INF/template/footer.jsp"%>