package dto;


import java.time.LocalDateTime;

public class TweetDto {
	private int id;
	private int userId;
	private String post;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String displayName;

	public TweetDto(int id, int userId, String post, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.userId = userId;
		this.post = post;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public TweetDto(int id, int userId, String post, LocalDateTime createdAt, LocalDateTime updatedAt, String displayName) {
		this.id = id;
		this.userId = userId;
		this.post = post;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.displayName = displayName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDsiplayName(String displayName) {
		this.displayName = displayName;
	}
}