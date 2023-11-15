package DataImplementation;

import java.util.Date;

public class Product {

    private static int PRODUCT_ID =0;
    private int product_id;
    private String productName;
    private String productCategory;
    private Date productDate;
    private int productQuantity;

    public Product(String productName, String productCategory, int productQuantity) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.productQuantity = productQuantity;
        productDate = new Date();
        product_id = PRODUCT_ID++;
    }

    public Date getProductDate() {
        return productDate;
    }

    public  int getProductId() {
        return product_id;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "procut-id='" + getProductId() + '\'' +
                "productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productDate=" + productDate +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
