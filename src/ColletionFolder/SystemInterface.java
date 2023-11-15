package ColletionFolder;

public interface SystemInterface {

    void createNewProductAndAdd( Product product);


    Product[] displayListProductsDetails();

    boolean deleteProduct(int product_id);

    Product[] displayByCategorySortByQuantity(String specificCategory);


    String createActivity(String activityName,
                        int activityQuantity,
                        int product_id);



    Activity[] displayActivitiesByProducId(int producId);








}
