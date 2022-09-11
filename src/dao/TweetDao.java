package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.TweetDto;

public class TweetDao extends AbstractDao {

	public List<TweetDto> findAll() {
		Connection conn = getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		List<TweetDto> tweetList = new ArrayList<TweetDto>();
		String sql = new StringBuilder("SELECT tweets.id, tweets.user_id, tweets.post, tweets.created_at, tweets.updated_at, users.display_name")
				.append(" FROM tweets")
				.append(" INNER JOIN users ON tweets.user_id = users.id")
				.append(" ORDER BY created_at DESC;")
				.toString();

		try {
			pStmt = conn.prepareStatement(sql);
			rs = pStmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int userId = rs.getInt("user_id");
				String post = rs.getString("post");
				LocalDateTime createdAt = rs.getObject("created_at", LocalDateTime.class);
				LocalDateTime updatedAt = rs.getObject("updated_at", LocalDateTime.class);
				String displayName = rs.getString("display_name");
				TweetDto tweet = new TweetDto(id, userId, post, createdAt, updatedAt, displayName);
				tweetList.add(tweet);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.close(rs);
			this.close(pStmt);
			this.close(conn);
		}
		return tweetList;
	}
}