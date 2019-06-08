import java.util.List;

public class Account {
	private String username;
	private String password;
	private List<ToDo> listaToDo;

	public Account() {

	}

	public Account(String username, String password, List<ToDo> listaToDo) {
		this.username = username;
		this.password = password;
		this.listaToDo = listaToDo;
	}

	public String getUsername() {
		return username;

	}

	public String getPassword() {
		return password;
	}

	public List<ToDo> getListaToDo() {
		return listaToDo;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setListaToDo(List<ToDo> listaToDo) {
		this.listaToDo = listaToDo;
	}

	@Override
	public String toString() {
		return String.format("Username=" + username + "\n" + "Password=" + password);
	}

}
