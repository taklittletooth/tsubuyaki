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
	List<TweetDto> loginUserTweetList = (List<TweetDto>) request.getAttribute("loginUserTweetList");
%>



<	<div class="container">
		<div class="flex_parent">
			<div class="logo">
				<a href="/tweet_servlet/top">DigTweet
				</a>
			</div>
			<nav>
				<ul>
					<%
						if (loginUser == null) {
					%>
					<li><a href="#">登録</a></li>
					<%
						} else {
					%>
					<li><a href="/tweet_servlet/mypage">マイページ</a></li>
					<li><a href="/tweet_servlet/login">ログアウト</a></li>
					<%
						}
					%>
				</ul>
			</nav>
		</div>
		<%
			if (loginUser != null) {
		%>
		<p class="small_text">
			こんにちは、<span class="user_name"><%= loginUser.getDisplayName() %></span>さん
		</p>
		<%
			}
		%>
	</div>
</header>
<main id="mypage">
	<div class="section_inner">
		<div class="container width_narrow">
			<div class="bread_crumb">
				<a href="/tweet_servlet/top">top</a> &gt; mypage
			</div>
			<h1>マイページ</h1>
			<div class="profile_box">
				<div class="flex_parent">
					<div class="login_user_box">
						<div class="user_icon flex_parent">
							<%= loginUser.getDisplayName().substring(0, 1) %>
						</div>
					</div>
					<div class="login_user_info flex_parent">
						<p><%= loginUser.getDisplayName() %></p>
						<p><%= loginUser.getMail() %></p>
					</div>
					<button>プロフィールを変更</button>
				</div>
				<hr>
				<div class="plofile_text_box">
					<h1 class="small_text">プロフィール</h1>
					<p><%= (loginUser.getProfile() != null) ? loginUser.getProfile() : "" %></p>
				</div>
			</div>
			<%
				for (TweetDto tweet : loginUserTweetList) {
			%>
<div class="tweet_box flex_parent">
				<div class="tweet_text_box">
					<p class="tweet_text"><%= tweet.getPost() %></p>
					<p class="tweet_date small_text">
						投稿日：<%= tweet.getCreatedAt() %>
						<%
							if (tweet.getUpdatedAt() != null) {
						%>
						<br>更新日：<%= tweet.getUpdatedAt() %>
						<%
							}
						%>
					</p>
					<hr>
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