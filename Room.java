package hotel_management_system;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Room {
	private int capacity, ID;
	private static int count = 1;
	private String description, type, view;
	private boolean availability, renovation;
	private double price;
	private PriorityQueue bookings;

	Scanner scan = new Scanner(System.in);

	public Room() {
		capacity = 0 ;
		ID = count;
		count++;
		description = "";
		availability = true;
		renovation = false;
		type = "";
		price = 0 ;
		bookings = new PriorityQueue();
	}

	public Room(int c, String d, String t, double p, String v){	
		capacity = c ;
		ID = count;
		count++;
		description = d;
		view = v;
		availability = true;
		renovation = false;
		type = t;
		price = p ;
		bookings = new PriorityQueue();
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getID() {
		return ID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public boolean getAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public boolean getBeingRenovated() {
		return renovation;
	}

	public void setBeingRenovated(boolean ren) {
		renovation = ren;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public PriorityQueue getBookings() {
		return bookings;
	}

	public void setBookings(PriorityQueue bookings) {
		this.bookings = bookings;
	}

	public void readRoomInformation() {
		System.out.print("Enter the room type: ");
		String type = scan.nextLine();
		while(!type.equals("Single") && !type.equals("Double") && !type.equals("Triple") && !type.equals("Suite")){
			System.out.print("Invalid type. Re-enter the room type: ");
			type = scan.nextLine();
		}
		setType(type);

		if(type.equalsIgnoreCase("single")){
			setCapacity(1);
			setPrice(30);
			setDescription("Single room with a queen sized bed and a dresser equipped  with a mini fridge and a tv.");
		}
		else if(type.equalsIgnoreCase("double")){
			setCapacity(2);
			setPrice(50);
			setDescription("Double room with two queen sized beds and a dresser equipped  with a mini fridge and a tv.");
		}
		else if(type.equalsIgnoreCase("triple")){
			setCapacity(3);
			setPrice(70);
			setDescription("Triple room with three queen sized beds and a dresser equipped  with a mini fridge and a tv along with a couch chair and coffee table.");
		}
		else{
			setCapacity(4);
			setPrice(150);
			setDescription("Suite with two double rooms separated by a living room equipped  with an L-shaped couch, a coffee table and a mini fridge.");
		}

		System.out.print("Enter the room view (beach/street): ");
		String view = scan.nextLine();

		while(!view.equalsIgnoreCase("beach") && !view.equalsIgnoreCase("street")){
			System.out.print("Invalid option. Re-enter the room view (beach/street): ");
			view = scan.nextLine();
		}

		setView(view);

		if(view.equalsIgnoreCase("beach")){
			double p = getPrice();
			setPrice(p+20);
		}

	}

	public void updateRoomInformation(){
		System.out.println("What would you like to update? \n1-Room description \n2-Room status\n");
		int choice = scan.nextInt();
		while(choice <= 0 || choice > 2){
			System.out.println("Invalid option. Please choose an avialable option:\n1-Room description \n2-Room status\n");
			choice = scan.nextInt();
		}
		if(choice == 1){
			System.out.print("Enter the new room description: ");
			String des = scan.nextLine();
			setDescription(des);
		}
		else if(choice == 2){
			System.out.print("Enter the new room status (true if being renovated or false if not being renovated): ");
			boolean status  = scan.nextBoolean();
			setBeingRenovated(status);
		}
	}

	public void printRoomInformation(){
		System.out.println("Room " + ID + "'s information: ");
		System.out.println("Type: " + type);
		System.out.println("View: " + view);
		System.out.println("Price: " + price);
		System.out.println("Capacity: " + capacity);
		System.out.println("Description: " + description);
	}

	public void addBooking() {
		if(getBeingRenovated())
			System.out.println("You can't book this room since it is being renovated.");
		else{
			Booking booking = new Booking();
			booking.readBookingInformation();
			System.out.print("Enter the number of guests staying in this room: ");
			int num = scan.nextInt();
			while(num>capacity || num<=0) { 
				System.out.println("Invalid Number of guests");
				System.out.print("Re-enter the number of guests staying in this room: ");
				num = scan.nextInt();
			}
			booking.setNumber_of_guests(num);
			scan.nextLine();
			System.out.print("Enter the check in date: (yyyy-mm-dd)");
			String in = scan.nextLine();

			LocalDate dateObj = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String t = dateObj.format(formatter);
			String td = t.replaceAll("-", "");
			int today = Integer.parseInt(td);

			String numeric = in.replaceAll("-", "");
			int date = Integer.parseInt(numeric);

			while(date < today){
				System.out.print("Your check in date has to be now, not in the past. Re-enter the check in date: ");
				in = scan.nextLine();

				numeric = in.replaceAll("-", "");
				date = Integer.parseInt(numeric);
			}

			System.out.print("Enter the check out date: (yyyy-mm-dd)");
			String out = scan.nextLine();

			while(validateDate(in, out) == false) { 
				System.out.println("Please re-enter the check in and check out dates: (yyyy-mm-dd)");
				in = scan.next();
				out = scan.next();

				numeric = in.replaceAll("-", "");
				date = Integer.parseInt(numeric);

				while(date < today){
					System.out.print("Your check in date has to be now, not in the past. Re-enter the check in date: ");
					in = scan.nextLine();

					numeric = in.replaceAll("-", "");
					date = Integer.parseInt(numeric);
				}
			}

			booking.setCheck_in_date(in);
			booking.setCheck_out_date(out);
			
			bookings.enqueue(booking, date);

			booking.setTotalexpense(calculateTotal(in));
			System.out.println("Your final booking information is: \n");
			booking.printBookingInformation();
			
			System.out.println("\nYour room was booked successfully. Hope you have a nice day!");
		}
	}

	public boolean today(String in){
			LocalDate dateObj = LocalDate.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      String date = dateObj.format(formatter);
      
			return in.equals(date);
	}

	public void addBooking(Booking b){
		String numeric = b.getCheck_in_date().replaceAll("-", "");
		int date = Integer.parseInt(numeric);
		bookings.enqueue2(b, date);
		b.setTotalexpense(calculateTotal(b.getCheck_in_date()));
	}

	public boolean validateDate(String check_in, String check_out) { 
		String in = check_in.replaceAll("-", "");
		int indate = Integer.parseInt(in);
		if(datedifference(check_in, check_out) <= 0){
			System.out.println("The check out date has to come after the check in date");
			return false;
		}
		
		boolean flag = true;
		PriorityQueue temp = new PriorityQueue();
		Nodep current;
		while(!bookings.isEmpty()) {
			current = bookings.dequeue();
			temp.enqueue(current.getData(), current.getPriority());
			if(current.getData().getCheck_in_date().equals(check_in)){
				System.out.println("An existing booking has this check in date.");
				flag = false;
			}
			else if(!current.getData().getCheck_in_date().equals(check_in)) { 
				String current_in = current.getData().getCheck_in_date().replaceAll("-", "");
				int date_in = Integer.parseInt(current_in);
				String current_out = current.getData().getCheck_out_date().replaceAll("-", "");
				int date_out = Integer.parseInt(current_out);
				if(indate > date_in && indate <= date_out){
					System.out.println("Your check in date overlapped with an existing booking's check in date.");
						flag = false;
				}
			}	
		}
		
		while(!temp.isEmpty()) {
			Nodep x = temp.dequeue();
			bookings.enqueue(x.getData(), x.getPriority());
		}
		
		return flag;
	}

	public void cancelBooking(){ 
		if(!bookings.isEmpty()){
			System.out.print("\nPLease enter your full name: ");
			String name = scan.nextLine();
			Nodep b = bookings.searchByName(name);
			if(b != null){
				if(b.getData().getStatus())
					System.out.println("You can't cancel your booking after checking in");
				else if(bookings.deleteByName(name)) 
					System.out.println("Your booking was successfully canceled.");
			}
			else
				System.out.println("No booking under this name was found.");
		}
		else	
			System.out.println("This room has no bookings");
	}

	public void checkin() { 
		if(!bookings.isEmpty()){
			System.out.print("\nEnter your full name: ");
			String name = scan.nextLine();
			if(bookings.searchByName(name) == null) {
				System.out.println("\nI'm sorry. It seems that there is no booking under this full name. ");
			}
			else {
				Nodep b = bookings.searchByName(name);
				if(b != null){
					if(today(b.getData().getCheck_in_date())){
						setAvailability(false);
						b.getData().setStatus(true);
						System.out.println("You have been checked in. ");
						System.out.println("Thank you for choosing our hotel. I hope you have a pleasant stay! ");
					}
					else	
					System.out.println("You can't check in before your check in date");
				}
				else	
					System.out.println("There is no booking under this name");
			}
		}
		else
			System.out.println("This room has no bookings.");
	}

	public void checkin(Booking b){
		b.setStatus(true);
		setAvailability(false);
	}

	public double calculateTotal(String in) { 
		if(!bookings.isEmpty()) {
			PriorityQueue temp = new PriorityQueue();
			Nodep current;
			String out = "";
			boolean flag = false;
			while(!bookings.isEmpty()) { 
				current = bookings.dequeue();
				if(current.getData().getCheck_in_date().equals(in)) {
					out = current.getData().getCheck_out_date();
					if(current.getData().getGuest().isLoyalty_program() == true)
						flag = true;
				}
					temp.enqueue(current.getData(), current.getPriority());
			}
			
			while(!temp.isEmpty()) {
				Nodep x = temp.dequeue();
				bookings.enqueue(x.getData(), x.getPriority());
			}

			int diff = datedifference(in, out);

			if(diff !=0 ) {
				if(flag)
					return diff * price - (diff * price * 0.25);
				else
					return diff * price;
			}
			else
				return 0;
		}
		
		return 0;
	}

	public int datedifference(String in, String out){
		if(!in.equals(null) && !out.equals(null)){
			try{
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
				Date i = f.parse(in);
				Date o = f.parse(out);

				long diffinmilli = o.getTime() - i.getTime();
				int diffindays = (int) TimeUnit.DAYS.convert(diffinmilli, TimeUnit.MILLISECONDS);

				return diffindays;
			}
			catch (ParseException e){
				e.printStackTrace();
				return -1;
			}
		}
		else{
			return 0;
		}
	}
	
	public void checkout() {
		if(!bookings.isEmpty()){
			System.out.print("\nEnter your full name: ");
			String name = scan.nextLine();
			Nodep b = bookings.searchByName(name);
			
			if(b != null){
				if(b.getData().getStatus()) 
				System.out.println("You have successfully checked out. Thank you for choosing our hotel and i hope you enjoyed your stay!");
				else
					System.out.println("You aren't checked in to be able to check out");
				}
			else
				System.out.println("There in no booking with such name");
			}
		else	
			System.out.println("This room has no bookings");
	}

	public String toString(){
		return "\nRoom " + ID + " information: "+
						"\nType: " + type+
						"\nView: " + view + " view" +
						"\nCapacity: " + capacity +
						" person(s)\nPrice: " + price+
						"$\nDescription: " + description+
						"\nBeing renovated: " + renovation+
						"\nAvailability: " + availability;			
	}

}