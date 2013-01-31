package de.travelbasys.training.util.widgets;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
/**
* @author Sai Pradeep Dandem
*/

public class DateFormatValidator{
 
  private Pattern pattern;
  private Matcher matcher;
 
  private static final String DATE_PATTERN = 
          "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
 
  public DateFormatValidator(){
	  pattern = Pattern.compile(DATE_PATTERN);
  }
 
  /**
   * Validate date format with regular expression
   * @param date date address for validation
   * @return true valid date fromat, false invalid date format
   */
   public boolean isValid(final String date){
 
     matcher = pattern.matcher(date);
 
     if(matcher.matches()){
 
	 matcher.reset();
 
	 if(matcher.find()){
 
             String day = matcher.group(1);
	     String month = matcher.group(2);
	     int year = Integer.parseInt(matcher.group(3));
 
	     if (day.equals("31") && 
		  (month.equals("4") || month .equals("6") || month.equals("9") ||
                  month.equals("11") || month.equals("04") || month .equals("06") ||
                  month.equals("09"))) {
			return false; // only 1,3,5,7,8,10,12 has 31 days
	     } else if (month.equals("2") || month.equals("02")) {
                  //leap year
		  if(year % 4==0){
			  if(day.equals("30") || day.equals("31")){
				  return false;
			  }else{
				  return true;
			  }
		  }else{
		         if(day.equals("29")||day.equals("30")||day.equals("31")){
				  return false;
		         }else{
				  return true;
			  }
		  }
	      }else{				 
		return true;				 
	      }
	   }else{
    	      return false;
	   }		  
     }else{
	  return false;
     }			    
   }
}