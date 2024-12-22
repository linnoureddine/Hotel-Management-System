package hotel_management_system;

public class Floors {
  private int num;
  private int current;
  private Floor[] floors;

  public Floors(){
    num = 0 ; 
  }

  public Floors(int num){
    this.num = num;
    floors = new Floor[num];
  }

  public int getNum(){
    return num;
  }

  public void setNum(int num){
    this.num = num;
  }

  public boolean isEmpty(){
    return current == 0;
  }

  public void insertFloor(Floor floor){
    if(isEmpty()){
      floors[0] = floor;
      current++;
    }
    else if(current < num){
      floors[current] = floor;
      current++;
    }
    else
      System.out.println("Can't add any more floors.");
  }

  public Floor searchFloor(int num){
    if(isEmpty())
      return null;
    else if(num > this.num){
      System.out.println("This floor doesn't exist");
      return null;
    }
    else
      return searchFloor(num, 0, num);
  }

  public Floor searchFloor(int num, int s, int e) {
    if (s > e) 
      return null;  
  
    int mid = (s + e) / 2;

    if (num == floors[mid].getFloor_num())
      return floors[mid];
    else if (num < floors[mid].getFloor_num())
      return searchFloor(num, s, mid - 1);
    else 
      return searchFloor(num, mid + 1, e);
  }

  public void display(){
    if(isEmpty())
      System.out.println("The hotel is empty.");
    else{
      for(int i = 0 ; i < current ; i++){
        System.out.println("\n" + floors[i]);
        floors[i].getRooms().display();
        System.out.println("\n------------------------------------------");
      }
    }
  }

  public void displayRooms(){
    if(isEmpty())
      System.out.println("The hotel is empty.");
    else{
      for(int i = 0 ; i < current ; i++){
        System.out.println("\n" + floors[i]);
        floors[i].getRooms().displayRooms();
        System.out.println("\n------------------------------------------");
      }
    }
  }

  public void displayBookings(){
    if(isEmpty())
      System.out.println("The hotel is empty.");
    else{
      for(int i = 0 ; i < current ; i++){
        System.out.println("\n" + floors[i]);
        floors[i].getRooms().displayBookings();
        System.out.println("\n------------------------------------------");
      }
    }
  }

  public void displayGuests(){
    if(isEmpty())
      System.out.println("The hotel is empty.");
    else{
      for(int i = 0 ; i < current ; i++){
        System.out.println("\n" + floors[i]);
        floors[i].getRooms().displayGuests();
        System.out.println("\n------------------------------------------");
      }
    }
  }
  
  public void displayFloor(int num){
    if(isEmpty())
      System.out.println("The hotel is empty");
    else if(searchFloor(num)==null) 
      System.out.println("Floor " + num + " doesnt exist");
    else{
      System.out.println(floors[num-1]);
      floors[num-1].getRooms().displayRooms();
    }
  }

}
