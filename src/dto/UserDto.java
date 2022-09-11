package dto;

public class UserDto {
	private int id;
	private String mail;
	private String displayName;
	private String pass;
	private String profile;

	public UserDto(int id, String mail, String displayName, String pass, String profile) {
		this.id = id;
		this.mail = mail;
		this.displayName = displayName;
		this.pass = pass;
		this.profile = profile;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
}