package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserDto;
import service.AuthService;

@WebServlet("/login")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();

		response.sendRedirect("/tweet_servlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");

		AuthService authService = new AuthService();
		UserDto loginUser = authService.login(mail, pass);

		if(loginUser != null) {
			// ログイン成功時の処理
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);

			response.sendRedirect("/tsubuyaki/top");
		} else {
			// ログイン失敗時の処理
			response.sendRedirect("/tweet_servlet");
		}
	}
}
