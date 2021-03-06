import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class password_tests {

	@Test
	void passwordExistsTest1() {//test for if already in array FALSE
		String pass = "hEllO8lll";
		ArrayList<String> passwords = new ArrayList <> ();
		passwords.add("hEllO8lll");
		passwords.add("EyEhi7ii");
		boolean expected = false;
		boolean actual = password_code.passwordExists(pass, passwords);
		assertEquals(expected, actual);
	}

	@Test
	void passwordExistsTest2() {//test for if not in array TRUE
		String pass = "EyE7hiwww";
		ArrayList<String> passwords = new ArrayList <> ();
		passwords.add("hEllO8lll");
		passwords.add("EyEhi7ii");
		boolean expected = true;
		boolean actual = password_code.passwordExists(pass, passwords);
		assertEquals(expected, actual);
	}
	
	@Test
	void passwordExists3() {//test that admin/mod doesn't work if already in array
		String pass = "admin";
		ArrayList<String> passwords = new ArrayList <> ();
		passwords.add("admin");
		passwords.add("EyEhi7ii");
		boolean expected = false;
		boolean actual = password_code.passwordExists(pass, passwords);
		assertEquals(expected, actual);
	}
	
	@Test
	void addPassword1() {//test for character length within 7 to 12 TRUE
		String pass = "T7zdA3xpI";
		boolean expected = true;
		boolean actual = password_code.addPassword(pass);
		assertEquals(expected, actual);
	}
	
	@Test
	void addPassword2() {//test for character length too long FALSE
		String pass = "T7zdA3xpILLLLL";
		boolean expected = false;
		boolean actual = password_code.addPassword(pass);
		assertEquals(expected, actual);
	}
	
	@Test
	void addPassword3() {//test for character length too short FALSE
		String pass = "gOOd7";
		boolean expected = false;
		boolean actual = password_code.addPassword(pass);
		assertEquals(expected, actual);
	}
	
	@Test
	void addPassword4() {//test has number TRUE
		String pass = "7hhhhhhUUU";
		boolean expected = true;
		boolean actual = password_code.addPassword(pass);
		assertEquals(expected, actual);
	}
	
	@Test
	void addPassword5() {//test has no number FALSE
		String pass = "hhhhhhUUU";
		boolean expected = false;
		boolean actual = password_code.addPassword(pass);
		assertEquals(expected, actual);
	}
	
	@Test
	void addPassword6() {//test has number 6 FALSE
		String pass = "6hhhhhhUUU";
		boolean expected = false;
		boolean actual = password_code.addPassword(pass);
		assertEquals(expected, actual);
	}
	
	@Test
	void addPassword7() {//test has spaces FALSE
		String pass = "hEE l7sss";
		boolean expected = false;
		boolean actual = password_code.addPassword(pass);
		assertEquals(expected, actual);
	}
	
	@Test
	void addPassword8() {//2nd test has spaces FALSE
		String pass = "hE I 6fg !";
		boolean expected = false;
		boolean actual = password_code.addPassword(pass);
		assertEquals(expected, actual);
	}
	
	@Test
	void addPassword9() {//test doesn't have 2 cap vowels FALSE
		String pass = "hello7lll";
		boolean expected = false;
		boolean actual = password_code.addPassword(pass);
		assertEquals(expected, actual);
	}
	
	@Test
	void addPassword10() {//test only one cap vowels FALSE
		String pass = "hEllo7lll";
		boolean expected = false;
		boolean actual = password_code.addPassword(pass);
		assertEquals(expected, actual);
	}
	
	@Test
	void addPassword11() {//test has 2 cap vowels TRUE
		String pass = "hEllO7lll";
		boolean expected = true;
		boolean actual = password_code.addPassword(pass);
		assertEquals(expected, actual);
	}
	
	@Test
	void addPassword12() {//test that mod works TRUE
		String pass = "mod";
		boolean expected = true;
		boolean actual = password_code.addPassword(pass);
		assertEquals(expected, actual);
	}
	
	@Test
	void addPassword13() {//test that admin works TRUE
		String pass = "admin";
		boolean expected = true;
		boolean actual = password_code.addPassword(pass);
		assertEquals(expected, actual);
	}	
}
