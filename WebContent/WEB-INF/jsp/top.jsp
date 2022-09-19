<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.UserDto"%>
<%@ page import="dto.TweetDto"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>　tsubuyaki</title>
</head>
<body>

<%
	UserDto loginUser = (UserDto) session.getAttribute("loginUser");
	List<TweetDto> tweetList = (List<TweetDto>) request.getAttribute("tweetList");
%>



<header>
	<div class="container">
		<div class="flex_parent">
			<div class="logo">
				<a href="/tweet_servlet/top">DigTweet
				</a>
			</div>
			<nav>
				<ul>
					<%
						if(loginUser != null) {
					%>
					<li><a href="/tsubuyaki/login">ログアウト</a></li>
					<li><a href="/tsubuyaki/mypage">マイページ</a></li>
					<%
						}
					%>
				</ul>
			</nav>
		</div>
		<%
			if(loginUser != null) {
		%>
		<p class="small_text">こんにちは、<span class="user_name"><%= loginUser.getDisplayName() %></span>さん</p>
		<%
			}
		%>
	</div>
</header>
<main id="top">
	<div class="section_inner">
		<div class="container">
			<h1>いまの気分を投稿しよう！</h1>
			<form class="tweet_form" action="/tsubuyaki/top" method="POST">
				<input type="text" name="post" placeholder="メッセージを入力" required>
				<button type="submit">投稿</button>
			</form>
			<%
				for (TweetDto tweet : tweetList) {
			%>
			<div
				class="tweet_box flex_parent <%= (tweet.getUserId() == loginUser.getId()) ? "login_user" : "" %>">
				<div class="tweet_text_box">
					<p class="tweet_text"><%= tweet.getPost() %></p>
					<P class="tweet_date small_text">
						投稿日：<%= tweet.getCreatedAt() %>
						<%
							if (tweet.getUpdatedAt() != null) {
						%>
						<br>更新日：<%= tweet.getUpdatedAt() %>
						<%
							}
						%>
					</p>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
</main>
<footer class="flex_parent">
	<p><small>&copy; tsubuyaki</small></p>
</footer>
</body>
</html>
