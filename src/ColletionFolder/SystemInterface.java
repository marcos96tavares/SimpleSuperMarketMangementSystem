package ColletionFolder;

public interface SystemInterface {

    /**
     * Creates a new product and adds it to the system.
     *
     * @param product The Product object to be added to the system.
     */
    void createNewProductAndAdd(Product product);

    /**
     * Displays details of all products in the system.
     *
     * @return An array of Product objects containing details of all products.
     */
    Product[] displayListProductsDetails();

    /**
     * Deletes a product from the system based on the product ID.
     *
     * @param product_id The ID of the product to be deleted.
     * @return True if the product is successfully deleted, false otherwise.
     */
    boolean deleteProduct(int product_id);

    /**
     * Displays products filtered by a specific category and sorted by quantity.
     *
     * @param specificCategory The category to filter products.
     * @return An array of Product objects filtered and sorted by the specified category and quantity.
     */
    Product[] displayByCategorySortByQuantity(String specificCategory);

    /**
     * Creates an activity and associates it with a product in the system.
     *
     * @param activityName     The name of the activity.
     * @param activityQuantity The quantity associated with the activity.
     * @param product_id       The ID of the product associated with the activity.
     * @return A string indicating the result of the activity creation.
     */
    String createActivity(String activityName, int activityQuantity, int product_id);

    /**
     * Displays activities associated with a specific product ID.
     *
     * @param producId The ID of the product for which activities are to be displayed.
     * @return An array of Activity objects associated with the specified product ID.
     */
    Activity[] displayActivitiesByProducId(int producId);








}
