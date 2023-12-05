package DataImplementation;

public class Node {

    // Instance variable to store data of type Product
    Product data;

    // Reference to the next Node in the linked list
    Node next;

    /**
     * Constructor to create a Node with the given Product data.
     *
     * @param data The Product data to be stored in the node.
     */
    public Node(Product data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Getter method to retrieve the next Node in the linked list.
     *
     * @return The next Node in the linked list.
     */
    public Node getNext() {
        return next;
    }

    /**
     * Setter method to set the next Node in the linked list.
     *
     * @param next The next Node to be set.
     */
    public void setNext(Node next) {
        this.next = next;
    }
}
