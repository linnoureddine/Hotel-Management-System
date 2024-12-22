package hotel_management_system;

public class Nodep {
    private Booking data;
    private int priority;
    private Nodep next;

    public Nodep() {
        data = null;
        priority = 0;
        next = null;
    }
    
	public Nodep(Booking data, int p) {
        this.data = data;
        priority  = p;
        this.next = null;
    }

    public Booking getData() {
        return data;
    }

    public void setData(Booking data) {
        this.data = data;
    }
    
    public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

    public Nodep getNext() {
        return next;
    }

    public void setNext(Nodep next) {
        this.next = next;
    }
}
