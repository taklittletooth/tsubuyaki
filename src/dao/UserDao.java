package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UserDto;

public class UserDao extends AbstractDao {

	public UserDto findByLoginUser(String inputMail, String inputPass) {
		Connection conn = getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		UserDto loginUser = null;
		String sql = new StringBuilder("SELECT id, mail, display_name, pass, profile")
				.append(" FROM users")
				.append(" WHERE mail = ? AND pass = ?;")
				.toString();

		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, inputMail);
			pStmt.setString(2, inputPass);
			rs = pStmt.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String mail = rs.getString("mail");
				String displayName = rs.getString("display_name");
				String pass = rs.getString("pass");
				String profile = rs.getString("profile");
				loginUser = new UserDto(id, mail, displayName, pass, profile);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.close(rs);
			this.close(pStmt);
			this.close(conn);
		}
		return loginUser;
	}
}