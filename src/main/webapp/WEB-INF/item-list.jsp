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
			<%Optional<MsProductCategoryInventoryEntity> itemsByCategory = (Optional<MsProductCategoryInventoryEntity>) session.getAttribute("itemsByCategory");%>
			<%for(int i=0; i <itemsByCategory.get().getTrProductEntity().size(); i++) { %>
				<%TrProductEntity items = itemsByCategory.get().getTrProductEntity().get(i);%>
				<li>
					<a href="/item/<%=items.getProductId()%>">
						<img src="/image/<%=items.getProductPhotoFileName1()%>">
						<p><%=items.getProductName()%></p>
					</a>
				</li>
			<% } %>
			</ul>
		</section>
	</div>
</main>
<!-- メイン終了 -->
<%@ include file="/WEB-INF/template/footer.jsp"%>