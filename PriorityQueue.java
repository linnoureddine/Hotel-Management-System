package hotel_management_system;

public class PriorityQueue extends LinkedListPQ {
	
	public PriorityQueue(){
		super();
	}
	
	public void enqueue(Booking a , int p){
		priorityEnqueue(a, p);
	}
	
	public void enqueue2(Booking a, int p){
		insertAtBack(a, p);
	}
	
	public Nodep dequeue(){
		return deleteFromFront();
	}

	public Nodep searchByName(String name) { 
		Nodep booking = null;
		if(!isEmpty()) {
			PriorityQueue temp = new PriorityQueue();
			Nodep current;
			while(!isEmpty()) { 
				current = dequeue();
				if(current.getData().getGuest().getFull_name().equals(name)) {
					booking = current;
				}
				temp.enqueue2(current.getData(), current.getPriority());
			}
			
			while(!temp.isEmpty()) {
				Nodep x = temp.dequeue();
				enqueue2(x.getData(), x.getPriority());
			}
			
		}

		return booking;
	}

	public boolean deleteByName(String name) { 
		if(searchByName(name) != null) {
			PriorityQueue temp = new PriorityQueue();
			Nodep current;
			while(!isEmpty()) { 
				current = dequeue();
				if(!current.getData().getGuest().getFull_name().equals(name)) {
					temp.enqueue2(current.getData(), current.getPriority());
				}
			}
			
			while(!temp.isEmpty()) {
				Nodep x = temp.dequeue();
				enqueue(x.getData(), x.getPriority());
			}
			
			return true;
		}
		
		return false;
	}

	public void clear(){
		if(isEmpty())
			return;
		else{
			while(!isEmpty()) 
				dequeue();
		}
	}

	public void display() {
		super.display();
	}

	public void displayGuests() { //displays the guests that are checked in 
		if(isEmpty())
			System.out.println("This room is not checked into ");
		else{
			PriorityQueue temp = new PriorityQueue();
			boolean flag = false;
			while(!isEmpty()){
				Nodep current = dequeue();
				if(current.getData().getStatus()){
					System.out.println(current.getData().getGuest() + "\n");
					flag = true;
				}

				temp.enqueue2(current.getData(), current.getPriority());
			}

			if(!flag)
				System.out.println("No guest is currently staying in this room \n");

			while(!temp.isEmpty()) {
				Nodep x = temp.dequeue();
				enqueue(x.getData(), x.getPriority());
			}
		}
	}

}
