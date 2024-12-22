package hotel_management_system;

import java.util.Scanner;

public class Main2 {
  public static void main(String[] args) {
      String ANSI_BLUE = "\u001B[34m";
      Scanner scan = new Scanner (System.in);
      String des ="LS Hotel is located on the shores of tyre. It has an excellent view of the beach, and includes a rooftop pool.";
      Hotel h = new Hotel("LS Hotel", "Tyre, 12th street", "+961 70 879 561", "LSHotel.com", des, 1, 4);
      String d1 = "Single room with a queen sized bed and a dresser equipped with a mini fridge and a tv";
      String d2 = "Double room with two queen sized beds and a dresser equipped with a mini fridge and a tv.";
      String d3 = "Triple room with three queen sized beds and a dresser equipped with a mini fridge and a tv along with a couch chair and coffee table.";
      String d4 = "Suite with two double rooms separated by a living room equipped with an L-shaped couch, a coffee table and a mini fridge.";
      Room r1 = new Room(2, d2, "Double", 70, "Beach");
      Room r2 = new Room(3, d3, "Triple", 90, "Beach");
      Room r3 = new Room(4, d4, "Suite", 150, "Street");
      Room r4 = new Room(1, d1, "Single", 30, "Street");
      Floor f1 = new Floor(1);
      f1.addRoom(r1);
      f1.addRoom(r2);
      f1.addRoom(r3);
      f1.addRoom(r4);
      Guest g1 = new Guest("Mariam Soboh", "70 123 456", "mariamsoboh@gmail.com", "extra pillows", "345E786", false);
      Guest g2 = new Guest("Lama Affara", "81 768 536", "l.affara@gmail.com", "extra pillows", "786J647", true);
      Guest g3 = new Guest("Layal Abu Daher", "70 897 536", "layalabudaher@gmail.com", "hair dryer", "728G683", false);
      Guest g4 = new Guest("Ali El Zaart", "81 639 780", "elzaart@gmail.com", "personal welcome card", "345E786", true);
      Guest g5 = new Guest("Roa Abou Khachfeh", "70 890 651", "roa.aboukhachfeh@gmail.com", "extra toiletries", "782B748", false);
      Guest g6 = new Guest("Mohamad Abdulrahim", "70 567 831", "m.abdulrahim@gmail.com", "", "896K628", true);
      Guest g7 = new Guest("Mohamad Yassine", "80 785 739", "m.yassine@gmail.com", "", "732K638", false);
      Guest g8 = new Guest("Mohammed Al Saleh", "76 536 781", "mohammedalsaleh@gmail.com", "extra towels", "789A3467", true);
      Booking b1 = new Booking(g1, 2, "2023-12-10", "2023-12-17");
      Booking b2 = new Booking(g2, 3, "2023-12-10", "2023-12-15");
      Booking b3 = new Booking(g3, 1, "2023-12-24","2024-01-03");
      Booking b4 = new Booking(g4, 4, "2023-12-10", "2023-12-18");
      Booking b5 = new Booking(g5, 3, "2023-12-16", "2023-12-23");
      Booking b6 = new Booking(g6, 2, "2023-12-29", "2024-01-05");
      Booking b7 = new Booking(g7, 1, "2023-12-18","2023-12-22");
      Booking b8 = new Booking(g8, 4, "2023-12-27", "2023-12-31");
      r4.addBooking(b3);
      r4.addBooking(b7);
      r2.addBooking(b2); 
      r2.addBooking(b5);
      r3.addBooking(b8);
      r3.addBooking(b4);
      r1.addBooking(b1); 
      r1.addBooking(b6);
      r2.checkin(b2);
      r1.checkin(b1);
      h.addFloor(f1);

      String answer = "";
      System.out.println(ANSI_BLUE + "\n------------------------------------User------------------------------------" + "\u001B[0m");
      System.out.println(ANSI_BLUE + "\nHello, Welcome to the " + h.getName() + " !\n" + "\u001B[0m"); 
      System.out.println(h);
      System.err.println();
      do {
        System.out.println("\nChoose the option you would like: \n"
            + "\n1-Book a room \n2-Check into your room \n3-Check out of your room \n4-Cancel your booking");
        int choice = scan.nextInt();
        switch(choice) {
          case 1:
            h.addBooking();
            break;
          case 2:
            h.checkin();
            break;
          case 3:
            h.checkout();
            break;
          case 4:
            h.cancelBooking();
            break;
          default:
            break;   
        }
        System.out.print("\nWould you like to do anything more? (yes/no) ");
        answer = scan.next();
      }while(answer.equals("yes"));

      System.out.println(ANSI_BLUE + "\n------------------------------------Admin------------------------------------\n" + "\u001B[0m");
        System.out.println(ANSI_BLUE + "Hello, Welcome back to your hotel management system !\n" + "\u001B[0m"); 
        answer = "";
        do{
            System.out.println("Choose an operation: \n1- Update hotel information " 
                + "\n2- Display hotel information \n3- Merge two rooms \n4- Display rooms' bookings \n5- Display guests currently checked in \n");
            int choice = scan.nextInt();
            switch(choice){
                case 1:
                    h.updateHotelInformation();
                    break;
                case 2:
                    h.printHotelInformation();
                    break;
                case 3:
                    h.mergeRooms();
                    break;
                case 4:
                    h.displayBookings();
                    break;
                case 5:
                    h.displayGuests();
                    break;
                default:
                    break;
            }

            scan.nextLine();
            System.out.print("Would you like to choose another operation (yes/no)?");
            answer = scan.nextLine();
        }while(answer.equalsIgnoreCase("yes"));

    }

}
