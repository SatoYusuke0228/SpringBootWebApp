<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="net.code.TrProductEntity"
	import="java.util.List"
	import="java.util.Optional"
	import="net.code.*"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<!-- メイン -->
<main>
	<div class="product-list-container">
		<section class="product-list-area">
			<ul>
			<c:forEach items="entity" var="entity">
				<li>
					<a href="/item/${entity.get().getProductId()}">
						<img src="/image/${entity.get().getProductPhotoFileName1()}">
						<p>${entity.get().getProductName()}</p>
					</a>
				</li>
			</c:forEach>
			</ul>
		</section>
	</div>
</main>
<!-- メイン終了 -->
<%@ include file="/WEB-INF/template/footer.jsp"%>