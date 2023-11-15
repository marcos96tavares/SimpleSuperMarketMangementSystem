package DataImplementation;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {


    /**
     * Custom method to set up the components and layout of the panel.
     * This method can be overridden to customize the appearance and behavior
     * of the panel based on the specific requirements of the application.
     */

    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new MyPanel());
        frame.pack();
        frame.setVisible (true);
    }

    private Serves serves;
    private JLabel ProductNameLabel;
    private JTextField ProductNameText;
    private JLabel ProductCategoryLable;
    private JTextField ProductCategoryText;
    private JLabel ProductQuantityLabel;
    private JTextField ProductQuantityText;
    private JLabel jcomp7;
    private JLabel jcomp8;
    private JSlider jcomp9;
    private JLabel productIdLabel;
    private JLabel activiityQuaLabel;
    private JLabel activityNameLable;
    private JTextField productIdText;
    private JTextField activiityQuaText;
    private JTextField activityNameText;
    private JLabel jcomp16;
    private JButton createProductButton;
    private JButton DisplayByCategory;
    private JButton DelecteProButton;
    private JButton updateSystemButton;
    private JButton DisplayListProButton;
    private JButton VendorReportButton;
    private JTextArea DisplayAreaBox;





    /**
     * Constructor for MyPanel class. Initializes the panel with default settings.
     * This constructor may be used to create an instance of MyPanel with default
     * attributes and layout.
     */
    public MyPanel() {
        //construct components



        ProductNameLabel = new JLabel ("Product Name");
        ProductNameText = new JTextField (5);
        ProductCategoryLable = new JLabel ("Product Category");
        ProductCategoryText = new JTextField (5);
        ProductQuantityLabel = new JLabel ("Product Quantity");
        ProductQuantityText = new JTextField (5);
        jcomp7 = new JLabel ("Products");
        jcomp8 = new JLabel ("Activities");
        jcomp9 = new JSlider (0, 20);
        productIdLabel = new JLabel ("Product-id");
        activiityQuaLabel = new JLabel ("Activity quanity");
        activityNameLable = new JLabel ("Activity Name");
        productIdText = new JTextField (5);
        activiityQuaText = new JTextField (5);
        activityNameText = new JTextField (5);
        jcomp16 = new JLabel ("Display Area");
        createProductButton = new JButton ("Add Product");
        DisplayByCategory = new JButton ("Display by Category");
        DelecteProButton = new JButton ("Delecte Pro");
        updateSystemButton = new JButton ("Update System");
        DisplayListProButton = new JButton ("Display ListProducts Pro");
        VendorReportButton = new JButton ("Vendor Report");
        DisplayAreaBox = new JTextArea (5, 5);
        serves = new Serves();





        //set components properties
        jcomp9.setOrientation (JSlider.VERTICAL);
        jcomp9.setMinorTickSpacing (1);
        jcomp9.setMajorTickSpacing (5);
        jcomp9.setPaintTicks (true);
        jcomp9.setPaintLabels (true);

        //adjust size and set layout
        setPreferredSize (new Dimension(915, 425));
        setLayout (null);

        //add components
        add (ProductNameLabel);
        add (ProductNameText);
        add (ProductCategoryLable);
        add (ProductCategoryText);
        add (ProductQuantityLabel);
        add (ProductQuantityText);
        add (jcomp7);
        add (jcomp8);
        add (jcomp9);
        add (productIdLabel);
        add (activiityQuaLabel);
        add (activityNameLable);
        add (productIdText);
        add (activiityQuaText);
        add (activityNameText);
        add (jcomp16);
        add (createProductButton);
        add (DisplayByCategory);
        add (DelecteProButton);
        add (updateSystemButton);
        add (DisplayListProButton);
        add (VendorReportButton);
        add (DisplayAreaBox);



        //set component bounds (only needed by Absolute Positioning)
        ProductNameLabel.setBounds (20, 70, 100, 25);
        ProductNameText.setBounds (135, 75, 100, 25);
        ProductCategoryLable.setBounds (15, 120, 100, 25);
        ProductCategoryText.setBounds (135, 120, 100, 25);
        ProductQuantityLabel.setBounds (15, 165, 100, 25);
        ProductQuantityText.setBounds (135, 165, 100, 25);
        jcomp7.setBounds (20, 30, 214, 25);
        jcomp8.setBounds (290, 25, 100, 25);
        jcomp9.setBounds (255, 0, 10, 420);
        productIdLabel.setBounds (285, 75, 100, 25);
        activiityQuaLabel.setBounds (280, 120, 100, 25);
        activityNameLable.setBounds (275, 170, 100, 25);
        productIdText.setBounds (395, 75, 100, 25);
        activiityQuaText.setBounds (395, 125, 100, 25);
        activityNameText.setBounds (395, 170, 100, 25);
        jcomp16.setBounds (565, 25, 100, 25);
        createProductButton.setBounds (25, 265, 115, 25);
        DisplayByCategory.setBounds (290, 265, 120, 25);
        DelecteProButton.setBounds (25, 310, 115, 25);
        updateSystemButton.setBounds (290, 315, 120, 25);
        DisplayListProButton.setBounds (560, 385, 130, 25);
        VendorReportButton.setBounds (740, 385, 135, 25);
        DisplayAreaBox.setBounds (565, 60, 800, 300);




        /**
         * ActionListener for the createProductButton. When the button is clicked, it performs the following actions:
         * 1. Calls the createProduct method to create a new Product using the entered details.
         * 2. Adds the newly created product to the serves object.
         * 3. Displays a JOptionPane message indicating that a new product has been created.
         * 4. Resets the text fields for product category, name, and quantity.
         */
        createProductButton.addActionListener(e -> {
            // Step 1: Create a new Product using the entered details

            Product newProduct = createProduct();

            // Step 2: Add the newly created product to the serves object
            serves.createNewProductAndAdd(newProduct);

            // Step 3: Display a JOptionPane message indicating that a new product has been created
            JOptionPane.showMessageDialog(null, "You have created a new Product");

            // Step 4: Reset the text fields for product category, name, and quantity
            ProductCategoryText.setText("");
            ProductNameText.setText("");
            ProductQuantityText.setText("");
        });


        /**
         * ActionListener for the DisplayListProButton. When the button is clicked, it performs the following actions:
         * 1. Clears the text content in the DisplayAreaBox.
         * 2. Appends the details of all products in the serves object to the DisplayAreaBox.
         */
        DisplayListProButton.addActionListener(e -> {
            // Step 1: Clear the text content in the DisplayAreaBox
            DisplayAreaBox.setText("");

            // Step 2: Append the details of all products in the serves object to the DisplayAreaBox
            DisplayAreaBox.append(serves.displayListProductsDetails());
        });


        /**
         * ActionListener for the DelecteProButton. When the button is clicked, it performs the following actions:
         * 1. Clears the text content in the DisplayAreaBox.
         * 2. Retrieves the product ID from the productIdText field.
         * 3. Attempts to parse the product ID as an integer.
         * 4. If the parsing is successful, attempts to delete the product with the given ID using the serves object.
         *    - If the deletion is successful, displays a JOptionPane message indicating that the product has been deleted.
         *    - If the product with the given ID is not found, displays a JOptionPane message indicating that the product was not found.
         * 5. If the parsing of the product ID fails (NumberFormatException), displays a JOptionPane message indicating an invalid input.
         * 6. Resets the productIdText field.
         */
        DelecteProButton.addActionListener(e -> {
            // Step 1: Clear the text content in the DisplayAreaBox
            DisplayAreaBox.setText("");

            // Step 2: Retrieve the product ID from the productIdText field
            int productId;

            try {
                // Step 3: Attempt to parse the product ID as an integer
                productId = Integer.parseInt(String.valueOf(productIdText.getText()));

                // Step 4: If parsing is successful, attempt to delete the product with the given ID
                if (serves.deleteProduct(productId)) {
                    // If the deletion is successful, display a JOptionPane message
                    JOptionPane.showMessageDialog(null, "Product with ID " + productId + " has been deleted.");
                } else {
                    // If the product with the given ID is not found, display a JOptionPane message
                    JOptionPane.showMessageDialog(null, "Product with ID " + productId + " not found.");
                }
            } catch (NumberFormatException s) {
                // Step 5: If parsing of the product ID fails, display a JOptionPane message for invalid input
                JOptionPane.showMessageDialog(null, "Invalid input for product product-id. Please enter a valid integer.");
            }

            // Step 6: Reset the productIdText field
            productIdText.setText("");
        });


        /**
         * ActionListener for the DisplayByCategory button. When the button is clicked, it performs the following actions:
         * 1. Clears the text content in the DisplayAreaBox.
         * 2. Retrieves the product category from the ProductCategoryText field.
         * 3. Appends the details of products filtered by the specified category and sorted by quantity to the DisplayAreaBox.
         */
        DisplayByCategory.addActionListener(e -> {
            // Step 1: Clear the text content in the DisplayAreaBox
            DisplayAreaBox.setText("");

            // Step 2: Retrieve the product category from the ProductCategoryText field
            String productCategory = String.valueOf(ProductCategoryText.getText()); // Make sure ProductCategoryText is properly initialized

            // Step 3: Append the details of products filtered by the specified category and sorted by quantity to the DisplayAreaBox
            DisplayAreaBox.append(serves.displayByCategorySortByQuantity(productCategory));
        });

        /**
         * ActionListener for the updateSystemButton. When the button is clicked, it performs the following actions:
         * 1. Calls activityName(), activityQuantity(), and productId() methods to retrieve values for the activity.
         * 2. Calls the createActivity method of the serves object, passing the retrieved values.
         * 3. Displays a JOptionPane message based on the result of the createActivity method.
         * 4. Resets the text fields for activity quantity, activity name, and product ID.
         */
        updateSystemButton.addActionListener(e -> {
            // Step 1: Call activityName(), activityQuantity(), and productId() methods to retrieve values for the activity
            String activityNameValue = activityName();
            int activityQuantityValue = activityQuantity();
            int productIdValue = productId();

            // Step 2: Call the createActivity method of the serves object, passing the retrieved values
            String value = serves.createActivity(activityNameValue, activityQuantityValue, productIdValue);

            // Step 3: Display a JOptionPane message based on the result of the createActivity method
            JOptionPane.showMessageDialog(null, value);

            // Step 4: Reset the text fields for activity quantity, activity name, and product ID
            activiityQuaText.setText("");
            activityNameText.setText("");
            productIdText.setText("");
        });


/**
 * ActionListener for the VendorReportButton. When the button is clicked, it performs the following actions:
 * 1. Clears the text content in the DisplayAreaBox.
 * 2. Calls the productId() method to retrieve the product ID.
 * 3. Calls the displayActivitiesByProducId method of the serves object, passing the retrieved product ID.
 * 4. Displays a JOptionPane message if the product ID does not exist, otherwise, appends the result to the DisplayAreaBox.
 */
        VendorReportButton.addActionListener(e -> {
            // Step 1: Clear the text content in the DisplayAreaBox
            DisplayAreaBox.setText("");

            // Step 2: Call the productId() method to retrieve the product ID
            int productIdValue = productId();

            // Step 3: Call the displayActivitiesByProducId method of the serves object, passing the retrieved product ID
            String value = serves.displayActivitiesByProducId(productIdValue);

            // Step 4: Display a JOptionPane message if the product ID does not exist, otherwise, append the result to the DisplayAreaBox
            if (value.equals("")) {
                JOptionPane.showMessageDialog(null, "The Product-ID does not exist!");
            }

            DisplayAreaBox.append(value);
        });


    }











    /**
     * Creates a new Product based on the values entered in the corresponding text fields.
     * @return A Product object with details entered by the user, or null if an error occurs.
     */
    private Product createProduct() {
        Product product = null;

        try {
            // Step 1: Retrieve the product name from the ProductNameText field
            String productName = String.valueOf(ProductNameText.getText()); // Make sure ProductNameText is properly initialized

            // Step 2: Retrieve the product quantity from the ProductQuantityText field and parse it as an integer
            int productQuantity = Integer.parseInt(String.valueOf(ProductQuantityText.getText())); // Make sure ProductQuantityText is properly initialized

            // Step 3: Retrieve the product category from the ProductCategoryText field
            String productCategory = String.valueOf(ProductCategoryText.getText()); // Make sure ProductCategoryText is properly initialized

            // Step 4: Create a new Product object with the retrieved details
            product = new Product(productName, productCategory, productQuantity);
        } catch (NumberFormatException e) {
            // Step 5: Handle a NumberFormatException if the parsing of product quantity fails
            System.out.println("Invalid input for product quantity. Please enter a valid integer.");
        } catch (Exception e) {
            // Step 6: Handle other exceptions and print an error message
            System.out.println("An error occurred: " + e.getMessage());
        }

        // Step 7: Return the created Product object or null if an error occurred
        return product;
    }


    /**
     * Retrieves the activity name from the activityNameText field.
     *
     * @return A String representing the activity name entered by the user.
     *         Returns an empty string if an error occurs during retrieval.
     */
    private String activityName() {
        // Step 1: Initialize the activityName variable with an empty string
        String activityName = "";

        try {
            // Step 2: Retrieve the activity name from the activityNameText field
            activityName = String.valueOf(activityNameText.getText()); // Make sure activityNameText is properly initialized

        } catch (Exception e) {
            // Step 3: Handle other exceptions and print an error message
            System.out.println("An error occurred: " + e.getMessage());
        }

        // Step 4: Return the retrieved activity name or an empty string if an error occurred
        return activityName;
    }




    /**
     * Retrieves the activity quantity from the activiityQuaText field.
     *
     * @return An integer representing the activity quantity entered by the user.
     *         Returns 0 if an error occurs during retrieval or if the input is not a valid integer.
     */
    private int activityQuantity() {
        // Step 1: Initialize the activityQuantity variable with 0
        int activityQuantity = 0;

        try {
            // Step 2: Retrieve the activity quantity from the activiityQuaText field and parse it as an integer
            activityQuantity = Integer.parseInt(String.valueOf(activiityQuaText.getText())); // Make sure activiityQuaText is properly initialized
        } catch (NumberFormatException e) {
            // Step 3: Handle a NumberFormatException if the parsing of activity quantity fails
            System.out.println("Invalid input for activity quantity. Please enter a valid integer.");
        }

        // Step 4: Return the retrieved activity quantity or 0 if an error occurred
        return activityQuantity;
    }




    /**
     * Retrieves the product ID from the productIdText field.
     *
     * @return An integer representing the product ID entered by the user.
     *         Returns 0 if an error occurs during retrieval or if the input is not a valid integer.
     */
    private int productId() {
        // Step 1: Initialize the productId variable with 0
        int productId = 0;

        try {
            // Step 2: Retrieve the product ID from the productIdText field and parse it as an integer
            productId = Integer.parseInt(String.valueOf(productIdText.getText())); // Make sure productIdText is properly initialized
        } catch (NumberFormatException e) {
            // Step 3: Handle a NumberFormatException if the parsing of product ID fails
            // Display a JOptionPane message indicating that the product with the given ID is not found
            JOptionPane.showMessageDialog(null, "Product with ID " + productId + " not found.");
        }

        // Step 4: Return the retrieved product ID or 0 if an error occurred
        return productId;
    }









}

