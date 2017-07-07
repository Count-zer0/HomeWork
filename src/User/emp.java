package User;

public class emp {
	private int id;
	private String username;
	private String password;
	public emp() {
		super();
	}
	public emp(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public emp(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
