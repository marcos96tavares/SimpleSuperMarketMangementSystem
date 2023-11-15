package DataImplementation;

public interface SystemInterface {

    void createNewProductAndAdd( Product product);


    String displayListProductsDetails();

    boolean deleteProduct(int product_id);

    String displayByCategorySortByQuantity(String specificCategory);


    String createActivity(String activityName,
                          int activityQuantity,
                          int product_id);



    String displayActivitiesByProducId(int producId);




}
