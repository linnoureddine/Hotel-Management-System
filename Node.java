package hotel_management_system;

public class Node {
    private Room data;
    private Node next;

    public Node() {
        data = null;
        next  = null;
    }
    
    public Node(Room data) {
        this.data = data;
        this.next = null;
    }

    public Room getData() {
        return data;
    }

    public void setData(Room data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
}
