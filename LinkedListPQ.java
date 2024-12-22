package hotel_management_system;

public class LinkedListPQ {
	private Nodep first;

	public LinkedListPQ() {
		first = null;
	}

	public Nodep getFirst(){
		return first;
	}
	
	public boolean isEmpty() {
		return first == null;
	}

	public void insertAtBack(Booking b, int p) {
		Nodep n = new Nodep(b, p);
		if (isEmpty()) {
			first = n;
		} else {
			Nodep current = first;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(n);
			n.setNext(null);
		}
	}

	public void priorityEnqueue(Booking a, int priority) {
		Nodep n = new Nodep(a, priority);
		if (isEmpty())
			first = n;
		else if (first.getPriority() >= priority) {
			n.setNext(first);
			first = n;
		} else {
			Nodep current = first;
			if (first.getNext() != null) {
				while (current.getNext() != null && current.getNext().getPriority() < priority) 
					current = current.getNext();
				if (current.getNext() != null) {
					n.setNext(current.getNext());
					current.setNext(n);
				} 
				else 
					current.setNext(n);
			} 
			else 
				first.setNext(n);
		}
	}
	
	public Nodep deleteFromFront() {
		Nodep temp = first;
		if (!isEmpty()) {
			first = first.getNext();
		}
		return temp;
	}

	public void display() {
		if(isEmpty())
			System.out.println("This room has no bookings yet");
		else {
			System.out.println("The bookings of this room are: ");
			Nodep current = first;
			while (current != null) {
				System.out.print(current.getData() + " ");
				current = current.getNext();
				System.out.println("\n");
			}
		}
	}
	
}
