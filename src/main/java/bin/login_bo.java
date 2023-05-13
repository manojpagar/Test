package bin;

public class login_bo {
	
	private String id;
	private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public login_bo(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public login_bo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "login_bin [id=" + id + ", password=" + password + "]";
	}
	

}
