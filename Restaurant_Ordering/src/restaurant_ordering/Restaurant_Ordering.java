//Fast Happy Foods
//GUI
/**
 *
 * @author blair
 */


package restaurant_ordering;

import java.io.File;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;


public class Restaurant_Ordering extends Application {
    //variables
    RestaurantMenu fullMenu;
    Order order;
    Customer customer;
    
    //controls
    //menubar controls   
    MenuBar menuBar;
    Menu adminLogin;
    MenuItem addNewItem;
    MenuItem exit;
    Menu customerView;
    MenuItem createNewOrder;
    MenuItem editExistingOrder;
    
    //menu controls
    Button entreesBtn;                          //entrees button
    Button sidesBtn;                            //sides button
    Button dessertsBtn;                         //desserts button
    Button softDrinksBtn;                       //soft drinks button
    Button clearItem;                           //clear item quantity
    
    //order controls
    Button clearCart;
    Button checkOut;
    
    //customer controls
    Button editOrder;
    Button submitOrder;
    
    //order display controls
    Label calcTotalLabel;
    Label calcTaxLabel;
    Label calcDeliveryFeeLabel;
    Label calcFinalTotalLabel;
    
    //customer controls
    TextField addressLine1;
    TextField addressLine2;
    TextField city;
    ComboBox stateComboBox;
    TextField zipCode;
    TextField phone;
    TextField email;
    Label Error;
    Label orderConfirmation;
    
    //add items controls
    ComboBox <String> categoryCombo;
    TextField newItemName;
    TextArea newItemDescription;
    TextField newItemPrice;
    Button addImageBtn;
    Label imageError;
    Image newItemImage;
    ImageView newItemView;
    Button addItemBtn;
    Button clearNewItem;
    Button seeNewMenu;
    Label adminHeader;
        
    
    //containers
    BorderPane all;
    
    //logo container
    VBox logoBannerBox;
    
    //scene container
    HBox entireScene;
    VBox rightSide; 
    
    //Menu containers
    VBox menuBox; 
    HBox categoryButtonsBox;
    ScrollPane entreesScroll;
    ScrollPane sidesScroll;
    ScrollPane dessertsScroll;
    ScrollPane softDrinksScroll;
    
    //Order display Containers
    VBox customerOrderBox;
    VBox orderDetails;
    VBox allCostBox;
    HBox orderButtonBox;
    VBox details;
    HBox itemsEachOrdered;
    
    //adminBox container    
    VBox adminBox;
    VBox addItems;
    VBox newItemImageBox;
    VBox newItemBox;
    VBox newItemAction;
    
    //customer containers
    VBox contactBox;
    VBox customerInfoBox;
    HBox contactButtons;
    HBox orderSubmitted;
    
    
    //primary Stage
    private Window primaryStage;
        
    
    @Override
    public void start(Stage primaryStage) throws InvalidInputException {
        //create the menu Bar
        buildMenuBar(primaryStage);
        
        //create the the banner box
        buildLogoBox(); 
        
        //build the menu
        buildRestaurantMenu();
        
        //create the scene
        createTheScene();
        
        //borderPane for window, set top and center        
        all = new BorderPane();
        all.setTop(menuBar);
        all.setCenter(entireScene);
        
        Scene scene = new Scene(all, 1500, 850);
        
        scene.getStylesheets().add("FastHappyFoods.css");
        
        primaryStage.setTitle("FastHappyFoods");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void createTheScene(){
        //build the menuBox
        MenuBox();
        
        //build the orderBox
        OrderBox();
                
        //build the adminBox()
        AdminBox();
        
        
        rightSide = new VBox();
        rightSide.getChildren().addAll(logoBannerBox, customerOrderBox);
        rightSide.setPadding(new Insets(0,20,20,20));
        
        entireScene = new HBox();
        entireScene.getChildren().addAll(menuBox,rightSide);
        entireScene.setPadding(new Insets(0 , 20, 0, 20));
        entireScene.setAlignment(Pos.CENTER);
    }
    
    /**
     * Build the Menu Bar
     * @param primaryStage 
     */
    private void buildMenuBar(Stage primaryStage){

    //create the menu bar
    menuBar = new MenuBar();

     //create the admin file menu
    adminLogin = new Menu("Admin Login");

    //create admin menu items
    addNewItem = new MenuItem("Add Item");
    exit = new MenuItem("Exit");

    // add menu items to admin file menu
    adminLogin.getItems().addAll(addNewItem, exit);

    //create the customer view file menu
    customerView = new Menu ("Customer Menu");

    //create items in customer view
    createNewOrder = new MenuItem("New Order");
    
    //edit existing order menu item
    editExistingOrder = new MenuItem("Edit Existing Order");
    editExistingOrder.setDisable(true); 
         
    //add the dropdowns to the menu Bar
    menuBar.getMenus().addAll(adminLogin,customerView);

    // add menu items to admin file menu
    customerView.getItems().addAll(createNewOrder, editExistingOrder);
    
    //event handler for exitItem
        exit.setOnAction(event ->{
            primaryStage.close();
        });
        
    //event handler for exitItem
    addNewItem.setOnAction(event ->{
        adminBox.getChildren().removeAll(newItemBox, addItems);      
        
        rightSide.getChildren().removeAll(customerOrderBox, newItemImageBox, newItemAction);
                
        entireScene.getChildren().removeAll(rightSide, menuBox, adminBox, customerInfoBox);
        
        rightSide.getChildren().removeAll(newItemImageBox);
        
        AdminBox();
        
        rightSide.getChildren().addAll(newItemImageBox);
        
        entireScene.getChildren().removeAll( menuBox,rightSide, adminBox);
                
        entireScene.getChildren().addAll(adminBox, rightSide);

    });
    
    //event handler for exitItem
    createNewOrder.setOnAction(event ->{
        all.setCenter(null);
        createTheScene();
        all.setCenter(entireScene);
        editExistingOrder.setDisable(true);
    });


    //event handler for edit existing order Item
    editExistingOrder.setOnAction(event ->{

        entireScene.getChildren().removeAll(adminBox, menuBox, customerInfoBox);

        rightSide.getChildren().removeAll(logoBannerBox, newItemImageBox, 
                                          orderButtonBox, customerOrderBox);

        customerOrderBox.getChildren().removeAll(orderButtonBox);
        customerOrderBox.getChildren().addAll(orderButtonBox);

        rightSide.getChildren().addAll(logoBannerBox, customerOrderBox);

        entireScene.getChildren().removeAll(rightSide);
        entireScene.getChildren().addAll(menuBox, rightSide );
    });
        

}
    
    /**
     * Build Admin Box
     */
    public void AdminBox(){
    adminHeader = new Label("Administrator - Add New Menu Item");
    adminHeader.setPrefWidth(850);
    adminHeader.setId("headerWithShadow");
    
    //create add items box
    createAddItems();
        
    adminBox = new VBox();
    adminBox.getChildren().addAll(adminHeader, addItems);
    adminBox.setAlignment(Pos.CENTER);
    adminBox.setSpacing(30);
    
    }
    
    /**
     * Create Add Items
     */
    public void createAddItems(){
        
    categoryCombo = new ComboBox(fullMenu.getObservableCategoryList());
    categoryCombo.setPromptText("Category");
    categoryCombo.setId("categoryCombo");
    categoryCombo.setPrefWidth(250);
    
    categoryCombo.setOnMousePressed(event -> 
        {
            categoryCombo.setId("categoryCombo");
            categoryCombo.setPromptText("Category");
        });
    
    newItemName = new TextField("");
    newItemName.setPromptText("Enter New Item Name");
        
    newItemDescription = new TextArea();
    newItemDescription.setPromptText("Enter New Item Description");
    newItemDescription.setWrapText(true);
    
    newItemPrice = new TextField("");
    newItemPrice.setPromptText("Enter New Item Price");
    
    //label for image error
    imageError = new Label("");
    imageError.setId("imageError");
    
    //create button to add image
    addImageBtn = new Button("Add Item Image");

    //set add image button action
    
    addImageBtn.setOnAction(event -> 
        {
            imageError.setText("");
            createImageView();
            newItemImageBox.getChildren().addAll(newItemView);
        });
    
    addImageBtn.setId("actionButton");
    addImageBtn.setPrefSize(250, 30);
    
    //create button to add new item
    addItemBtn = new Button("Add New Item");
    addItemBtn.setId("actionButton");
    addItemBtn.setPrefSize(250, 30);
    
    //set add image button action
    addItemBtn.setOnAction(new addNewItemHandler());
                
    //create clear item button
    clearNewItem = new Button("Clear Item Fields");
    clearNewItem.setId("actionButton");
    clearNewItem.setPrefSize(250, 30);
    
    clearNewItem.setOnAction(event -> 
        {
            rightSide.getChildren().removeAll(newItemImageBox);
            adminBox.getChildren().removeAll(addItems);
            createAddItems();
            adminBox.getChildren().addAll(addItems);
            rightSide.getChildren().addAll(newItemImageBox);
                       
        });
    
    Label imageHeader = new Label("Item Image");
    imageHeader.setId("imageHeader");
    
    newItemImageBox = new VBox();
    newItemImageBox.getChildren().addAll(imageHeader, imageError);
    newItemImageBox.setAlignment(Pos.CENTER);
    newItemImageBox.setPrefHeight(600);
    newItemImageBox.setId("newImage");
        
    VBox newItemLeft = new VBox();
    newItemLeft.getChildren().addAll(categoryCombo, newItemName, 
                                  newItemDescription, newItemPrice);
    newItemLeft.setSpacing(20);
        
    HBox ButtonsNewItem = new HBox();
    ButtonsNewItem.getChildren().addAll(clearNewItem, addImageBtn, addItemBtn );
    ButtonsNewItem.setSpacing(50);
        
    //create add items box
    addItems = new VBox();
    addItems.getChildren().addAll(newItemLeft, ButtonsNewItem);
    addItems.setSpacing(30);
    addItems.setPrefHeight(525);
}
    
    /**
     * Add New Item Handler
     */
    class addNewItemHandler implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent event){
        Boolean isValid = true;
        
        //instantiate new Item On Menu
        ItemOnMenu newMenuItem = new ItemOnMenu();

        //try/catch to valid input, invalid exceptions thrown setting is valid
        //to false
        try
        {   
            newMenuItem.setCategory(categoryCombo.getValue());
        }
       
        catch (InvalidInputException e)
        {
            categoryCombo.setPromptText(e.getMessage());
            categoryCombo.setId("categoryComboError");
                      
            isValid = false;
        }
        
        try
        {   
            newMenuItem.setName(newItemName.getText());
        }
       
        catch (InvalidInputException e)
        {
            newItemName.setPromptText(e.getMessage());
            newItemName.setStyle("-fx-prompt-text-fill: red;");
                   
            isValid = false;
        }
        
        try
        {   
            newMenuItem.setDescription(newItemDescription.getText());
        }
       
        catch (InvalidInputException e)
        {
            newItemDescription.setPromptText(e.getMessage());
            newItemDescription.setStyle("-fx-prompt-text-fill: red;");
                   
            isValid = false;
        }
        
        try
        {   
            newMenuItem.setPrice(Double.parseDouble(newItemPrice.getText()));
        }
        
        catch (IllegalArgumentException e)
        {
            newItemPrice.setPromptText("Valid Price Required (ex. 5.95)");
            newItemPrice.setText("");
            newItemPrice.setStyle("-fx-prompt-text-fill: red;");
            isValid = false;
        }
       
        catch (InvalidInputException ie)
        {
            newItemPrice.setPromptText(ie.getMessage());
            newItemPrice.setText("");
            newItemPrice.setStyle("-fx-prompt-text-fill: red;");
                   
            isValid = false;
        }
                
        try
        {   
            newMenuItem.setImage(newItemImage);
        }
       
        
        catch (InvalidInputException e)
        {
            imageError.setText("Image (Required)");
                   
            isValid = false;
        }
        
        
        //if all is valid create new Item display
        if(isValid)
        {
           createNewItemBox(newMenuItem);
           editExistingOrder.setDisable(true);
        }
    }
}
    
    /**
     * create New Item Box
     * @param newItem
     */
    public void createNewItemBox(ItemOnMenu newItem){
        
        fullMenu.addItemToMenu(newItem);
        
        rightSide.getChildren().removeAll(newItemImageBox);
        
        adminBox.getChildren().removeAll(addItems);
        
        adminHeader.setText("New Addition to "
                                    + newItem.getCategory() + " Successful !");
        adminHeader.setWrapText(true);
        
                       
        Label itemNameLabel = new Label();
        itemNameLabel.setText(newItem.getName());
        itemNameLabel.setPrefWidth(600);
        itemNameLabel.setId("headerItemNew");
        

        Label itemPriceLabel = new Label();
        itemPriceLabel.setText(String.format("$%8.2f",newItem.getPrice()));
        itemPriceLabel.setId("headerItemNew");
        itemPriceLabel.setPrefWidth(200);
        itemPriceLabel.setAlignment(Pos.BASELINE_RIGHT);

        //create HBox for name and price
        HBox itemNamePrice = new HBox (itemNameLabel, itemPriceLabel);
        
        
        ImageView itemPicture = new ImageView(newItem.getImage());
        itemPicture.setFitWidth(250);
        itemPicture.setPreserveRatio(true);

        Label itemDescriptionLabel = new Label();
        itemDescriptionLabel.setText(newItem.getDescription());
        itemDescriptionLabel.setPadding(new Insets(0,20, 0, 0));
        itemDescriptionLabel.setPrefWidth(550);
        itemDescriptionLabel.setWrapText(true);
        itemDescriptionLabel.setId("descriptionNew");
        


        VBox itemDescBox = new VBox(itemDescriptionLabel);
        itemDescBox.setAlignment(Pos.CENTER);

        //create HBox for name and price
        HBox itemPicDesc = new HBox (itemPicture, itemDescBox);
        itemPicDesc.setSpacing(20);
        

        VBox itemInfo = new VBox();
        itemInfo.getChildren().addAll(itemNamePrice,
                                itemPicDesc);
        

        HBox itemBox = new HBox();
        itemBox.getChildren().addAll(itemInfo);

        itemBox.setSpacing(25);
        
        newItemBox = new VBox();
       
        newItemBox.getChildren().addAll(itemBox); 
            newItemBox.setPrefSize(400, 525);
            newItemBox.setPadding(new Insets(20));
            newItemBox.setAlignment(Pos.CENTER);
        
        seeNewMenu = new Button("View New Menu");
        seeNewMenu.setId("actionButton");
        
        //event handler for exitItem
        seeNewMenu.setOnAction(event ->{
            all.setCenter(null);
            createTheScene();
            
            switch (newItem.getCategory()) {
                case "Entrees":
                    entreesBtn.fire();
                    break;
                case "Sides":
                    sidesBtn.fire();
                    break;
                case "Desserts":
                    dessertsBtn.fire();
                    break;
                case "Soft Drinks":
                    softDrinksBtn.fire();
                    break;
            }
            all.setCenter(entireScene);
            
            
            
        });
        
        newItemAction = new VBox();
        newItemAction.getChildren().addAll(seeNewMenu);
        newItemAction.setAlignment(Pos.CENTER);
        newItemAction.setPrefHeight(600);
        
        adminBox.getChildren().addAll(newItemBox);
        
        rightSide.getChildren().addAll(newItemAction);
        
    }

    /**
     * Create Image View
     */
    public void createImageView(){
        FileChooser fileChooser = new FileChooser();

        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        newItemImage = new Image(selectedFile.toURI().toString());
        newItemView = new ImageView(newItemImage); 
        newItemView.setFitWidth(400);
        newItemView.setPreserveRatio(true);
    }
    
    /**
     * Customer Info Box
     */
    public void CustomerInfoBox(){
    Label deliveryLabel = new Label("Customer Delivery Information");
    deliveryLabel.setId("headerWithShadow");
    
    HBox deliveryTitle = new HBox (deliveryLabel);
    deliveryTitle.setPadding(new Insets(0, 0, 30, 0));
    deliveryTitle.setAlignment(Pos.CENTER);
    
    createContactBox();
    
    createCustomerInfoBoxButtons();
    
    contactButtons = new HBox ();
    contactButtons.getChildren().addAll(editOrder, submitOrder);
    contactButtons.setPadding(new Insets(30, 0 , 30, 0));
    contactButtons.setAlignment(Pos.CENTER);
    contactButtons.setSpacing(150);
    
    customerInfoBox = new VBox();
    customerInfoBox.getChildren().addAll(deliveryTitle, contactBox, contactButtons);
    customerInfoBox.setPrefWidth(850);
    customerInfoBox.setPadding(new Insets(30));  
}
    
    /**
     * create Customer Info Buttons
     */
    public void createCustomerInfoBoxButtons(){
        editOrder = new Button("Edit Order");
        editOrder.setId("actionButton");
        editOrder.setPrefSize(200, 30);

        submitOrder = new Button ("Submit Order");
        submitOrder.setId("actionButton");
        submitOrder.setPrefSize(200, 30);

        editOrder.setOnAction(event -> 
        {

            entireScene.getChildren().removeAll(customerInfoBox, rightSide);
            entireScene.getChildren().addAll(menuBox, rightSide);
            customerOrderBox.getChildren().addAll(orderButtonBox);

        });
    
        submitOrder.setOnAction(event -> 
        {
            customer= new Customer();
            String errorMessage="";
            Error.setText("");

            boolean isValid = true;

            //try/catch to valid input and throw invalid input exceptions
            //sets is valid to false
            try
            {
                customer.setAddressLine1(addressLine1.getText());
                customer.setAddressLine2(addressLine2.getText());
            }

            catch (InvalidInputException e)
            {
                addressLine1.setPromptText(e.getMessage());
                addressLine1.setStyle("-fx-prompt-text-fill: red;");
                isValid = false;
            }

            try
            {
                customer.setCity(city.getText());
            }

            catch (InvalidInputException e)
            {
                city.setPromptText(e.getMessage());
                city.setStyle("-fx-prompt-text-fill: red;");
                isValid = false;
            }

            try
            {
                customer.setState(stateComboBox.getValue());
            }

            catch (InvalidInputException e)
            {
                stateComboBox.setPromptText(e.getMessage());
                stateComboBox.setId("stateComboError");
                isValid = false;
            }

            try
            {
                customer.setZip(zipCode.getText());
            }

            catch (InvalidInputException e)
            {
                zipCode.setPromptText(e.getMessage());
                zipCode.setStyle("-fx-prompt-text-fill: red;");
                isValid = false;
            }

            try
            {
                customer.setPhone(phone.getText());   
            }

            catch (InvalidInputException e)
            {
                phone.setPromptText(e.getMessage());
                phone.setStyle("-fx-prompt-text-fill: red;");
                isValid = false;
            }

            try
            {
                customer.setEmail(email.getText().trim());
            }

            catch (InvalidInputException e)
            {
                email.setPromptText("Valid Email (Required)");
                email.setStyle("-fx-prompt-text-fill: red;");
                errorMessage = e.getMessage();
                isValid = false;

            }

            //if all is valid create order confirmation else set the error
            //dealing with the email
            if (isValid)
            {
                customerInfoBox.getChildren().removeAll(contactBox, contactButtons);
                
                //create order confirmation box
                createOrderConfirmationBox();
            }

            else
            {
                Error.setText(errorMessage);
            }
        });
    }
    
    /**
     * Create Order Confirmation Box
     */
    public void createOrderConfirmationBox(){
    
    orderConfirmation = new Label();
    orderConfirmation.setText ("Your order has been successfully submitted.");
    orderConfirmation.setId("confirmed");
    
    orderSubmitted = new HBox();
    orderSubmitted.getChildren().addAll(orderConfirmation);
    orderSubmitted.setAlignment(Pos.CENTER);
    orderSubmitted.setPadding(new Insets(300, 30, 30, 30));
    
    customerInfoBox.getChildren().addAll(orderSubmitted);
 
}
    
    /**
     * Create Contact Box
     */
    public void createContactBox(){
        addressLine1 = new TextField();
        addressLine1.setPromptText("Address Line 1");
        addressLine1.setFocusTraversable(false);

        addressLine2 = new TextField();
        addressLine2.setPromptText("Address Line 2");
        addressLine2.setFocusTraversable(false);

        city = new TextField();
        city.setPromptText("City");
        city.setFocusTraversable(false);
        city.setPrefWidth(275);

        stateComboBox = new ComboBox(Customer.populateStateComboBox());
        stateComboBox.setPromptText("State");
        stateComboBox.setVisibleRowCount(3);
        stateComboBox.setPrefWidth(225);
        stateComboBox.setId("stateCombo");

        stateComboBox.setOnMousePressed(event -> 
        {

            stateComboBox.setId("stateCombo");
            stateComboBox.setPromptText("State");

        });

        zipCode = new TextField();
        zipCode.setPromptText("ZIP code");
        zipCode.setFocusTraversable(false);
        zipCode.setPrefWidth(200);

        HBox cityStateZip = new HBox(city, stateComboBox, zipCode);
        cityStateZip.setSpacing(20);

        phone = new TextField();
        phone.setPromptText("Phone");
        phone.setFocusTraversable(false);

        email = new TextField();
        email.setPromptText("Email");
        email.setFocusTraversable(false);

        Error = new Label("");
        Error.setId("error");
        Error.setPadding(new Insets(0, 0, 0, 10));

        contactBox = new VBox();
        contactBox.getChildren().addAll(addressLine1, addressLine2, cityStateZip, 
                                        phone, email, Error);
        contactBox.setSpacing(15);
        contactBox.setPadding(new Insets(0, 30, 0, 30));
            
}

    /**
     * Create the order Box
     */
    public void OrderBox(){
        //create new order
        order = new Order();

        createOrderDetails();

        //label
        Label customerOrderBoxLabel = new Label("Online Order");
        customerOrderBoxLabel.setId("headerWithShadow");

        HBox labelBox = new HBox();
        labelBox.getChildren().addAll(customerOrderBoxLabel);
        labelBox.setAlignment(Pos.CENTER);

        //create the all cost box
        createAllCostBox();

        //create order buttons
        createOrderButtons();


        customerOrderBox = new VBox();
        customerOrderBox.getChildren().addAll(labelBox, orderDetails, allCostBox, 
                                            orderButtonBox);

        customerOrderBox.setPadding(new Insets(10, 30, 0, 30));
        customerOrderBox.setPrefHeight(725);
        customerOrderBox.setId("orderDetailsBox");
    }
    
    /**
     * Create Order Buttons
     */
    public void createOrderButtons(){
        clearCart = new Button("Clear Cart");
        clearCart.setId("actionButton");
        clearCart.setPrefSize(200, 30);

        checkOut = new Button("Check Out");
        checkOut.setId("actionButton");
        checkOut.setPrefSize(200, 30);
        checkOut.setDisable(true);

        orderButtonBox = new HBox();
        orderButtonBox.getChildren().addAll(clearCart, checkOut);
        orderButtonBox.setSpacing(50);
        orderButtonBox.setAlignment(Pos.CENTER);

        orderButtonBox.setPadding(new Insets(15, 0, 10 , 0));

        //create order Button Actions
        clearCart.setOnAction(event -> 
        {
            all.setCenter(null);
            createTheScene();
            all.setCenter(entireScene);
            editExistingOrder.setDisable(true);
                
        });
    
        checkOut.setOnAction(event -> 
               
        {
         
            rightSide.getChildren().removeAll(logoBannerBox, customerOrderBox);
            
            customerOrderBox.getChildren().removeAll(orderButtonBox);
          
            rightSide.getChildren().removeAll(logoBannerBox, customerOrderBox);
            
            entireScene.getChildren().removeAll(menuBox,rightSide);
            
            rightSide.getChildren().addAll(logoBannerBox, customerOrderBox);
            
            CustomerInfoBox();
            
            entireScene.getChildren().addAll(customerInfoBox,rightSide);
    });



    }
    
    /**
     * Create All Cost Box
     */
    public void createAllCostBox(){
        Label itemTotalLabel = new Label("Item Total:\t\t\t\t\t$");
        itemTotalLabel.setPrefWidth(350);
        calcTotalLabel = new Label(String.format("%8.2f",order.calculateOrderTotal()));

        calcTotalLabel.setAlignment(Pos.BASELINE_RIGHT);
        calcTotalLabel.setPrefWidth(100);

        HBox itemTotalBox = new HBox();
        itemTotalBox.getChildren().addAll(itemTotalLabel, calcTotalLabel);
        itemTotalBox.setId("runningTotal");
        itemTotalBox.setPadding(new Insets(5,0,0,0));

        Label taxLabel = new Label ("Tax Amount (6%):\t\t\t\t$");
        taxLabel.setPrefWidth(350);
        calcTaxLabel= new Label(String.format("%8.2f",order.calculateTaxAmount()));
        calcTaxLabel.setId("tax");
        calcTaxLabel.setAlignment(Pos.BASELINE_RIGHT);
        calcTaxLabel.setPrefWidth(100);

        HBox taxBox = new HBox();
        taxBox.getChildren().addAll(taxLabel, calcTaxLabel);



        Label deliveryFeeLabel = new Label("Delivery Fee (2%):\t\t\t\t$");
        deliveryFeeLabel.setPrefWidth(350);
        calcDeliveryFeeLabel= new Label(String.format("%8.2f",
                                            order.calculateDeliveryFeeAmount()));
        calcDeliveryFeeLabel.setId("delivery");
        calcDeliveryFeeLabel.setAlignment(Pos.BASELINE_RIGHT);
        calcDeliveryFeeLabel.setPrefWidth(100);

        HBox deliveryFeeBox = new HBox();
        deliveryFeeBox.getChildren().addAll(deliveryFeeLabel,  calcDeliveryFeeLabel);

        Label finalTotalLabel = new Label("Order Total:\t\t\t\t$");
        finalTotalLabel.setPrefWidth(350);
        finalTotalLabel.setPadding(new Insets(5,0,0,0));
        calcFinalTotalLabel= new Label(String.format("%8.2f",
                                            order.calculateFinalTotal()));
        calcFinalTotalLabel.setAlignment(Pos.BASELINE_RIGHT);
        calcFinalTotalLabel.setPrefWidth(100);
        calcFinalTotalLabel.setPadding(new Insets(5,0,0,0));

        HBox finalTotalBox = new HBox();
        finalTotalBox.getChildren().addAll(finalTotalLabel, calcFinalTotalLabel);
        finalTotalBox.setId("finalTotal");


        allCostBox = new VBox();
        allCostBox.getChildren().addAll(itemTotalBox, taxBox, deliveryFeeBox, finalTotalBox);
        allCostBox.setId("cartTotal");
        allCostBox.setSpacing(5);

    }
    
    /**
     * Create Order Details
     */
    public void createOrderDetails(){
        Label detailsLabel = new Label("Order Details");
        detailsLabel.setId("cart");
        detailsLabel.setPadding(new Insets(10, 0 , 10, 0));

        Label itemHead = new Label("Item");
        itemHead.setId("cartHead");
        itemHead.setPrefWidth(300);

        Label priceHead = new Label("Price");
        priceHead.setId("cartHead");
        priceHead.setPrefWidth(85);

        Label qtyHead = new Label ("Quantity");
        qtyHead.setId("cartHead");

        HBox headers = new HBox(itemHead, priceHead, qtyHead);
        headers.setPadding(new Insets(10, 0 , 10, 0));  

        orderDetails = new VBox();
        orderDetails.getChildren().addAll(detailsLabel, headers);
        orderDetails.setPrefHeight(375);   
    }

    
    /**
     * Create Item Box for Menu
     * @param list ArrayList of Category Menu Items
     * @param i index of item in list
     * @return individual item box
     */
    public HBox displayItemBox(ArrayList<ItemOnMenu> list, int i)
    {
        Label itemNameLabel = new Label();
        itemNameLabel.setText(list.get(i).getName());
        itemNameLabel.setPrefWidth(375);
        itemNameLabel.setId("headerItem");

        Label itemPriceLabel = new Label();
        itemPriceLabel.setText(String.format("$%8.2f",list.get(i).getPrice()));
        itemPriceLabel.setId("headerItem");

        //create HBox for name and price
        HBox itemNamePrice = new HBox (itemNameLabel, itemPriceLabel);
        itemNamePrice.setSpacing(100);

        ImageView itemPicture = new ImageView(list.get(i).getImage());
        itemPicture.setFitWidth(125);
        itemPicture.setPreserveRatio(true);

        Label itemDescriptionLabel = new Label();
        itemDescriptionLabel.setText(list.get(i).getDescription());
        itemDescriptionLabel.setPrefWidth(400);
        itemDescriptionLabel.setWrapText(true);
        itemDescriptionLabel.setId("description");


        VBox itemDescBox = new VBox(itemDescriptionLabel);
        itemDescBox.setAlignment(Pos.CENTER);

        //create HBox for name and price
        HBox itemPicDesc = new HBox (itemPicture, itemDescBox);
        itemPicDesc.setSpacing(20);

        VBox itemInfo = new VBox();
        itemInfo.getChildren().addAll(itemNamePrice,
                                itemPicDesc);
        itemInfo.setPrefWidth(575);

        Spinner quantity = createASpinner();

        VBox orderQtyBox = new VBox();
        orderQtyBox.getChildren().add(quantity);
        orderQtyBox.setAlignment(Pos.CENTER);

        Button clearField = clearItemButton();

        VBox itemActionsBox = new VBox();
        itemActionsBox.getChildren().addAll(clearField);
        itemActionsBox.setAlignment(Pos.CENTER);
        itemActionsBox.setSpacing(10);

        HBox itemBox = new HBox();
        itemBox.getChildren().addAll(itemInfo, orderQtyBox, itemActionsBox);

        itemBox.setSpacing(25);
       
        //make order list when spinner is clicked
        quantity.setOnMouseClicked(event -> 
        {
            order.makeOrderList();
            
            createItemsInOrderDisplay();
        });
        
                
        //create Button Action for Items
        clearField.setOnAction(event -> 
        {
            order.removeFromOrder(list.get(i), Integer.parseInt(quantity.getEditor().getText()));
            calcTotalLabel.setText(String.format("%8.2f", order.calculateOrderTotal()));
            calcTaxLabel.setText(String.format("%8.2f",order.calculateTaxAmount()));
            calcDeliveryFeeLabel.setText(String.format("%8.2f",
                                            order.calculateDeliveryFeeAmount()));
            calcFinalTotalLabel.setText(String.format("%8.2f",
                                            order.calculateFinalTotal()));

            order.makeOrderList();
                       
            createItemsInOrderDisplay();

            quantity.getValueFactory().setValue(0);
        });
        
        //listener for value change in spinner
        quantity.valueProperty().addListener((ObservableValue o, 
                                 Object oldValue, Object newValue) -> {
            int oldQty= Integer.parseInt(oldValue.toString());
            int newQty= Integer.parseInt(newValue.toString());
            
            if (newQty > oldQty)
            {
                
                order.addToOrder(list.get(i), 1);
                calcTotalLabel.setText(String.format("%8.2f", 
                                        order.calculateOrderTotal()));
                calcTaxLabel.setText(String.format("%8.2f",
                                        order.calculateTaxAmount()));
                calcDeliveryFeeLabel.setText(String.format("%8.2f",
                                        order.calculateDeliveryFeeAmount()));
                calcFinalTotalLabel.setText(String.format("%8.2f",
                                        order.calculateFinalTotal()));
            }
            
            else
            {
                order.removeFromOrder(list.get(i), 1);
                calcTotalLabel.setText(String.format("%8.2f", 
                                        order.calculateOrderTotal()));
                calcTaxLabel.setText(String.format("%8.2f",
                                        order.calculateTaxAmount()));
                calcDeliveryFeeLabel.setText(String.format("%8.2f",
                                        order.calculateDeliveryFeeAmount()));
                calcFinalTotalLabel.setText(String.format("%8.2f",
                                        order.calculateFinalTotal()));
            }
            
            //disable checkout and edit existing order buttons if order is empty
            if(order.getOrderItems().isEmpty())
            {
                checkOut.setDisable(true);
                editExistingOrder.setDisable(true);
            }
            
            else
            {
                checkOut.setDisable(false);
                editExistingOrder.setDisable(false);
            }
        });
        
        //return item box
        return itemBox;
    }
    
    /**
     * Create Items In Order Display
     */
    public void createItemsInOrderDisplay(){
    orderDetails.getChildren().remove(details);
    
    details = new VBox();
    details.setPrefHeight(300);
    
    HBox detailCopy;
    
    for (int index = 0; index< order.getNamesInOrder().size(); index++ )
    {
        detailCopy=createItemNameQtyBox(index);
        details.getChildren().add(detailCopy);
        
    }
    
    orderDetails.getChildren().addAll(details);

}
    
    /**
     * Create Item Name and Qty Box
     * @param index of Item in Order
     * @return Item Name Qty Box
     */
    public HBox createItemNameQtyBox(int index){
        itemsEachOrdered = new HBox();

        Label itemName = new Label();
        itemName.setText(order.getNamesInOrder().get(index));
        itemName.setPrefWidth(275);

        Label itemPrice = new Label();
        itemPrice.setText((String.format("$%8.2f",
                order.getPrice(order.getNamesInOrder().get(index)))));
        itemPrice.setPrefWidth(85);

        Label itemQty= new Label();
        itemQty.setText(String.format("%5d", order.getQuantitiesInOrder().get(index)));

        itemsEachOrdered.getChildren().addAll(itemName, itemPrice, itemQty);
        itemsEachOrdered.setSpacing(20);
        itemsEachOrdered.setId("details");
        return itemsEachOrdered;

    }
    
    /**
    * Create LogoBox
    */
    public void buildLogoBox(){
        //create logo box
        Image logoImage = new Image("/pnglogo.png");
        ImageView logoView = new ImageView(logoImage);
        logoView.setId("logoView");

        //adjust the size
        logoView.setFitWidth(500);
        logoView.setPreserveRatio(true);

        //create logo and add children
        logoBannerBox = new VBox();
        logoBannerBox.getChildren().addAll(logoView);

        //set alignment and padding
        logoBannerBox.setAlignment(Pos.CENTER);
        logoBannerBox.setPadding(new Insets(10));
    }
    
    /**
     * Build Restaurant Menu
     * @throws InvalidInputException 
     */
    private void buildRestaurantMenu() throws InvalidInputException{
       fullMenu = new RestaurantMenu(); 
    }
    
    /**
     * Menu Box
     */
    public void MenuBox(){
        //create Button Box
        createCategoryButtonsBox();
        
        //Create entrees Box
        createEntreesArrayBox();
        
        //create sides Box
        createSidesArrayBox();
        
        //create desserts box
        createDessertsArrayBox();
        
        //create soft drinks box
        createSoftDrinksArrayBox();
        
        //create Category Button Actions
        setCategoryButtonActions();
        
        
        menuBox = new VBox();
        menuBox.getChildren().addAll(categoryButtonsBox, entreesScroll);
        menuBox.setSpacing(10);
    }
    
    /**
     * Create a Clear Item Button
     * @return a clearItem button
     */
    public Button clearItemButton(){
        clearItem = new Button("Remove");
        clearItem.setId("clear");


        return clearItem;
    }
    
    /**
     * Create a spinner
     * @return spinner
     */
    public Spinner createASpinner(){
        Spinner <Integer> itemSpinner = new Spinner(0, 20, 0, 1);
        
        itemSpinner.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL);
        itemSpinner.setPrefSize(50, 75);
        itemSpinner.setId("quantity");
        
        return itemSpinner;
    }
    
    /**
     * Create Entrees Array Box
     */
    public void createEntreesArrayBox(){
        VBox entreeMenuItems = new VBox();
        
        //loop through entrees array list to make the menu 
        for (int index = 0; index< fullMenu.getEntreeMenuItems().size(); index++)
            {
                entreeMenuItems.getChildren().addAll(displayItemBox(fullMenu.getEntreeMenuItems(), index));
            }  

        entreeMenuItems.setPadding(new Insets(15, 10, 0, 20));
        entreeMenuItems.setSpacing(20);
        
        //add to scroll pane
        entreesScroll = new ScrollPane(entreeMenuItems);
        entreesScroll.setPrefViewportHeight(685);
        
    }

    /**
     * Create Sides Array Box
     */
    public void createSidesArrayBox(){
        VBox sidesMenuItems = new VBox();

        //loop through sides array list to make the menu 
        for (int index = 0; index< fullMenu.getSidesMenuItems().size(); index++)
            {
                sidesMenuItems.getChildren().addAll(displayItemBox(fullMenu.getSidesMenuItems(), index));
            }  

        sidesMenuItems.setPadding(new Insets(15, 10, 0, 20));
        sidesMenuItems.setSpacing(20);
        
        //add to scroll pane
        sidesScroll = new ScrollPane(sidesMenuItems);
        sidesScroll.setPrefViewportHeight(685);
    }

    /**
     * Create Desserts Array Box
     */
    public void createDessertsArrayBox(){
        VBox dessertsMenuItems = new VBox();
        
        //loop through desserts array list to make the menu 
        for (int index = 0; index< fullMenu.getDessertsMenuItems().size(); index++)
            {
                dessertsMenuItems.getChildren().addAll(displayItemBox(fullMenu.getDessertsMenuItems(), index));
            }  

        dessertsMenuItems.setPadding(new Insets(15, 10, 0, 20));
        dessertsMenuItems.setSpacing(20);
        
        //add to scroll pane
        dessertsScroll = new ScrollPane(dessertsMenuItems);
        dessertsScroll.setPrefViewportHeight(685);
        
    }

    /**
     * Create Soft Drinks Array Box
     */
    public void createSoftDrinksArrayBox(){
        VBox softDrinksMenuItems = new VBox();

        //loop through soft drinks array list to make the menu 
        for (int index = 0; index< fullMenu.getSoftDrinksMenuItems().size(); index++)
            {
                softDrinksMenuItems.getChildren().addAll(displayItemBox(fullMenu.getSoftDrinksMenuItems(), index));
            }  

        softDrinksMenuItems.setPadding(new Insets(15, 10, 0, 20));
        softDrinksMenuItems.setSpacing(20);
        
        //add to scroll pane
        softDrinksScroll = new ScrollPane(softDrinksMenuItems);
        softDrinksScroll.setPrefViewportHeight(685);
    }

    /**
     * Create Category Buttons Box
     */
    public void createCategoryButtonsBox(){
        entreesBtn = new Button("Entrees");
        entreesBtn.setId("activeChoice");
        entreesBtn.setPrefSize(200, 30);

        sidesBtn = new Button("Sides");
        sidesBtn.setId("categoryBtn");
        sidesBtn.setPrefSize(200, 30);

        dessertsBtn = new Button("Desserts");
        dessertsBtn.setId("categoryBtn");
        dessertsBtn.setPrefSize(200, 30);

        softDrinksBtn = new Button("Soft Drinks");
        softDrinksBtn.setId("categoryBtn");
        softDrinksBtn.setPrefSize(200, 30);


        categoryButtonsBox = new HBox();
        categoryButtonsBox.getChildren().addAll(entreesBtn, sidesBtn,
                                                dessertsBtn, softDrinksBtn);
        categoryButtonsBox.setSpacing(5);
        categoryButtonsBox.setPadding(new Insets(30, 10, 0, 0));
     }
 
    /**
     * Create Category Button Actions
     */
    public void setCategoryButtonActions(){
        //set actions for buttons
        entreesBtn.setOnAction(event -> 
          {
              menuBox.getChildren().removeAll(entreesScroll, sidesScroll, 
                                               dessertsScroll, softDrinksScroll);
              menuBox.getChildren().add(entreesScroll); 
              entreesBtn.setId("activeChoice");
              sidesBtn.setId("categoryBtn");
              dessertsBtn.setId("categoryBtn");
              softDrinksBtn.setId("categoryBtn");
          });

        sidesBtn.setOnAction(event -> 
          { 

              menuBox.getChildren().removeAll(entreesScroll, sidesScroll, 
                                               dessertsScroll, softDrinksScroll);
              menuBox.getChildren().add(sidesScroll);
              entreesBtn.setId("categoryBtn");
              sidesBtn.setId("activeChoice");
              dessertsBtn.setId("categoryBtn");
              softDrinksBtn.setId("categoryBtn");
          });

        dessertsBtn.setOnAction(event -> 
          {
             menuBox.getChildren().removeAll(entreesScroll, sidesScroll, 
                                               dessertsScroll, softDrinksScroll);
              menuBox.getChildren().add(dessertsScroll);
              entreesBtn.setId("categoryBtn");
              sidesBtn.setId("categoryBtn");
              dessertsBtn.setId("activeChoice");
              softDrinksBtn.setId("categoryBtn");
          });

        softDrinksBtn.setOnAction(event -> 
          {
              menuBox.getChildren().removeAll(entreesScroll, sidesScroll, 
                                               dessertsScroll, softDrinksScroll);
              menuBox.getChildren().add(softDrinksScroll);
              entreesBtn.setId("categoryBtn");
              sidesBtn.setId("categoryBtn");
              dessertsBtn.setId("categoryBtn");
              softDrinksBtn.setId("activeChoice");
          });
   }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}