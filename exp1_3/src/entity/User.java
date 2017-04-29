package entity;

public class User {
	private Integer id;
	private String username;
	private String passwd;
	
	public User(){
		
	}
	public User(Integer id, String username, String passwd) {
		super();
		this.id = id;
		this.username = username;
		this.passwd = passwd;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwd=" + passwd + "]";
	}
}
