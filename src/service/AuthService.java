package service;

import dao.UserDao;
import dto.UserDto;

public class AuthService {

	public UserDto login(String mail, String pass) {
		UserDao dao = new UserDao();
		UserDto loginUser = dao.findByLoginUser(mail, pass);
		return loginUser;
	}
}