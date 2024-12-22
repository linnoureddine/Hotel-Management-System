package hotel_management_system;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String ANSI_BLUE = "\u001B[34m";
        Scanner scan = new Scanner (System.in);
        System.out.println(ANSI_BLUE + "------------------------------------Admin------------------------------------\n" + "\u001B[0m");
        System.out.println(ANSI_BLUE + "Hello, welcome to the hotel management system!\n" + "\u001B[0m"); 
        Hotel h = new Hotel();
        String answer = "";
        do{
            System.out.println("Choose an operation: \n1- Enter hotel information \n2- Update hotel information " 
                + "\n3- Display hotel information \n4- Add floors \n5- Merge two rooms \n6-Update room \n7- Display rooms' bookings \n8- Display guests currently checked in \n");
            int choice = scan.nextInt();

            while(choice <=0 || choice > 8){
                System.out.println("Invalid choice, please choose a valid operation: ");
                System.out.println("1- Enter hotel information \n2- Update hotel information " 
                + "\n3- Display hotel information \n4- Add floors \n5- Merge two rooms \n6- Display rooms' bookings \n7- Display guests currently checked in \n");
                choice = scan.nextInt();
            }

            switch(choice){
                case 1:
                    h.readHotelInfo();
                    break;
                case 2:
                    h.updateHotelInformation();
                    break;
                case 3:
                    h.printHotelInformation();
                    break;
                case 4:
                    h.addFloors();
                    break;
                case 5:
                    h.mergeRooms();
                    break;
                case 6:
                    h.updateRoom();
                    break;
                case 7:
                    h.displayBookings();
                    break;
                case 8:
                    h.displayGuests();
                    break;
                default:
                    break;
            }
            
            scan.nextLine();
            System.out.print("Would you like to choose another operations (yes/no)?");
            answer = scan.nextLine();
        }while(answer.equalsIgnoreCase("yes"));

    }

}
