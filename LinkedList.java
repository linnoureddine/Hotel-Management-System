package hotel_management_system;

public class LinkedList{
	private Node first;

    public LinkedList() {
        first = null;
    }
    
    public Node getFirst() {
		return first;
    }

    public boolean isEmpty() { // checks to see if the linked list is empty
    	return first == null;
    }

		public void insertAtFront(Room r){
			Node n = new Node(r);
			if(isEmpty())
				first = n;
			else{

			}
		}

    public void insertAtBack(Room r) { // inserts object at the end of a linked list 
    	if(isEmpty())
    		insertAtFront(r);
    	else {
    		Node n = new Node(r);
    		Node current = first;
    		while(current.getNext()!= null)
    			current = current.getNext();
    		current.setNext(n);
    	}
    }
    
    public Node findRoomById(int id) {
		if(!isEmpty()) {
			Node current = getFirst();
			boolean flag = false;
			while(current != null) {
				if(current.getData().getID() == id) {
					flag = true;
					break;
				}
				current = current.getNext();
			}
			
			if(flag == true)
				return current;
			else
				return null;
		}
		return null;
	}

	public void deleteFromFront(){
		if(isEmpty())
			return;
		else{
			first = first.getNext();
		}
	}

	public void deleteFromBack(){
		if(isEmpty())
			return ;
			else{
				Node current = getFirst();
				if(current.getNext() == null)
					first = null;
				while(current.getNext().getNext() != null)
					current = current.getNext();
				current.setNext(null);
			}
	}

	public void deleteRoomById(int id){
		if(isEmpty()){
			System.out.println("This floor is empty");
		}
		if(findRoomById(id) != null){
			if(first.getData().getID() == id)
				deleteFromFront();
			Node current = getFirst(), previous = getFirst();
			while(current.getNext() != null && current.getData().getID() != id){
				previous = current ;
				current = current.getNext();
			}
			
			if(current != null && current.getData().getID() == id){
				if(current.getNext() != null)
					previous.setNext(current.getNext());
				else
					deleteFromBack();
			}
		}
		else
			System.out.println("The room with id: " + id + " doesn't exist");
	}

	public boolean adjoiningRooms(int n1, int n2){
		if(isEmpty())
			return false;
		if(findRoomById(n1) == null)
			return false;
		if(findRoomById(n2) == null)
			return false;
		else{
			boolean flag = false;
			Node r1 = findRoomById(n1);
			String view = r1.getData().getView();
			if(r1.getNext().getData().getID() == n2 && r1.getNext().getData().getView().equals(view)){
				flag = true;
			}

			return flag;
		}
	}

	public void mergeRooms(int n1, int n2){
		Node r1 = findRoomById(n1);
		Node r2 = findRoomById(n2);
		if(isEmpty())
			System.out.println("This floor is empty");
		else if(r1 == null || r2 == null)
			System.out.println("Room " + n1 + " or " + n2 + " doesn't exist");
		else if(r1.getData().getBeingRenovated() == true)
			System.out.println("Room " + n1 +" is currently being renovated. You can't merge this rooms with adjoining rooms");
		else if(r2.getData().getBeingRenovated() == true)
			System.out.println("Room " + n2 +" is currently being renovated. You can't merge this rooms with adjoining rooms");
		else if(r1.getData().getType().equalsIgnoreCase("suite") || r2.getData().getType().equalsIgnoreCase("suite"))
			System.out.println("Can't merge a suite with other rooms.");
		else if(adjoiningRooms(n1, n2)){
			r1.getData().getBookings().clear();
			int new_type = r1.getData().getCapacity() + r2.getData().getCapacity();
			if(new_type == 2){
				deleteRoomById(n2);
				System.out.println("The new merged room is of type double");
				r1.getData().setType("Double");
				r1.getData().setCapacity(new_type);
				r1.getData().setDescription("Double room with two queen sized beds and a dresser equiped with a mini fridge and a tv.");
				r1.getData().setPrice(50);
				r1.getData().setBeingRenovated(true);
			}
			else if(new_type == 3){
				deleteRoomById(n2);
				System.out.println("The new merged room is of type triple");
				r1.getData().setType("Triple");
				r1.getData().setCapacity(new_type);
				r1.getData().setDescription("Triple room with three queen sized beds and a dresser equiped with a mini fridge and a tv along with a couch chair and coffee table.");
				r1.getData().setPrice(70);
				r1.getData().setBeingRenovated(true);
			}
			else if(new_type >= 4 || new_type <= 6){
				deleteRoomById(n2);
				System.out.println("The new merged room is of type suite");
				r1.getData().setType("Suite");
				r1.getData().setCapacity(4);
				r1.getData().setDescription("Suite with two double rooms seperated by a living room equiped with an L-shaped couch, a coffee table and a mini fridge.");
				r1.getData().setPrice(150);
				r1.getData().setBeingRenovated(true);
			}
		}

		else
			System.out.println("These two rooms aren't adjoining rooms");
	}
  
  public void display() { // displays the objects in the linked list
    if(isEmpty())
  		System.out.println("This floor is empty");
		else {
  		Node current = first;
    	while(current != null) {
    		System.out.println(current.getData().toString());
    		if(current.getData().getBookings().isEmpty())
					System.out.println("Room " + current.getData().getID() + " currently has no bookings");
  			else {
  				System.out.println("The bookings of room " + current.getData().getID() + " are: ");
    			current.getData().getBookings().display();
    		}
				System.out.println();
    		current = current.getNext();
    	}
    }
	}

	public void displayRooms() { // displays the objects in the linked list
    if(isEmpty())
  		System.out.println("This floor is empty");
		else {
  		Node current = first;
    	while(current != null) {
    		current.getData().printRoomInformation();
				System.out.println();
    		current = current.getNext();
    	}
    }
	}

	public void displayBookings() { 
    if(isEmpty())
  		System.out.println("This floor is empty");
		else {
  		Node current = first;
    	while(current != null) {
    		System.out.println("Room " + current.getData().getID()+ "'s bookings: ");
				current.getData().getBookings().display();
				System.out.println();
    		current = current.getNext();
    	}
    }
	}

	public void displayGuests() { 
    if(isEmpty())
  		System.out.println("This floor is empty");
		else {
  		Node current = first;
    	while(current != null) {
    		System.out.println("Room " + current.getData().getID()+ "'s Guests: ");
				current.getData().getBookings().displayGuests();
    		current = current.getNext();
    	}
    }
	}

}
