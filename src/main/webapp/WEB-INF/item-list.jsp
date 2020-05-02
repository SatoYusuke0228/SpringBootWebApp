<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="net.code.TrProductEntity"
	import="java.util.List"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<!-- メイン -->
<main>
	<div class="product-list-container">
		<section class="product-list-area">
			<ul>
			<c:forEach items="categoryList" begin="0" end="2" step="1">
				<li>
					<a href="/item/${categoryList.get().getTrProductEntity().get(0).getProductId()}">
						<img src="/image/${categoryList.get().getTrProductEntity().get(0).getProductPhotoFileName1()}">
						<p>${categoryList.get().getTrProductEntity().get(0).getProductName()}</p>
					</a>
				</li>
			</c:forEach>
			</ul>
		</section>
	</div>
</main>
<!-- メイン終了 -->
<%@ include file="/WEB-INF/template/footer.jsp"%>