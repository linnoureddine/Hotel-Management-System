package hotel_management_system;

import java.util.Scanner;

public class Booking {
	private Guest guest;
	private int number_of_guests, ID;
	private String check_in_date, check_out_date;
	private double totalexpense;
	private static int count = 0 ;
	private boolean status;
	
	Scanner scan = new Scanner (System.in);

	public Booking(){
		guest = new Guest();
		ID = count;
		count++;
		number_of_guests = 0;
		check_in_date = check_out_date = "";
		totalexpense = 0 ;
		status = false;
	}

	public Booking(Guest g, int n, String in, String out){
		guest =g;
		ID = count;
		count++;
		number_of_guests = n;
		check_in_date = in;
		check_out_date = out;
		totalexpense = 0 ;
		status = false;
	}
	
	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public int getBooking_Id() {
		return ID;
	}

	public void setBooking_Id(int booking_Id) {
		ID = booking_Id;
	}

	public int getNumber_of_guests() {
		return number_of_guests;
	}

	public void setNumber_of_guests(int number_of_guests) {
		this.number_of_guests = number_of_guests;
	}

	public String getCheck_in_date() {
		return check_in_date;
	}

	public void setCheck_in_date(String check_in_date) {
		this.check_in_date = check_in_date;
	}

	public String getCheck_out_date() {
		return check_out_date;
	}

	public void setCheck_out_date(String check_out_date) {
		this.check_out_date = check_out_date;
	}

	public double getTotalexepense(){
		return totalexpense;
	}

	public void setTotalexpense(double total){
		totalexpense = total;
	}

	public boolean getStatus(){
		return status;
	}

	public void setStatus(boolean check){
		status = check;
	}

	public void readBookingInformation() {
		guest.readGuestInformation();
		guest.updateGuestInformation();
	}

	public void printBookingInformation() {
		System.out.println("This is the final booking information: ");
		guest.printGuestInformation();
		System.out.println("Booking ID: " + ID);
		System.out.println("Number of guest: " + number_of_guests);
		System.out.println("Check in date: " + check_in_date);
		System.out.println("Check out date: " + check_out_date);
		System.out.println("Total expense: " + totalexpense);
	}

	public String toString() {
		return "\nBooking " + ID + " information :"+
				guest.toString() + 
				"\nNumber of guests: " + number_of_guests +
				"\nCheck in date: " + check_in_date +
				"\nCheck out date: " + check_out_date +
				"\nTotal expense: " + totalexpense+
				"\nChecked in status: " + status;
	}
	
}
