<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="net.code.TrProductEntity"
	import= "java.util.List"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<!-- メイン -->
<main>
	<div class="container">
		<section class="area">
			<div class="area1">
				<img src="image/coffee-beens.jpg" alt="画像が見つかりません" class="coffee-beens">
				<h1 data-splitting="" class="words chars splitting" style="--word-total:1; --char-total:9;">
					<span class="word" data-word="Breathing" style="--word-index:0;">
						<span class="char" data-char="C" style="--char-index:0;">C</span>
						<span class="char" data-char="O" style="--char-index:1;">O</span>
						<span class="char" data-char="F" style="--char-index:2;">F</span>
						<span class="char" data-char="F" style="--char-index:3;">F</span>
						<span class="char" data-char="E" style="--char-index:4;">E</span>
						<span class="char" data-char="E" style="--char-index:5;">E</span>
						<!--
						<span class="char" data-char="" style="--char-index:6;"></span>
						<span class="char" data-char="" style="--char-index:7;"></span>
						<span class="char" data-char="" style="--char-index:8;"></span>
						-->
					</span>
				</h1>
				<script src="https://static.codepen.io/assets/common/stopExecutionOnTimeout-157cd5b220a5c80d4ff8e0e70ac069bffd87a61252088146915e8726e5d9f147.js"></script>
				<script id="rendered-js">
					Splitting();
					//# sourceURL=js/test.js
				</script>
				<script src="https://static.codepen.io/assets/editor/iframe/iframeRefreshCSS-e03f509ba0a671350b4b363ff105b2eb009850f34a2b4deaadaa63ed5d970b37.js"></script>
			</div>
		</section>
		<!-- コンテンツ 2ページ目 -->
		<section class="area">
			<div class="area2">
				<img src="/image/coffee-map.jpg" alt="画像が見つかりません" class="coffee-map">
			</div>
		</section>
		<!-- コンテンツ 3ページ目 -->
		<section class="area">
			<div class="area3">
			<c:forEach items="${recommendedProductList}" var="pl">
				<div id="slidewrap">
					<div id="slidemask">
						<ul id="photo">
							<li id="slide01"><img
								src="/image/${pl.productPhotoFileName1}" height="350px"
								width="275px" alt="${pl.productPhotoFileName1}"> <span>
									${pl.productName} </span></li>
							<li id="slide02"><img
								src="/image/${pl.productPhotoFileName1}" height="350px"
								width="275px" alt=" ${pl.productName}"> <span>
									${pl.productName} </span></li>
							<li id="slide03"><img
								src="/image/${pl.productPhotoFileName1}" height="350px"
								width="275px" alt=" ${pl.productName}"> <span>
									${pl.productName} </span></li>
							<li id="slide04"><img
								src="/image/${pl.productPhotoFileName1}" height="350px"
								width="275px" alt=" ${pl.productName}"> <span>
									${pl.productName} </span></li>
						</ul>
					</div>
					<!--/#slidemask-->
					<ul id="thumb">
						<li id="thumb01"><a href="item/${pl.productId}"> <img
								src="/image/${pl.productPhotoFileName1}" alt="${pl.productName}">
						</a></li>
						<li id="thumb02"><a href="item/${pl.productId}"> <img
								src="/image/${pl.productPhotoFileName1}" alt="${pl.productName}">
						</a></li>
						<li id="thumb03"><a href="item/${pl.productId}"> <img
								src="/image/${pl.productPhotoFileName1}" alt="${pl.productName}">
						</a></li>
						<li id="thumb04"><a href="item/${pl.productId}"> <img
								src="/image/${pl.productPhotoFileName1}" alt="${pl.productName}">
						</a></li>
					</ul>
				</div>
				</c:forEach>
			</div>
		</section>
	</div>
</main>
<!-- メイン終了 -->
<%@include file="/WEB-INF/template/footer.jsp"%>