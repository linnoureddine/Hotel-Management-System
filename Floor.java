package hotel_management_system;

import java.util.Scanner;

public class Floor {
	private int floor_num;
	private LinkedList rooms;
	
	Scanner scan = new Scanner(System.in);
	
	public Floor () {
		floor_num = 0;
		rooms = new LinkedList();
	}

	public Floor (int num) {
		floor_num = num;
		rooms = new LinkedList();
	}

	public int getFloor_num() {
		return floor_num;
	}

	public void setFloor_num(int num) {
		this.floor_num = num;
	}

	public LinkedList getRooms() {
		return rooms;
	}

	public void setRooms(LinkedList rooms) {
		this.rooms = rooms;
	}

	public void addRooms(int f, int num) {
		setFloor_num(f);
		for (int i = 1 ; i <= num ; i++){
			System.out.println("\nEnter the information of room " + i + ": ");
			Room m = new Room();
			m.readRoomInformation();
			rooms.insertAtBack(m);
		}
		if(!rooms.isEmpty())
			System.out.println("\nRooms added successfully");
		else
			System.out.println("\nError adding rooms");
	}

	public void addRoom(Room r){
		rooms.insertAtBack(r);
	}

	public void updateRoom(){
		if(!rooms.isEmpty()){
			System.out.print("Enter the number of the room you would like to update: ");
			int num = scan.nextInt();
			while(rooms.findRoomById(num) == null){
				System.out.print("This room doesn't exist. Please enter a valid room number: ");
				num = scan.nextInt();
			}
			Node room = rooms.findRoomById(num);
			room.getData().updateRoomInformation();

			System.out.println("The room information after updating is: ");
			System.out.println(room.getData());
		}
	}

	public void addBooking() {
		if(!rooms.isEmpty()) {
			System.out.print("Enter the number of the room you would like to book: ");
			int num = scan.nextInt();
			Node room = rooms.findRoomById(num);
			while(room == null) {
				System.out.print("This room doens't exist. Please re-enter the room number: ");
				num = scan.nextInt();
				room = rooms.findRoomById(num);
			}
			room.getData().addBooking();
		}
	}
	
	public void checkin() {
		if(!rooms.isEmpty()) {
			System.out.print("\nEnter the number of the room that you booked: ");
			int num = scan.nextInt();
			Node room = rooms.findRoomById(num);
			while(room == null) {
				System.out.print("This room doens't exist. Please re-enter the room number: ");
				num = scan.nextInt();
				room = rooms.findRoomById(num);
			}
			room.getData().checkin();
		}
	}
	
	public void checkout() {
		if(!rooms.isEmpty()) {
			System.out.print("\nEnter the number of the room that you stayed in: ");
			int num = scan.nextInt();
			Node room = rooms.findRoomById(num);
			while(room == null) {
				System.out.print("This room doens't exist. Please re-enter the room number: ");
				num = scan.nextInt();
				room = rooms.findRoomById(num);
			}
			room.getData().checkout();
		}
	}
	
	public void cancelBooking() {
		if(!rooms.isEmpty()) {
			System.out.print("\nEnter the number of the room that you booked: ");
			int num = scan.nextInt();
			Node room = rooms.findRoomById(num);
			while(room == null) {
				System.out.print("This room doens't exist. Please re-enter the room number: ");
				num = scan.nextInt();
				room = rooms.findRoomById(num);
			}
			room.getData().cancelBooking();
		}
	}
	
	public String toString() {
		return "Floor " + floor_num + " information:";
	}
	
}
