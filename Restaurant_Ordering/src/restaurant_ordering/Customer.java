//Fast Happy Foods
//Customer Class
/**
 *
 * @author blair
 */

package restaurant_ordering;

import static restaurant_ordering.ValidateEmail.validateEmailFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Customer {
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;
     
    /**
     * Constructor - No args     * 
     */
    Customer(){
    this.address1 = "";
    this.address2 = "";
    this.city = "";
    this.state = "";
    this.zip = "";
    this.phone = "";
    this.email = "";
    }
    
        
    /**
     * Set Address Line 1
     * @param line1
     * @throws InvalidInputException 
     */  
    public void setAddressLine1(String line1) throws InvalidInputException{
        
        if (line1.equals(""))
            {
                throw new InvalidInputException("Address (Required)");
               
            }
        else
            this.address1 = line1;
    }
    
    /**
     * Set Address Line 2
     * @param line2 
     */
    public void setAddressLine2(String line2){
        this.address2 = line2;
    }
    
    /**
     * Set City
     * @param c City
     * @throws InvalidInputException 
     */
    public void setCity(String c) throws InvalidInputException{
        if (c.equals(""))
            {
                throw new InvalidInputException("City (Required)");
               
            }
        else 
            this.city = c;
    }
    
    /**
     * Set State
     * @param s State
     * @throws InvalidInputException 
     */
    public void setState(Object s) throws InvalidInputException{
        if (s==null)
            {
                throw new InvalidInputException("State (Required)");
               
            }
        else
            this.state = (String)s;
    }
    
    /**
     * Set Zip Code
     * @param z Zip Code
     * @throws InvalidInputException 
     */
    public void setZip(String z) throws InvalidInputException{
        if (z.equals(""))
            {
                throw new InvalidInputException("ZIP Code (Required)");
               
            }
        else        
            this.zip = z;
    }
    
    /**
     * Set Phone
     * @param p Phone
     * @throws InvalidInputException 
     */
    public void setPhone(String p) throws InvalidInputException{
        if (p.equals(""))
            {
                throw new InvalidInputException("Phone (Required)");
            }
        else 
            this.phone = p;
    }
    
    /**
     * Set Email
     * @param e Email
     * @throws InvalidInputException 
     */
    public void setEmail(String e) throws InvalidInputException{
       this.email= validateEmailFormat(e);
     }
        
    /**
     * Get Address Line1
     * @return Address Line 1
     */
    public String getAddressLine1(){
        return this.address1;
    }
    
    /**
     * Get Address Line2
     * @return Address Line 2
     */
    public String getAddressLine2(){
        return this.address2;
    }
    
    /**
     * Get City
     * @return City
     */
    public String getCity(){
        return this.city;
    }
   
    /**
     * Get State
     * @return State
     */
    public String getState(){
        return this.state;
    }
    
    /**
     * Get Zip Code
     * @return Zip Code
     */
    public String getZip(){
        return this.zip;
    }
    
    /**
     * Get Phone
     * @return Phone
     */
    public String getPhone(){
        return this.phone;
    }
    
    /**
     * Get Email
     * @return Email
     */
    public String getEmail(){
        return this.email;
    }
    
    static ObservableList populateStateComboBox(){
    String [] stateArray = new String[]{"AL", "AK", "AZ", "AR", "CA",
                                        "CO", "CT", "DE", "FL", "GA",
                                        "HI", "ID", "IL", "IN", "IA",
                                        "KS", "KY", "LA", "ME", "MD",
                                        "MA", "MI", "MN", "MS", "MO",
                                        "MT", "NE", "NV", "NH", "NJ",
                                        "NM", "NY", "NC", "ND", "OH",
                                        "OK", "OR", "PA", "RI", "SC",
                                        "SD", "TN", "TX", "UT", "VT",
                                        "VA", "WA", "WV", "WI", "WY",
                                        };
    
    ObservableList state = FXCollections.observableArrayList(stateArray);
  
    return state; 
    
}
    
    @Override
    public String toString(){
        String str;
        
        str = String.format("%s\n%s\n%s, %s %s\n%s\n%s",
                             this.address1, this.address2, this.city, this.state,
                             this.zip, this.phone, this.email);
        
        return str;
    }
    
}

