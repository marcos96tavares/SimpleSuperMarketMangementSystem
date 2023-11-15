package ColletionFolder;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Serves implements SystemInterface{


    private final List<Product> listProduct = new LinkedList<>();
    private final List<Activity> stackActivity = new LinkedList<>();

    public Serves() {
    }
    /**
     * Adds a new product to the list of products.
     *
     * @param product The Product object to be added to the list.
     *               This method adds the specified product to the listProduct.
     *               Ensure that the provided Product object is not null.
     */
    @Override
    public void createNewProductAndAdd(Product product) {
        // Add the specified product to the listProduct

        listProduct.add(product);
    }


    /**
     * Displays details of all products in the list and returns a concatenated string representation.
     *
     * @return A concatenated string containing details of all products in the list.
     *         Each product's details are separated by a newline character ("\n").
     */
    @Override
    public Product[] displayListProductsDetails() {
        // Step 3: Return the array of products
        return listProduct.toArray(new Product[0]);
    }



    /**
     * Deletes a product from the list based on the provided product ID.
     *
     * @param product_id The ID of the product to be deleted.
     * @return true if the product is successfully deleted, false otherwise.
     */
    @Override
    public boolean deleteProduct(int product_id) {
        // Step 1: Initialize a flag to indicate whether the deletion was successful
        boolean flag = true;

        // Step 2: Find the product with the specified ID from the list of products
        Product productToDelete = listProduct.stream()
                .filter(p -> p.getProductId() == product_id)
                .findFirst()
                .orElse(null);

        // Step 3: Check if the product with the specified ID was found
        if (productToDelete != null) {
            // Step 4: Remove the found product from the list
            listProduct.remove(productToDelete);
            System.out.println("Product with ID " + product_id + " has been deleted.");
            return flag; // Deletion successful, return true
        } else {
            // Step 5: If the product with the specified ID was not found, print a message
            System.out.println("Product with ID " + product_id + " not found.");
            return false; // Deletion unsuccessful, return false
        }
    }



    /**
     * Displays details of products in a specific category, sorted by quantity.
     *
     * @param specificCategory The category for which products are to be displayed.
     * @return A concatenated string containing details of products in the specified category,
     *         sorted by quantity. Each product's details are separated by a newline character ("\n").
     */
    @Override
    public Product[] displayByCategorySortByQuantity(String specificCategory) {
        // Step 1: Use stream to filter products by the specified category
        // Step 2: Sort the filtered products by quantity in ascending order
        // Step 3: Collect the results into an array

        // Step 5: Return the array of products
        return this.listProduct.stream()
                .filter(product -> product.getProductCategory().equals(specificCategory))
                .sorted(Comparator.comparing(Product::getProductQuantity))
                .toArray(Product[]::new);
    }






    /**
     * Creates an activity and performs corresponding updates based on the activity type.
     *
     * @param activityName    The name of the activity (e.g., "AddToStock", "RemoveFromStock").
     * @param activityQuantity The quantity associated with the activity.
     * @param product_id       The ID of the product associated with the activity.
     * @return A message indicating the result of the activity and any relevant information.
     */
    @Override
    public String createActivity(String activityName, int activityQuantity, int product_id) {
        // Step 1: Find the product with the specified ID from the list of products
        Product findId = listProduct.stream()
                .filter(p -> p.getProductId() == product_id)
                .findFirst()
                .orElse(null);

        // Step 2: Check if the product with the specified ID was found
        if (findId != null) {
            // Step 3: Switch based on the activityName to determine the type of activity
            switch (activityName) {
                case "AddToStock":
                    // Step 4: Check if the activityQuantity is valid for the "AddToStock" activity
                    if (activityQuantity <= 0) {
                        return "You have entered a wrong value for Activity Quantity.";
                    } else {
                        // Step 5: Create an Activity object for "AddToStock" and update product quantity
                        Activity activityAdd = new Activity(activityName, activityQuantity, product_id);
                        addValueToProductQuantity(activityQuantity, product_id);
                        checkSystemSizeToFour(activityAdd);
                        return "You have updated!";
                    }

                case "RemoveFromStock":
                    // Step 6: Check if the activityQuantity is valid for the "RemoveFromStock" activity
                    if (activityQuantity <= 0) {
                        return "You have entered a wrong value for Activity Quantity.";
                    } else {
                        // Step 7: Attempt to remove the specified quantity from the product quantity
                        int value = removevalueToProductQuantity(activityQuantity, product_id);
                        // Step 8: Check if the quantity becomes negative after removal
                        if (value <= 0) {
                            return "Quantity of product cannot be negative.";
                        } else {
                            // Step 9: Create an Activity object for "RemoveFromStock" and update the system
                            Activity activityRemove = new Activity(activityName, activityQuantity, product_id);
                            checkSystemSizeToFour(activityRemove);
                            return "You have updated!";
                        }
                    }

                default:
                    // Step 10: Return a message for an invalid activityName
                    return "You have entered the wrong Activity Name.";
            }
        } else {
            // Step 11: Return a message if the product with the specified ID was not found
            return "Product with ID " + product_id + " not found.";
        }
    }



    /**
     * Displays activities associated with a specific product ID.
     *
     * @param producId The ID of the product for which activities are to be displayed.
     * @return A concatenated string containing details of activities associated with the specified product ID.
     *         Each activity's details are separated by a newline character ("\n").
     */
    @Override
    public Activity[] displayActivitiesByProducId(int producId) {
        // Step 1: Filter activities based on the specified product ID
        // Step 2: Collect the results into an array
        List<Activity> result = stackActivity.stream()
                .filter(p -> p.getProduct_id() == producId).toList();

        // Step 3: Return the array of activities
        return result.toArray(new Activity[0]);
    }




    /**
     * Adds a specified quantity to the product quantity of the product with the given ID.
     *
     * @param quantity   The quantity to be added to the product quantity.
     * @param productId  The ID of the product for which the quantity is to be added.
     */
    private void addValueToProductQuantity(int quantity, int productId) {
        // Step 1: Filter products based on the specified product ID
        // Step 2: Update the product quantity by adding the specified quantity
        listProduct.stream()
                .filter(p -> p.getProductId() == productId)
                .forEach(product -> product.setProductQuantity(product.getProductQuantity() + quantity));
    }

    /**
     * Checks the size of the activity stack and performs necessary actions.
     * If the stack size is 4 or more, removes the oldest activity.
     * Then, adds the new activity to the stack.
     *
     * @param activity The activity to be added to the stack.
     */
    private void checkSystemSizeToFour(Activity activity) {
        // Step 1: Check if the activity stack size is 4 or more
        if (stackActivity.size() >= 4) {
            // Step 2: Remove the oldest activity if the stack size is 4 or more
            stackActivity.remove(0);
        }
        // Step 3: Add the new activity to the stack
        stackActivity.add(activity);
    }


    /**
     * Removes a specified quantity from the product quantity of the product with the given ID.
     *
     * @param quantity   The quantity to be removed from the product quantity.
     * @param productId  The ID of the product for which the quantity is to be removed.
     * @return The new product quantity after the removal operation.
     */
    private int removevalueToProductQuantity(int quantity, int productId) {
        // Step 1: Initialize an AtomicInteger to hold the new quantity after removal
        AtomicInteger newQuantity = new AtomicInteger();

        // Step 2: Filter products based on the specified product ID
        // Step 3: Perform the removal operation and update the newQuantity
        listProduct.stream()
                .filter(p -> p.getProductId() == productId)
                .forEach(product -> {
                    newQuantity.set(product.getProductQuantity() - quantity);

                    // Step 4: Check if the new quantity becomes negative after removal
                    if (newQuantity.get() < 0) {
                        System.out.println("Quantity of product cannot be negative.");
                    } else {
                        // Step 5: Update the product quantity with the new quantity if it is non-negative
                        product.setProductQuantity(newQuantity.get());
                    }
                });

        // Step 6: Return the new quantity after the removal operation
        return newQuantity.get();
    }












}
