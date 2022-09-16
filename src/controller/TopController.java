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

@WebServlet("/top")
public class TopController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
		dispatcher.forward(request, response);HttpSession session = request.getSession();
		UserDto loginUser = (UserDto) session.getAttribute("loginUser");

		if (loginUser == null) {
 			response.sendRedirect("/tweet_servlet");
 		} else {
 			TweetService tweetService = new TweetService();
 			List<TweetDto> tweetList = tweetService.findAllTweets();
 			request.setAttribute("tweetList", tweetList);

 			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String post = request.getParameter("post");

		if(post != null && post.length() != 0) {
			HttpSession session = request.getSession();
			UserDto loginUser = (UserDto) session.getAttribute("loginUser");

			TweetService tweetService = new TweetService();
			tweetService.createTweet(loginUser.getId(), post);
		}
		doGet(request, response);

	}
}