<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tsubuyaki</title>
</head>
<body>
<header>
	<div class="container">
		<div class="flex_parent">
			<div class="logo">
				<a href="/tweet_servlet/top">Tweet
				</a>
			</div>
		</div>
	</div>
</header>
<main id="index">
	<div class="section_inner">
		<div class="container">
			<h1>ログイン</h1>
			<form class="login_form" action="login" method="POST">
				<label for="email">mail：</label>
				<input id="email" type="email" name="mail"><br>
				<label for="pass">pass：</label>
				<input id="pass" type="password" name="pass"><br>
				<button type="submit">ログイン</button>
			</form>
		</div>
	</div>
</main>
<footer class="flex_parent">
	<p><small>&copy; 2022 tsubuyaki</small></p>
</footer>
</body>
</html>