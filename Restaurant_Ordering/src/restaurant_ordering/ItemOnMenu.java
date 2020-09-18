//Fast Happy Foods
//Item On Menu Class
/**
 *
 * @author blair
 */


package restaurant_ordering;

import javafx.scene.image.Image;

public class ItemOnMenu {
    
    private String name;
    private String description;
    private double price;
    private Image image;
    private String category;
    
    //constructor
    ItemOnMenu(){
        this.name ="";
        this.description = "";
        this.price = 0.00;
        this.image = null;
        this.category ="";
    }
    
    /**
     * Constructor with Item Information
     * @param n Item Name
     * @param d Item Description
     * @param p Item Price
     * @param im Item Item
     * @param c  Item Category
     */
    ItemOnMenu(String n, String d, double p, Image im, String c){
        this.name =n;
        this.description = d;
        this.price = p;
        this.image = im;
        this.category = c;
    }
        
    /**
     * Set Name
     * @param n Name 
     * @throws InvalidInputException 
     */
    public void setName(String n) throws InvalidInputException{
        
        if(n.equals("") )
        {
            throw new InvalidInputException("Name (Required)");
        }
        else
        {
            this.name = n; 
        } 
    }
    
    /**
     * Set Description
     * @param d description
     * @throws InvalidInputException
     */
    public void setDescription(String d) throws InvalidInputException{
        if(d.equals("") )
        {
            throw new InvalidInputException("Description (Required)");
        }
        else
        {
            this.description = d; 
        } 
    }
    
    /**
     * Set Price
     * @param p Price
     * @throws InvalidInputException
     */
    public void setPrice(double p) throws InvalidInputException{
        if(p == 0)
        {
            throw new InvalidInputException("Item Price (Required) - Must greater than 0.00");
        }
        else if(p < 0.00)
        {
            throw new InvalidInputException("Item price must greater than 0.00");
        }
        else
        {
            this.price = p; 
        }   
    }
    
    /**
     * Set Image
     * @param im Image
     * @throws InvalidInputException
     */
    public void setImage(Image im) throws InvalidInputException{
        if(im == null)
        {
            throw new InvalidInputException("Item Image(Required)");
        }
        else
        {
            this.image = im; 
        }
    }
    
    /**
     * Set Category
     * @param c Category
     * @throws InvalidInputException
     */
    public void setCategory(String c) throws InvalidInputException{
        if(c==null)
        {
            throw new InvalidInputException("Category (Required)");
        }
        else
        {
          this.category = c;  
        }  
    }
    
    /**
     * Get Name
     * @return Name
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Get Description
     * @return Description
     */
    public String getDescription(){
        return this.description;
    }
    
    /**
     * Get Price
     * @return Price
     */
    public double getPrice(){
        return this.price;
    }
        
    /**
     * Get Image
     * @return Image
     */
    public Image getImage(){
        return this.image;
    }
    
    /**
     * Get Category
     * @return Category
     */
    public String getCategory(){
        return this.category;
    }
    
    /**
     * Get Menu Item
     * @return Menu Item
     */
    public ItemOnMenu getMenuItem(){
        ItemOnMenu copy = new ItemOnMenu();
        copy.category = this.category;
        copy.name = this.name;
        copy.description = this.description;
        copy.image = this.image;
        
        return copy; 
    }
    
    @Override
    public String toString(){
        String str;
        
        str = String.format("%-15s%s\n\n%-15s\n%s\n\n%-15s$%6.2f\n\n",
                             "Name:", this.name,
                             "Description:", this.description,
                             "Price:", this.price);
        
        return str;
    }
    
}


