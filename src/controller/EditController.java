package controller;

import java.io.IOException;

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

@WebServlet("/edit")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDto loginUser = (UserDto) session.getAttribute("loginUser");
		int tweetId = Integer.parseInt(request.getParameter("id"));

		TweetService tweetService = new TweetService();
		TweetDto tweet = tweetService.findUserTweet(tweetId, loginUser.getId());

		if(tweet == null) {
			response.sendRedirect("/tweet_servlet/mypage");
		} else {
			request.setAttribute("tweet", tweet);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		UserDto loginUser = (UserDto) session.getAttribute("loginUser");
		TweetService tweetService = new TweetService();
		int tweetId = Integer.parseInt(request.getParameter("tweet_id"));

		tweetService.deleteTweetById(tweetId, loginUser.getId());

		response.sendRedirect("/tweet_servlet/mypage");
	}
}