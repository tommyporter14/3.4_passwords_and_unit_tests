import java.util.ArrayList;
import java.util.Scanner;

public class password_code {
	
	static ArrayList<String> passwords = new ArrayList<String>();//password list, had to be static class (?) to be accessed throughout

	public static void main(String[] args) {//main method
		
				Scanner scnr = new Scanner(System.in);//scanner
			
				System.out.println("Password Requirements:\n"//prompt with requirement 
				+ "Password doesn't already exist\n"
				+ "Password is between 7 - 12 characters\n"
				+ "Password has at least one number (the number 6 is not allowed)\n"
				+ "Password has no spaces\n"
				+ "Password must contain two capital vowels\n"
				+ "Password may be 'admin' or 'mod' (in this case all other rules are suspended, however these passowrds can only occur once each)");
			
			do {
				System.out.println("\nPlease enter a password:");
				String input = scnr.nextLine();//gets user input password
			
				if(addPassword(input) == true)//calls method
				{
					System.out.println("Password Valid");//if true prints valid
					System.out.println("Here are the current passwords:\n" + passwords);
				}
				else
				{
					System.out.println("Password Invalid, try again:");//if false prints invalid
				}
		
				System.out.println("Would you like to enter another password? (y or n):");
				String input2 = scnr.nextLine();//gets user input decision
				if(input2.equalsIgnoreCase("y"))
				{
					continue;
				}
				else
				{
					System.out.println("Here are the current passwords:\n" + passwords + "\nGoodbye.");
					break;
				}
				
			}while(true);
			scnr.close();//scanner close
	}

	public static boolean addPassword (String pass)//method for adding pass to array
	{
		boolean trueFalse;//variables
		int passFailTotal;
		int passFailRef = 4;
		
		passFailTotal = checkLength(pass) + checkDigit(pass) + checkSpace(pass) + checkVowel(pass);
		if(passwordExists(pass, passwords) == false)//if already in list
		{
			trueFalse = false;
		}
		else
		{
			if(pass.equals("admin") || pass.equals("mod"))//see's if pass is 'admin' or 'mod'
			{
				trueFalse = true;
				passwords.add(pass);
			}
			else
			{
				if(passFailRef == passFailTotal)//checks all other conditions from other methods using reference total in integers
				{
					trueFalse = true;
					passwords.add(pass);
				}
				else
				{
					trueFalse = false;
				}
			}
		}
		
		return trueFalse;//method return
	
	}	
	
	public static int checkLength (String pass)//checks length
	{
		int passFail1;
		int length = pass.length();
		if (length >= 7 && length<=12)
		{
			passFail1 = 1;
		}
		else
		{
			passFail1 = 0;
		}
		return passFail1;
	}
	
	public static int checkDigit (String pass)//checks for digits, no 6
	{
		int passFail2;
		if(pass.matches("(.*[0-9].*)") && !pass.contains("6"))
		{
			passFail2 = 1;
		}
		else
		{
			passFail2=0;
		}
		return passFail2;
	}
	
	public static int checkSpace (String pass)//checks for spaces 
	{
		int passFail3;
		if(!pass.contains(" "))
		{
			passFail3 = 1;
		}
		else
		{
			passFail3 = 0;
		}
		return passFail3;
	}
	
	public static int checkVowel (String pass)//checks for 2 cap vowels
	{
		int passFail4;
		int countCap = 0;
		for (int i = 0; i < pass.length(); i++) 
		{
			if (pass.charAt(i) == 'A' || pass.charAt(i) == 'E' || pass.charAt(i) == 'I' || pass.charAt(i) == 'O' || pass.charAt(i) == 'U' || pass.charAt(i) == 'Y') 
			{
				countCap++;
			}
		}
		if(countCap>=2)
		{
			passFail4 = 1;
		}
		else
		{
			passFail4 = 0;
		}
		return passFail4;
	}
	
	public static boolean passwordExists(String pass, ArrayList<String> passlist) //method for checking if password is in array
	{

		if (passlist.contains(pass)) 
		{
			return false;
		} 
		else 
		{
			return true;
		}
	}
}	
