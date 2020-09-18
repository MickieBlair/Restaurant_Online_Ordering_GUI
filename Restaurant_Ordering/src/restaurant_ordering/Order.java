//Fast Happy Foods
//Order 
/**
 *
 * @author blair
 */

package restaurant_ordering;

import java.util.ArrayList;

public class Order {
    private ArrayList <ItemOnMenu> orderItems;
    private ArrayList<String> itemNameQty;
    private ArrayList<String> names;
    private ArrayList<Integer> numOfItems;
    private final double TAX = .06;
    private final double DELIVERY = .02;
      
    /**
     * Constructor - no args
     */
    Order(){
        this.orderItems = new ArrayList<>();
        this.itemNameQty = new ArrayList<>();
        this.names = new ArrayList<>();
        this.numOfItems = new ArrayList<>();
        
    }
    
    /**
     * Add To Order
     * @param item
     * @param qty 
     */
    public void addToOrder(ItemOnMenu item, int qty){
        for (int index = 0; index < qty; index++)
        {
           orderItems.add(item); 
           
        }
    }
    
    /**
     * Remove From Order
     * @param item
     * @param qty 
     */
    public void removeFromOrder(ItemOnMenu item, int qty){
        for (int index = 0; index < qty; index++)
        {
           orderItems.remove(item); 
        }
    }
    
    /**
     * Calculate Item Total
     * @param num 
     * @return Item Total
     */
    public double calculateItemTotal(int num){
        double itemTotal = 0;
        
        for (int index = 0; index < num; index++)
        {
            itemTotal += this.orderItems.get(index).getPrice();
        }
               
        return itemTotal;
    }
    
    /**
     * CalculateOrderTotal
     * @return order total
     */    
    public double calculateOrderTotal(){
        double runningTotal = 0;
        
        for (int index = 0; index < this.orderItems.size(); index++)
        {
            runningTotal += this.orderItems.get(index).getPrice();
        }
        
        return runningTotal;
    }
    
    /**
     * CalculateTaxAmount
     * @return Tax Amount
     */
    public double calculateTaxAmount(){
        double tax;
        
        tax = calculateOrderTotal()* TAX;
        
        return tax;
    }
    
    /**
     * Calculate Final Total
     * @return Final Total
     */
    public double calculateFinalTotal(){
        double finalTotal;
        
        finalTotal = calculateOrderTotal() + calculateTaxAmount() + calculateDeliveryFeeAmount();
        
        return finalTotal;
    }
    
    /**
     * Calculate DeliveryFeeAmount
     * @return Delivery Fee Amount
     */
    public double calculateDeliveryFeeAmount(){
        double delivery;
        
        delivery = calculateOrderTotal()* DELIVERY;
                        
        return delivery;
    }
    
    /**
     * Get Order Items
     * @return Order Items
     */    
    public ArrayList<ItemOnMenu> getOrderItems(){
        
        return this.orderItems;
    }
    
    /**
     * Make Order Lists
     */
    public void makeOrderList(){
        this.names = new ArrayList<>();
        this.numOfItems = new ArrayList<>();  
        
        //loop through list to get the names in the order with no duplicates
        for (int index = 0; index < this.orderItems.size(); index++)
        {
            if (index == 0)
            {
                this.names.add(this.orderItems.get(index).getName());
            }
            else
            {
                for (int i = 0; i< this.names.size(); i++)
                {
                    if(!this.names.contains(this.orderItems.get(index).getName()))
                            {
                              this.names.add(this.orderItems.get(index).getName());  
                            }
                }
            }
        }
        
        
        //loop through the names list and count each item and store in the quanity array list
        int count;
         
        for (int index = 0; index < this.names.size(); index++ )
        {
            count = 0;
                      
             for (int i = 0; i < this.orderItems.size(); i++)
             {
                 if (this.names.get(index).equals(this.orderItems.get(i).getName()))
                 {
                     count++;
                 }

             }
             this.numOfItems.add(count);

        }       
    }
    
    /**
     * Clear Order List of names and quantities
     */
    public void clearOrderList(){
        this.names.clear();
        this.numOfItems.clear();
        
    }
    
    /**
     * Get Names in Order
     * @return Names in Order
     */
    public ArrayList<String> getNamesInOrder(){  
        return this.names;
    }
    
    /**
     * Get Quantities In Order
     * @return Quantities In Order
     */
    public ArrayList<Integer> getQuantitiesInOrder(){      
        return this.numOfItems;
    }
    
    /**
     * Get Price
     * @param str Name of Item
     * @return Price of Item
     */
    public double getPrice(String str){
        boolean isFound = false;
        double price = 0;
        int index =0 ;
        while (!isFound){
        
            if (this.orderItems.get(index).getName().equals(str))
            {
                price = this.orderItems.get(index).getPrice();
                isFound = true;
            }
            index++; 
        }
                   
        return price;
    } 
}

