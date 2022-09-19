package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.TweetDto;
import dto.UserDto;
import service.TweetService;

@WebServlet("/mypage")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDto loginUser = (UserDto) session.getAttribute("loginUser");

		if(loginUser != null) {
			TweetService tweetService = new TweetService();
			List<TweetDto> loginUserTweetList = tweetService.findUserTweets(loginUser.getId());
			request.setAttribute("loginUserTweetList", loginUserTweetList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
			dispatcher.forward(request, response);

		} else {
			response.sendRedirect("/tweet_servlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}