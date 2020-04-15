<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="net.code.TrProductEntity"
	import="java.util.List"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<!-- メイン
<c:forEach items="${ProductList}" var="pl"> -->
	<main>
		<div class="product-list-container">
			<section class="product-list-area">
				<!--
				<div class="slide-box">
					<a href="/item/${pl.productId}">
						<img src="/image/${pl.productPhotoFileName1}">
						<p>${pl.productName}</p>
					</a>
				</div>
				-->
				<div class="slide-box">
         <a href="URL">
           <img src="image/sample-1.jpg">
           <p>商品1</p>
         </a>
       </div>
       <div class="slide-box">
         <a href="URL">
           <img src="image/sample-2.jpg">
           <p>商品2</p>
         </a>
       </div>
       <div class="slide-box">
         <a href="URL">
           <img src="image/sample-3.jpg">
           <p>テスト商品名テスト商品名テスト商品名テスト商品名テスト商品名テスト商品名テスト商品名テスト商品名テスト商品名テスト商品名テスト商品名テスト商品名テスト商品名テスト商品名テスト商品名テスト商品名</p>
         </a>
      </div>
      <div class="slide-box">
        <a href="URL">
          <img src="image/sample-4.jpg">
          <p>商品4</p>
        </a>
      </div>
      <div class="slide-box">
         <a href="URL">
           <img src="image/sample-1.jpg">
           <p>商品1</p>
         </a>
       </div>
       <div class="slide-box">
         <a href="URL">
           <img src="image/sample-2.jpg">
           <p>商品2</p>
         </a>
       </div>
       <div class="slide-box">
         <a href="URL">
           <img src="image/sample-3.jpg">
           <p>商品3</p>
         </a>
      </div>
      <div class="slide-box">
        <a href="URL">
          <img src="image/sample-4.jpg">
          <p>テスト商品名テスト商品名テスト商品名テスト商品名テスト商品名テスト商品名テスト商品名テスト商品名テスト商品名テスト商品名テスト商品名</p>
        </a>
      </div>
      <div class="slide-box">
         <a href="URL">
           <img src="image/sample-1.jpg">
           <p>商品1</p>
         </a>
       </div>
       <div class="slide-box">
         <a href="URL">
           <img src="image/sample-2.jpg">
           <p>商品2</p>
         </a>
       </div>
       <div class="slide-box">
         <a href="URL">
           <img src="image/sample-3.jpg">
           <p>商品3</p>
         </a>
      </div>
      <div class="slide-box">
        <a href="URL">
          <img src="image/sample-4.jpg">
          <p>商品4</p>
        </a>
      </div>
			</section>
		</div>
	</main>
<!-- </c:forEach>
メイン終了 -->
<%@ include file="/WEB-INF/template/footer.jsp"%>