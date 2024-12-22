package hotel_management_system;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Guest {
	private String full_name;
	private String phone_number;
	private String email;
	private String special_requests;
	private String credit_card_number;
	private boolean loyalty_program;

	Scanner scan = new Scanner(System.in);

	public Guest() {
		full_name = "";
		phone_number = "";
		email = "";
		special_requests = "";
		credit_card_number = "";
		loyalty_program = false;
	}

	public Guest(String n, String p, String e, String s, String c, boolean l) {
		full_name = n;
		phone_number = p;
		email = e;
		special_requests = s;
		credit_card_number = c;
		loyalty_program = l;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSpecial_requests() {
		return special_requests;
	}

	public void setSpecial_requests(String special_requests) {
		this.special_requests = special_requests;
	}

	public String getCredit_card_number() {
		return credit_card_number;
	}

	public void setCredit_card_number(String credit_card_number) {
		this.credit_card_number = credit_card_number;
	}
	
	public boolean isLoyalty_program() {
		return loyalty_program;
	}

	public void setLoyalty_program(boolean loyalty_program) {
		this.loyalty_program = loyalty_program;
	}

	public boolean validateEmail(String email) { //returns true if the email is valid and false otherwise 
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public void readGuestInformation(){ //reads the information of the current guest and sets the attributes accordingly 
		System.out.print("\nEnter your name: ");
		String a = scan.nextLine();
		setFull_name(a);

		System.out.print("Enter your phone number: ");
		String b = scan.nextLine();
		setPhone_number(b);

		System.out.print("Enter your email: ");
		String c = scan.nextLine();
		while(validateEmail(c) == false){ //ensures that the email provided by the user is valid 
			System.out.print("This email is invalid. Re-enter your email: ");
			c = scan.nextLine();
		}
		setEmail(c);

		System.out.print("Enter your special requests if you have any: ");
		String d = scan.nextLine();
		setSpecial_requests(d);

		System.out.print("Enter your credit card number: ");
		String e = scan.nextLine();
		setCredit_card_number(e);
		
		System.out.print("Are you a part of our loyalty program? ");
		String answer = scan.next();
		if(answer.equals("yes"))
			setLoyalty_program(true);

	}

	public void updateGuestInformation() {
		System.out.print("Would you like to update your infomation? (yes/no)");
		String answer = scan.next();
		while(answer.equals("yes")){
			System.out.println("Enter the number corresponding to the attribute you would like to upadate: "+
			"\n1- Full Name \n2-Phone Number \n3-Email \n4-Credit Card Number \n5-Special requests \n6-Loyality Progrem Status");
			int num = scan.nextInt();
			scan.nextLine();
			switch(num){
				case 1:
					System.out.print("\nEnter your name: ");
					String a = scan.nextLine();
					setFull_name(a);
					break;
				case 2:
					System.out.print("Enter your phone number: ");
					String b = scan.nextLine();
					setPhone_number(b);
					break;
				case 3:
					System.out.print("Enter your email: ");
					String c = scan.nextLine();
					setEmail(c);
					break;
				case 4:
					System.out.print("Enter your credit card number: ");
					String e = scan.nextLine();
					setCredit_card_number(e);
					break;
				case 5:
					System.out.print("Enter your special requests if you have any: ");
					String d = scan.nextLine();
					setSpecial_requests(d);
					break;
				case 6:
					System.out.print("Are you a part of our loyalty program? ");
					String program = scan.next();
					if(program.equals("yes"))
						setLoyalty_program(true);
					break;
				default:
					System.out.println("Invalid choice");
					break;
			}
			System.out.print("Would you like to update your other infomation? (yes/no)");
			answer = scan.next();
		}
	}

	public void printGuestInformation() {
		System.out.println("Full name: " + getFull_name());
		System.out.println("Phone number: " + getPhone_number());
		if (getSpecial_requests() == "") {
			System.out.println("No special requests specified.");
		} else {
			System.out.println("Special requests are: " + getSpecial_requests());
		}
		System.out.println("Email: " + getEmail());
		System.out.println("Credit card number: " + getCredit_card_number());
	}
	
	public String toString() {
		return "\nFull name: " + getFull_name()+
				"\nPhone number: " + getPhone_number()+
				"\nSpecial requests are: " + getSpecial_requests()+
				"\nEmail: " + getEmail()+
				"\nCredit card number: " + getCredit_card_number();
	}

}
