package hotel_management_system;

import java.util.Scanner;

public class Hotel {
	private String name, address, contact_info, website, description;
	private int floors;
	private int number_per_floor;
	private Floors hotel;
	
	Scanner scan = new Scanner(System.in);
	
	public static final String ANSI_MAGENTA = "\u001B[35m";
	
	public Hotel() {
		name = "";
		address = "";
		contact_info = "";
		website = "";
		description = "";
		floors = 0;
		number_per_floor = 0;
	}

	public Hotel(String n, String a, String c, String w, String des, int f, int num) {
		name = n;
		address = a;
		contact_info = c;
		website = w;
		description = des;
		floors = f;
		number_per_floor = num;
		hotel = new Floors(f);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact_info() {
		return contact_info;
	}

	public void setContact_info(String contact_info) {
		this.contact_info = contact_info;
	}

	public String getWebsite(){
		return website;
	}

	public void setWebsite(String web){
		website = web;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String d){
		description = d;
	}

	public int getFloors() {
		return floors;
	}

	public void setFloors(int floors) {
		this.floors = floors;
	}
	
	public int getNumber_per_floor() {
		return number_per_floor;
	}

	public void setNumber_per_floor(int number_per_floor) {
		this.number_per_floor = number_per_floor;
	}

	public void readHotelInfo() {
		System.out.print("Enter the name of your hotel: ");
		String name = scan.nextLine();
		setName(name);
		
		System.out.print("Enter the address of your hotel: ");
		String address = scan.nextLine();
		setAddress(address);
		
		System.out.print("Enter the contact information of your hotel: ");
		String contact = scan.nextLine();
		setContact_info(contact);

		System.out.print("Enter the website of your hotel: ");
		String website = scan.nextLine();
		setWebsite(website);
		
		System.out.print("Enter the description of your hotel: ");
		String des = scan.nextLine();
		setDescription(des);

		System.out.print("Enter the number of floors you wish to have in your hotel: ");
		int num = scan.nextInt();
		setFloors(num);
		
		System.out.print("Enter the number of rooms you wish to have on each floor in your hotel: ");
		num = scan.nextInt();
		setNumber_per_floor(num);

		hotel = new Floors(num);
		
		System.out.println("\n---------------------------------------------------------------\n");
	}

	public void updateHotelInformation(){
		System.out.println("Choose the attribute you would like to update: \n1-Name \n2-Contact information \n3-Website \n4-Descritption");
		int choice = scan.nextInt();
		while (choice <= 0 || choice > 4){
			System.out.println("Invalid option. Choose the attribute you would like to update: \n1-Name \n2-Contact information \n3-Website \n4-Descritption");
			choice = scan.nextInt();
		}
		String answer = "";
		do{
			if(choice == 1){
			scan.nextLine();
			System.out.print("Enter the new name of your hotel: ");
			String name = scan.nextLine();
			setName(name);
			}
			else if(choice == 2){
				System.out.print("Enter the new contact information of your hotel: ");
				String contact = scan.nextLine();
				setContact_info(contact);
			}
			else if(choice == 3){
				System.out.print("Enter the new website of your hotel: ");
				String website = scan.nextLine();
				setWebsite(website);
			}
			else if(choice == 4){
				System.out.print("Enter the description of your hotel: ");
				String description = scan.nextLine();
				setDescription(description);
			}
			System.out.println("Would you like to update anything more (yes/no)? ");
			answer = scan.nextLine();
		}while(answer.equals("yes"));
		
		System.out.println("\n---------------------------------------------------------------\n");
	}
	
	public void printHotelInformation() {
		System.out.println(ANSI_MAGENTA + "" + name + "'s Information: \n" + "\u001B[0m");
		System.out.println("Address: " + address);
		System.out.println("Contact information: " + contact_info);
		System.out.println("Website name: " + website);
		System.out.println("Description: " + description);
		System.out.println("Number of floors: " + floors);
		hotel.displayRooms();
		System.out.println("\n---------------------------------------------------------------\n");
	}

	public void displayBookings(){
		if(hotel.isEmpty())
			System.out.println("The hotel is empty");
		else{
			System.out.println("The current bookings in the hotel are: ");
			hotel.displayBookings();

			System.out.println("\n---------------------------------------------------------------\n");
		}
	}

	public void displayGuests(){
		if(hotel.isEmpty())
			System.out.println("The hotel is empty");
		else{
			System.out.println("The current guests staying in the hotel are: ");
			hotel.displayGuests();

			System.out.println("\n---------------------------------------------------------------\n");
		}
	}
	
	public void addFloors() {
		if(hotel.isEmpty()){
			System.out.println("Here are the list of rooms available: \n1-Single Room \n2-Double Room \n3-Triple Room \n4-Suite (two double rooms)");
			System.out.println("Enter the rooms on each floor of you hotel: ");
			for(int i = 1 ; i <= floors ; i++) {
				System.out.println("\nFloor " + i + ": ");
				Floor rooms = new Floor(i);
				rooms.addRooms(i, number_per_floor);
				hotel.insertFloor(rooms);
			}

			if(hotel.isEmpty())
				System.out.println("Unsuccessful addition of floors");
			else
				System.out.println("Floors added successfully");
		}
		else 
			System.out.println("Can't add any more floors, the hotel structure is complete");
		
		System.out.println("\n---------------------------------------------------------------\n");
	}

	public void addFloor(Floor f){
		hotel.insertFloor(f);
	}

	public void mergeRooms(){
		if(hotel.isEmpty())
			System.out.println("The hotel is empty");
		else{
			System.out.print("Enter the number of the floor you would like to merge two rooms on: ");
			int floor = scan.nextInt();
			while(floor > floors){
				System.out.print("Invalid floor number. Re-enter the number of the floor you would like to merge two rooms on: ");
				floor = scan.nextInt();
			}
			hotel.displayFloor(floor);
			System.out.print("Enter the number of the first room: ");
			int n1 = scan.nextInt();
			System.out.print("Enter the number of the second room: ");
			int n2 = scan.nextInt();
			while(n1 == n2){
				System.out.print("Can't merge the same room. Re-enter the room numbers: \nEnter the number of the first room: ");
				n1 = scan.nextInt();
				System.out.print("Enter the number of the second room: ");
				n2 = scan.nextInt();
			}

			Floor f = hotel.searchFloor(floor);
			f.getRooms().mergeRooms(n1, n2);

		}

		System.out.println("\n---------------------------------------------------------------\n");
	}

	public void updateRoom(){
		if(!hotel.isEmpty()){
			System.out.print("Enter the number of the floor the room you would like to update is located on: ");
			int floor = scan.nextInt();
			while(floor > floors){
				System.out.print("Invalid floor number. Re-enter a valid floor number: ");
				floor = scan.nextInt();
			}
			hotel.displayFloor(floor);
			Floor f = hotel.searchFloor(floor);
			f.updateRoom();
			
			System.out.println("\n---------------------------------------------------------------\n");
		}
		else
			System.out.println("The hotel is empty");
	}

	public void addBooking() {
		if(!hotel.isEmpty()){
			System.out.print("Choose one of " + floors + " floor(s) you would like to book on: ");
			int floor = scan.nextInt();
			while(floor > floors){
					System.out.print("Invalid floor number. Re-enter the number of the floor you would like booked a room on: ");
					floor = scan.nextInt();
				}
			Floor f = hotel.searchFloor(floor);
			f.getRooms().displayRooms();
			f.addBooking();
		}
		else
			System.out.println("Im sorry, there seems to be an error in the system. Please try again later!");
		System.out.println("\n---------------------------------------------------------------\n");
	}

	public void checkin() {
		if(!hotel.isEmpty()){
			System.out.print("On what floor is the room that you booked located on? ");
			int floor = scan.nextInt();
			while(floor > floors){
					System.out.print("Invalid floor number. Re-enter the number of the floor of the room you booked on: ");
					floor = scan.nextInt();
				}
			Floor f = hotel.searchFloor(floor);
			f.checkin();
		}
		else
			System.out.println("Im sorry, there seems to be an error in the system. Please try again later!");
		System.out.println("\n---------------------------------------------------------------\n");
	}
	
	public void checkout() {
		if(!hotel.isEmpty()){
			System.out.print("On what floor is the room that you stayed in located on? ");
			int floor = scan.nextInt();
			while(floor > floors){
					System.out.print("Invalid floor number. Re-enter the number of the floor of the room you stayed in: ");
					floor = scan.nextInt();
				}
			Floor f = hotel.searchFloor(floor);
			f.checkout();
		}
		else
			System.out.println("Im sorry, there seems to be an error in the system. Please try again later!");
		System.out.println("\n---------------------------------------------------------------\n");
	}
	
	public void cancelBooking() {
		if(!hotel.isEmpty()){
			System.out.print("On what floor is the room that you stayed in located on? ");
			int floor = scan.nextInt();
			while(floor > floors){
					System.out.print("Invalid floor number. Re-enter the number of the floor of the room you booked on: ");
					floor = scan.nextInt();
				}
			Floor f = hotel.searchFloor(floor);
			f.cancelBooking();
		}
		else
			System.out.println("Im sorry, there seems to be an error in the system. Please try again later!");
		System.out.println("\n---------------------------------------------------------------\n");
	}

	public String toString(){
		return name + " hotel's information: "+
					"\nHotel's address: " + address +
					"\nHotel's contact information: " + contact_info +
					"\nHotel's website: " + website+
					"\nHotel's description: " + description +
					"\nNumber of floors: " + floors;
	}
	
}
