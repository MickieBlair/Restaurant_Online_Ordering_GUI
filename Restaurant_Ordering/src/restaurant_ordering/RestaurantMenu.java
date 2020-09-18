//Fast Happy Foods
//Menu Class
/**
 *
 * @author blair
 */
package restaurant_ordering;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class RestaurantMenu {
    
    ArrayList <String> categoryArrayList;       //arrayList for categories
    ArrayList <ItemOnMenu> menuItemsArrayList;    //arrayList for menuItems
    ArrayList <ItemOnMenu> entreesArrayList;      //entrees arrayList
    ArrayList <ItemOnMenu> sidesArrayList;        //sides arrayList
    ArrayList <ItemOnMenu> dessertsArrayList;     //desserts arrayList
    ArrayList <ItemOnMenu> softDrinksArrayList;   //soft drinks arrayList
    
    /**
     * Constructor - no Args
     */
    RestaurantMenu () throws InvalidInputException{
        populateCategoryArrayList();
        populateAllMenuItems();
        populateCategoryArrayLists();
    }
    
    /**
     * PopulateCategoryArrayList
     */
    private void populateCategoryArrayList(){
        this.categoryArrayList = new ArrayList<>(); 
    
        //populate ArrayList
        categoryArrayList.add("Entrees");
        categoryArrayList.add("Sides");
        categoryArrayList.add("Desserts");
        categoryArrayList.add("Soft Drinks");
    }
    
    /**
     * Get Observable CategoryList
     * @return Observable CategoryList
     */
    public ObservableList getObservableCategoryList(){
        ObservableList <String> categoryList
                = FXCollections.observableArrayList(this.categoryArrayList);
        
        return categoryList;
    }
    
    /**
     * Populate All RestaurantMenu Items
     * @throws InvalidInputException 
     */
    private void populateAllMenuItems() throws InvalidInputException{
        //create of list of all items
        this.menuItemsArrayList = new ArrayList<>();

       //populate the array list with items
       //MooBurger
       Image mooBurgerImage = new Image("/mooburger.jpg");
       ItemOnMenu mooBurger = new ItemOnMenu("Moo Burger", "Our thick 'n hearty "
               + "burger on a toasted bakery bun. Served with lettuce, tomato,"
               + " onion and pickles.", 8.95,
           mooBurgerImage, "Entrees"); 
       this.menuItemsArrayList.add(mooBurger);

       //lets play chicken
       Image letsPlayImage = new Image("/letsplaychicken.jpg");
       ItemOnMenu letsPlayChicken = new ItemOnMenu("Let's Play Chicken Sandwhich",
           "This crispy chicken breast sandwich is served with fresh iceberg "
                   + "lettuce, juicy tomatoes, red onion and pickles.", 9.95,
           letsPlayImage, "Entrees"); 
       this.menuItemsArrayList.add(letsPlayChicken);

       //lets play chicken
       Image nuggetsImage = new Image("/struckgoldnuggest.jpg");
       ItemOnMenu struckGoldNuggets = new ItemOnMenu("Struck Gold Chicken Nuggets",
           "A Parmesan crust lifts these chicken nibbles above the ordinary. "
                   + "Serve alone or with an array of dipping sauces.", 7.95,
           nuggetsImage, "Entrees"); 
       this.menuItemsArrayList.add(struckGoldNuggets);

       //it was you alfredo
       Image alfredoImage = new Image("/itwasyoualfredo.jpg");
       ItemOnMenu itWasYouAlfredo = new ItemOnMenu("It Was You Alfredo",
           "A dish of fettuccine tossed with butter and Parmesan cheese. "
                   + "Creamy, comforting, absolutely delicious!", 8.95,
           alfredoImage, "Entrees"); 
       this.menuItemsArrayList.add(itWasYouAlfredo);

       //J. Paul spaghetti
       Image spaghettiImage = new Image("/jpaulspaghetti.jpg");
       ItemOnMenu jPaulSpaghetti = new ItemOnMenu("J. Paul Spaghetti",
           "A delicious mariana sauce with red wine, garlic and onions served "
                   + "over a heaping plate of pasta.",6.95,
           spaghettiImage, "Entrees"); 
       this.menuItemsArrayList.add(jPaulSpaghetti);

       //Six, Fries, and Videotape
       Image friesImage = new Image("/sixfriesvideotape.jpg");
       ItemOnMenu sixFriesVideotape = new ItemOnMenu("Six, Fries, and Videotape",
           "Our signature piping hot, Salted French Fries "
                   + "are golden on the outside and fluffy on the inside.",2.95,
           friesImage, "Sides"); 
       this.menuItemsArrayList.add(sixFriesVideotape);

       //Make a Wedge
       Image wedgeImage = new Image("/makeawedge.jpg");
       ItemOnMenu makeAWedge = new ItemOnMenu("Make a Wedge",
           "Oven baked potatoes seasoned with our secret "
                   + "blend of spices and double hand-breaded.",3.95,
           wedgeImage, "Sides"); 
       this.menuItemsArrayList.add(makeAWedge);

       //Go To Townie Brownie
       Image brownieImage = new Image("/gototowniebrownie.jpg");
       ItemOnMenu goToTownieBrownie = new ItemOnMenu("Go To Townie Brownie",
           "Made with lots of dark chocolate giving this brownie a rich,"
                   + " gooey texture. Chocoholics will love this!",3.95,
           brownieImage, "Desserts"); 
       this.menuItemsArrayList.add(goToTownieBrownie);

       //Shake Shake Shake
       Image shakeImage = new Image("/shakes.jpg");
       ItemOnMenu shakeShakeShake = new ItemOnMenu("Shake Shake Shake",
           "Our Classic Creamy Shakes topped with whipped cream. Choose from"
                   + " chocolate, vanilla, strawberry." ,3.95,
           shakeImage, "Desserts"); 
       this.menuItemsArrayList.add(shakeShakeShake);

       //Coke Sprite
       Image cokeSpriteImage = new Image("/coke.jpg");
       ItemOnMenu cokeSprite = new ItemOnMenu("Coke, Sprite",
           "Cool refreshing soft drinks. Choose from"
                   + " Coke or Sprite" ,1.95,
           cokeSpriteImage, "Soft Drinks"); 
       this.menuItemsArrayList.add(cokeSprite);

       //Coke Sprite
       Image teaImage = new Image("/icetea.jpg");
       ItemOnMenu icedTea = new ItemOnMenu("Iced Tea",
           "Homemade Daily and delicious." ,1.95,
           teaImage, "Soft Drinks"); 
       this.menuItemsArrayList.add(icedTea);

    }
    
    /**
     * Get All RestaurantMenu Items
     * @return menuItemsArrayList
     */
    public ArrayList getAllMenuItems(){
        return this.menuItemsArrayList;
    }
    
    /**
     * Get Entrees RestaurantMenu Items
     * @return entreesArrayList
     */
    public ArrayList getEntreeMenuItems(){
        return this.entreesArrayList;
    }
    
    /**
     * Get Sides RestaurantMenu Items
     * @return sidesArrayList
     */
    public ArrayList getSidesMenuItems(){
        return this.sidesArrayList;
    }
    
    /**
     * Get Desserts RestaurantMenu Items
     * @return dessertsArrayList
     */
    public ArrayList getDessertsMenuItems(){
        return this.dessertsArrayList;
    }
    
     /**
     * Get Soft Drinks RestaurantMenu Items
     * @return softDrinksArrayList
     */
    public ArrayList getSoftDrinksMenuItems(){
        return this.softDrinksArrayList;
    }
 
    /**
     * Populate Category Array Lists
     */
    private void populateCategoryArrayLists(){
        //create of list for category items items
        this.entreesArrayList = new ArrayList<>();
        this.sidesArrayList = new ArrayList<>();
        this.dessertsArrayList = new ArrayList<>();
        this.softDrinksArrayList = new ArrayList<>();

        for (int index = 0; index< this.menuItemsArrayList.size(); index++)
        {

            switch (this.menuItemsArrayList.get(index).getCategory()) {
                case "Entrees":
                    this.entreesArrayList.add(this.menuItemsArrayList.get(index));
                    break;
                case "Sides":
                    this.sidesArrayList.add(this.menuItemsArrayList.get(index));
                    break;
                case "Desserts":
                    this.dessertsArrayList.add(this.menuItemsArrayList.get(index));
                    break;
                case "Soft Drinks":
                    this.softDrinksArrayList.add(this.menuItemsArrayList.get(index));
                    break;
                default:
                    break;
            }
        }
     }  
    
    /**
     * Add Item to RestaurantMenu
     * @param newItem 
     */
    public void addItemToMenu(ItemOnMenu newItem){
       this.menuItemsArrayList.add(newItem);
            
       switch (newItem.getCategory()) {
            case "Entrees":
                this.entreesArrayList.add(newItem);
                break;
            case "Sides":
                this.sidesArrayList.add(newItem);
                break;
            case "Desserts":
                this.dessertsArrayList.add(newItem);
                break;
            case "Soft Drinks":
                this.softDrinksArrayList.add(newItem);
                break;
            default:
                break;
        }
    }
}   

