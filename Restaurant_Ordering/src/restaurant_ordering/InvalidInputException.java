//Fast Happy Foods
//Invalid Input Exception
/**
 *
 * @author blair
 */


package restaurant_ordering;

public class InvalidInputException extends Exception{
    
    /**
     * Constructor - No Args
     */
    InvalidInputException(){
       super();
        
    }
    
    /**
     * Constructor with message
     * @param m Message
     */
    InvalidInputException(String m){
        super(m);
    }
}