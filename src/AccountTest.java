import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {

	String username;
	String password;
	Account account1;
	List<ToDo>listaToDo1;

	@Before
	public void setup() {

		username = "homer";
		password = "12345";
		listaToDo1 = new ArrayList<>();
		account1 = new Account(username, password,listaToDo1);

	}

	
	@Test
	public void getUesrnameTest_ShouldReturnUsername_IfGivenUsername() {

		String result = account1.getUsername();

		String expected = "homer";

		assertEquals(expected, result);

	}

	@Test
	public void getPasswordTest_ShouldReturnPassword_IfGivenPassword() {

		String result = account1.getPassword();

		String expected = "12345";

		assertEquals(expected, result);
	}

	@Test
	public void getListaToDoTest_ShouldReturnListaToDo_IfGivenListaTodo() {
		
	
		
		assertArrayEquals(listaToDo1.toArray(),account1.getListaToDo().toArray());
		
	}
	
	@Test
	public void toStringTest_ShouldReturnString_IfGivenString() {
		
		String result = account1.toString();
		
		String expected = String.format("Username=" + "homer" + 
				"\nPassword=" + "12345" 
						 );
		
		assertEquals(expected, result);
	}
	
	

}
