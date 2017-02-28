package edu.vccs.email.jka29662.andyLab2;

import edu.brcc.maxfieldj.ch21Lab1a.RPNCalc;

/**
 * this class has the logic handling all of the calculator keys. no GUI code
 * moves logic specific to GUI away from the actual GUI code
 * 2015-02-07
 * @author Joey Arbogast
 *
 */
public class RPNCalcGUIHelper
{
  // the string that is returned for the user to see
  private StringBuilder display;    
  
  private boolean isNumberEntryFinished;   // current num is completely entered
  private RPNCalc calc = new RPNCalc();    // MVC controller object

  /**
   * no-arg constructor. initialize display attributes
   */
  public RPNCalcGUIHelper()
  {
    setDisplay("");
    isNumberEntryFinished = true;
  }
  
  /**
   * set/reset the string to be displayed
   */
  private String setDisplay(String init)
  {
    if (init == null)
      init = "";
    display = new StringBuilder(init);
    return display.toString();
  }
  
  /**
   * do all the work
   * @param key a key pressed by the user: 0-9,+/-,<
   * @return the current number as a string
   */
  public String addKey(char key)
  {
    double num;                  // the double version of the current number
   
    switch (key)
    {
      case '.':  // only one . in a number!
        if (isNumberEntryFinished)
        {
          setDisplay(".");
          isNumberEntryFinished = false;
          break;
        }
        if (display.toString().contains("."))
          break;
        // else, fall through and add to display string
        
      case '0':
      case '1':
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
        if (isNumberEntryFinished)
          setDisplay("");
        isNumberEntryFinished = false;
        display.append(key);
        break;
      //I changed the code in this case to toggle the negative sign  
      case 'n':
    	  if(display.length() == 0)
    	        display.append("-");  //Add a - symbol to the string builder
    	      //Check if a number has not been entered.  Cannot change the sign if
    	      //The number has already been entered.
    	      else if(!isNumberEntryFinished)
    	      {
    	        //If the character at 0 is already a -, then make it blank(positive)
    	        if(display.charAt(0)== '-')
    	        {        
    	          display.replace(0, 1, "");
//    	          display.deleteCharAt(display.indexOf("-"));
//    	          display.append("");
    	        }
    	        //Otherwise add the "-" symbol at index 0
    	        else
    	        {
    	          display.insert(0,"-");        
    	        }
    	      }
    	      //If a number has already been entered then the user wants to start a 
    	      // new number and make it a negative
    	      else
    	      {
    	        //Delete what is in the string build and add a - symbol 
    	        //display.delete(0,display.length()); 
    	        setDisplay("-");
    	        
    	      }    	 
        isNumberEntryFinished = false;
        break;
    	      
        
      case '<':
        if (!isNumberEntryFinished)
          display.deleteCharAt(display.length()-1);
        break;

      case '^':
        num = Double.parseDouble(display.toString());
        calc.enterNumber(num);
        setDisplay("" + num);
        isNumberEntryFinished = true;
        break;
        
      case 'p':
        if (!isNumberEntryFinished)
        {
          num = Double.parseDouble(display.toString());
          calc.enterNumber(num);
        }
        setDisplay("" + Math.PI);
        calc.enterNumber(Math.PI);
        isNumberEntryFinished = true;
        break;
        
      case '+':
        addOperator();
        setDisplay("" + calc.add());
        break;
        
      case '-':
        addOperator();
        setDisplay("" + calc.subtract());
        break;

      case '*':
        addOperator();
        setDisplay("" + calc.multiply());
        break;

      case '/':
        addOperator();
        setDisplay("" + calc.divide());
        break;

    }      
    
    return display.toString();
  }
  
  /**
   * some code common to all the operators in addKey
   */
  private void addOperator()
  {
    double num;                  // the double version of the current number
    
    if (!isNumberEntryFinished)
    {
      num = Double.parseDouble(display.toString());
      calc.enterNumber(num);
    }
    isNumberEntryFinished = true;
  }
}
