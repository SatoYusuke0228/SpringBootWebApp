<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset='UTF-8'>
<meta name=”viewport” content=”width=device-width,initial-scale=1.0″>
<title>ECサイト・テスト</title>
<link rel="stylesheet" href="/css/style.css">
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
				<li class="logo"><img src="/image/test-rogo.PNG" alt="ロゴ">
				</li>
				<li class="search">
					<!-- 検索ワードで検索可能にするボックスを用意する -->
					<form method="get" action="path" class="search_container">
						<input type="text" size="25" placeholder="キーワードで探す"> <input
							type="submit" value="&#xF002">
					</form>
				</li>
				<li><a href="/"> Home </a></li>
				<li><a href=""> Category <span class="caret"></span>
				</a>
					<div>
						<ul>
							<li><a href="/item-list"> コーヒー豆 </a></li>
							<li><a href="/item-list"> 抽出器具 </a></li>
							<li><a href="/item-list"> その他 </a></li>
						</ul>
					</div></li>
				<li><a href="/cart"> Cart </a></li>
			</ul>
		</div>
	</header>
	<!-- ヘッダーここまで -->