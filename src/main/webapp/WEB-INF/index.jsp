<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="net.code.TrProductEntity"
	import="java.util.List"
%>

<!doctype html>
<html>
<head>
<meta charset='UTF-8'>
<meta name=”viewport” content=”width=device-width,initial-scale=1.0″>
<title>ECサイト・テスト</title>
<link rel="stylesheet" href="css/style.css">
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<!-- ヘッダー -->
<header>
<!-- メニューバー -->
<div class="cp_navi">
  <!-- ヘッダーロゴ画像 -->
  <ul>
    <li class="logo">
      <img src="image/test-rogo.PNG" alt="ロゴ" >
    </li>
    <li class="search">
        <!-- 検索ワードで検索可能にするボックスを用意する -->
          <form method="get" action="path" class="search_container">
            <input type="text" size="25" placeholder="キーワードで探す">
            <input type="submit" value="&#xF002">
          </form>
    </li>
    <li>
      <a href="index.html">Home</a>
    </li>
    <li>
      <a href="#">Category
        <span class="caret"></span>
      </a>
      <div>
        <ul>
          <li><a href="product-list.html">コーヒー豆</a></li>
          <li><a href="product-list.html">抽出器具</a></li>
          <li><a href="product-list.html">その他</a></li>
        </ul>
      </div>
    </li>
    <li>
      <a href="#">Cart</a>
    </li>
  </ul>
</div>

</header>
<!-- ヘッダーここまで -->
<!-- メイン -->
<main>
<div class="container">
  <!-- コンテンツ 1ページ目 -->
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
      <img src="image/coffee-map.jpg" alt="画像が見つかりません" class="coffee-map">
    </div>
  </section>
  <!-- コンテンツ 3ページ目 -->
  <section class="area">
    <div class="area3">
      <div id="slidewrap">
        <div id="slidemask">
          <ul id="photo">
			<%
			//jspでセッションスコープを利用する準備
			List<TrProductEntity> productList = (List<TrProductEntity>) session.getAttribute("productList");
			for (int i=0; i<productList.size(); i++) {
				TrProductEntity entity = productList.get(i);
			%>
            <li id="slide01">
              <img src="image/<%= entity.getProductPhotoFileName1() %>" height="350px" width="275px" alt="<%= entity.getProductName() %>">
              <span><%= entity.getProductName() %></span>
            </li>

            <li id="slide02">
              <img src="image/<%= entity.getProductPhotoFileName1() %>" height="350px" width="275px" alt="<%= entity.getProductName() %>">
              <span><%= entity.getProductName() %></span>
            </li>
            <li id="slide03">
              <img src="image/<%= entity.getProductPhotoFileName1() %>" height="350px" width="275px" alt="<%= entity.getProductName() %>">
              <span><%= entity.getProductName() %></span>
            </li>
            <li id="slide04">
              <img src="image/<%= entity.getProductPhotoFileName1() %>" height="350px" width="275px" alt="<%= entity.getProductName() %>">
              <span><%= entity.getProductName() %></span>
            </li>
            <% } %>
          </ul>
        </div>
        <!--/#slidemask-->
        <ul id="thumb">
          <li id="thumb01">
            <a href="product-list.html">
              <img src="image/sample-1.jpg" alt="">
            </a>
          </li>
          <li id="thumb02">
            <a href="product-list.html">
              <img src="image/sample-2.jpg" alt="">
            </a>
          </li>
          <li id="thumb03">
            <a href="product-list.html">
              <img src="image/sample-3.jpg" alt="">
            </a>
          </li>
          <li id="thumb04">
            <a href="product-list.html">
              <img src="image/sample-4.jpg" alt="">
            </a>
          </li>
        </ul>
      </div>
    </div>
  </section>
</div>
</main>
<!-- メイン終了 -->
<!-- フッター -->
<footer>
  <h4> © 2020 SatoYusuke </h4>
</footer>
<!-- フッターここまで -->
</body>
</html>