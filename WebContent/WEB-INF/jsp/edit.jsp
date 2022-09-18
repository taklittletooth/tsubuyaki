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
					<li><a href="/tweet_servlet/login">ログアウト</a></li>
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
<main id="edit">
	<div class="section_inner">
		<div class="container width_narrow">
			<div class="bread_crumb">
				<a href="/tweet_servlet/top">top</a> &gt; <a
					href="/tweet_servlet/mypage">mypage</a> &gt; edit
			</div>
			<h1>投稿を修正</h1>
			<form class="tweet_form" action="/tweet_servlet/edit" method="POST">
				<input type="hidden" name="tweet_id" value="">
				<input type="text" name="post" value="" required>
				<button type="submit" name="action">更新</button>
			</form>
		</div>
	</div>
</main>

<jsp:include page="template/footer.jsp" />