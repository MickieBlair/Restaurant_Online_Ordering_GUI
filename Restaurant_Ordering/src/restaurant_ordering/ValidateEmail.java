//Fast Happy Foods
//Validate Email Class
/**
 *
 * @author blair
 */

package restaurant_ordering;

public class ValidateEmail {
        
    public static String validateEmailFormat(String e) throws InvalidInputException {
       char [] emailAddress = e.toCharArray();
       boolean hasOneAt = false;
       boolean period = false;
       boolean order = false;
       boolean ending = true;
       
       int atCount = 0;
       int periodCount =0;
       int atIndex = 0;
       int lastPeriodIndex = 0;
       
       String beginning;
       String middle;
       String end;
       char [] endArray;
       int endIndex = 0;
       
       
       String errorMessage = "";
       
       
       //throw exception if empty
       if (e.equals(""))
            {
                throw new InvalidInputException("");
               
            }
       
       //get the index of the @ symbol and the last period
       for (int index = 0; index<emailAddress.length; index++)
       {
            if (emailAddress[index] == '@')
            {
                atCount++;
                atIndex = index;
            }

            else if (emailAddress[index] == '.')
            {
                periodCount++;
                lastPeriodIndex = index;
            }
        } 
        
       //adding error message for @ count
        if (atCount == 1)
            {
            hasOneAt = true;
            }
            else
            {
                if (atCount == 0)
                    errorMessage +="- Must contain one @ symbol\n";
                else
                    errorMessage +="- Must contain only one @ symbol\n";
                
            }
        
        //adding messages for period count
        if (periodCount > 0)
            {
                period = true;
            }
        
            else
            {
                errorMessage +="- Must contain at least one period\n";
            }
        
        
         //adding to error message for order if both @ and period true 
          
         if (hasOneAt && period)
         {
             if (atIndex < lastPeriodIndex)
                {
                    order = true;
                }

            else
                {
                    errorMessage +="- @ symbol must be before .xxx\n";
                }
             
         }
            
        //if @, period and order are all true, split the input into substrings
        //and validate each part
        
            if (hasOneAt && period & order)
            {
                beginning = e.substring(0, atIndex);
                middle = e.substring(atIndex+1, lastPeriodIndex);
                end = e.substring(lastPeriodIndex+1);
                                
                //check for character before the @
                if(beginning.length() < 1)
                {
                    errorMessage +="- At least one character must appear before @\n";
                }

                //check for character before the last period
                if(middle.length() < 1)
                {
                    errorMessage +="- At least one character must appear before "
                            + "the .xxx extension\n";
                }

                //check for character after the last period and verify only three letters
                if(end.length()!=3)
                {
                    ending = false;
                    errorMessage +="- .xxx extension should be three letters long\n";
                }
                else
                {
                 endArray = end.toCharArray();

                    while (endIndex < endArray.length){
                       if (!Character.isLetter(endArray[endIndex]))
                       {
                           ending = false;
                           
                           System.out.println(ending);
                           

                       }
                       endIndex++;
                    }
                    
                    if (!ending)
                    {
                      errorMessage +="- .xxx extension should be "
                                   + "letters only\n";  
                    }
                    
                }
            }

            //if all are valid return validated email
            if (hasOneAt && period && order && ending)

            {
              return e; 
            }

            else
            {
                errorMessage+="\nValid Email Format: name@domain.xxx";
                throw new InvalidInputException(errorMessage);  
            } 
       
    }
   
}


