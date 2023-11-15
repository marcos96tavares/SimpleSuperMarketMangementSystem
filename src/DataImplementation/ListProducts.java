package DataImplementation;

public class ListProducts {

    private Node head;
    private int size = 0;


    public ListProducts(){
        this.head = null;
    }
    public void add( Product product){

        Node node = new Node(product);
        node.setNext(this.head);
        this.head = node;
        size++;
    }

    /**
     * Deletes a product from the list based on the given product ID.
     *
     * @param productId The ID of the product to be deleted.
     * @return true if the product is successfully deleted, false otherwise.
     */
    public boolean deleteProductById(int productId) {
        Node current = this.head;
        Node previous = null;

        while (current != null) {
            if (current.data.getProductId() == productId) {
                if (previous == null) {
                    // If the product to be deleted is the head of the list
                    this.head = current.getNext();
                } else {
                    // If the product to be deleted is not the head of the list
                    previous.setNext(current.getNext());
                }
                size--;
                return true; // Product deleted successfully
            }
            previous = current;
            current = current.getNext();
        }

        return false; // Product not found or not deleted
    }

    /**
     * Converts the list of products to a string representation.
     *
     * @return A string containing details of all products in the list.
     *         Each product's details are separated by a newline character ("\n").
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = this.head;

        while (current != null) {
            Product product = current.data;
            result.append(product.toString()).append("\n");
            current = current.getNext();
        }

        return result.toString();
    }



    public String filterByCategory(String category) {
        Node current = this.head;
        ListProducts filteredList = new ListProducts();
        Node temp = (head != null) ? head : null;
        StringBuilder print = new StringBuilder();

        //search
        while (current != null) {
            if (current.data.getProductCategory().equals(category)) {
                filteredList.add(current.data);
            }
            current = current.getNext();
        }

        // Insertion Sort
        Node sortedList = null;
        Node unsorted = filteredList.head;
        while (unsorted != null) {
            Node nextNode = unsorted.getNext();
            if (sortedList == null || unsorted.data.getProductQuantity() < sortedList.data.getProductQuantity()) {
                unsorted.setNext(sortedList);
                sortedList = unsorted;
            } else {
                Node currentSorted = sortedList;
                while (currentSorted.getNext() != null && unsorted.data.getProductQuantity() < currentSorted.getNext().data.getProductQuantity()) {
                    currentSorted = currentSorted.getNext();
                }
                unsorted.setNext(currentSorted.getNext());
                currentSorted.setNext(unsorted);
            }
            unsorted = nextNode;
        }

        // Build the result string
        Node sortedTemp = sortedList;
        while (sortedTemp != null) {
            print.append(sortedTemp.data.toString()).append("\n");
            sortedTemp = sortedTemp.getNext();
        }

        return print.toString();
    }

    /**
     * Searches for a product in the list based on the given product ID.
     *
     * @param productId The ID of the product to be searched.
     * @return The Product object if found, or null if not found.
     */
    public boolean searchProductById(int productId) {
        Node current = this.head;
        boolean flag = true;

        while (current != null) {
            if (current.data.getProductId() == productId) {
                return flag; // Product found
            }
            current = current.getNext();
        }

        return false; // Product not found
    }

    /**
     * Adds a specified quantity to the product quantity of the product with the given ID.
     *
     * @param quantity   The quantity to be added to the product quantity.
     * @param productId  The ID of the product for which the quantity is to be added.
     * @return true if the quantity is successfully added, false otherwise.
     */
    public boolean addQuantityToProduct(int quantity, int productId) {
        Node current = this.head;
        int value = 0;

        while (current != null) {
            if (current.data.getProductId() == productId) {
                // Update the product quantity by adding the specified quantity
                 current.data.setProductQuantity(current.data.getProductQuantity() + quantity);
                 value = current.data.getProductQuantity();

                 if (value>0){
                     return true; // Quantity added successfully
                 }

            }
            current = current.getNext();
        }

        return false; // Product not found or quantity not added
    }

    public int removeQuantityFromProduct(int quantity, int productId) {
        Node current = this.head;
        int value = 0;

        while (current != null) {
            if (current.data.getProductId() == productId) {
                // Update the product quantity by adding the specified quantity
                current.data.setProductQuantity(current.data.getProductQuantity() - quantity);
                value = current.data.getProductQuantity();
                if (value>0){
                   return value;
                }
            }
            current = current.getNext();
        }

        return -1;
    }






}
