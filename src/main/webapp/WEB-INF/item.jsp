<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!doctype html>
<html>
<head>
<meta charset='UTF-8'>
<meta name=”viewport” content=”width=device-width,initial-scale=1.0″>
<title>ECサイト・テスト</title>
<link rel="stylesheet" href="css/style.css">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<!-- ヘッダー -->
	<header>
		<!-- メニューバー -->
		<div class="cp_navi">
			<!-- ヘッダーロゴ画像 -->
			<ul>
				<li class="logo"><img src="image/test-rogo.PNG" alt="ロゴ">
				</li>
				<li class="search">
					<!-- 検索ワードで検索可能にするボックスを用意する -->
					<form method="get" action="#" class="search_container">
						<input type="text" size="25" placeholder="キーワードで探す"> <input
							type="submit" value="&#xF002">
					</form>
				</li>
				<li><a href="index.html">Home</a></li>
				<li><a href="#">Category <span class="caret"></span>
				</a>
					<div>
						<ul>
							<li><a href="product-list.html">コーヒー豆</a></li>
							<li><a href="product-list.html">抽出器具</a></li>
							<li><a href="product-list.html">その他</a></li>
						</ul>
					</div></li>
				<li><a href="#">Cart</a></li>
			</ul>
		</div>
	</header>
	<!-- ヘッダーここまで -->
	<!-- メイン -->
	<main>
		<div class="items-page">
			<div class="items-info">
				<img src="image/sample-1.jpg" alt="商品の写真" class="items-image">
				<div class="items-detail">
					<table>
						<tr>
							<th>商品名</th>
							<td>テスト商品名</td>
						</tr>
						<tr>
							<th>価格</th>
							<td>\1,000- (税込)</td>
						</tr>
						<tr class="items-comment">
							<th>商品説明</th>
							<td>テストコメントテストコメントテストコメントテストコメント
								テストコメントテストコメントテストコメントテストコメント テストコメントテストコメントテストコメントテストコメント
								テストコメントテストコメントテストコメントテストコメント テストコメントテストコメントテストコメントテストコメント</td>
						</tr>
					</table>
					<button onclick="cart.html">カートに入れる</button>
				</div>
			</div>
		</div>
	</main>
	<!-- メイン終了 -->
	<!-- フッター -->
	<footer>
		<h4>© 2020 SatoYusuke</h4>
	</footer>
	<!-- フッターここまで -->
	<script src="style.js"></script>
</body>
</html>