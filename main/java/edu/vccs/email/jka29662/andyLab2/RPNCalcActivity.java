package edu.vccs.email.jka29662.andyLab2;
/**
 * This class is manages all of the GUI features for the RPN Calculator.
 * 2/27/2015
 * @author Joey Arbogast
 */


import edu.vccs.email.jka29662.andyLab2.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RPNCalcActivity extends Activity {
	//creates an instance of the helper class
	private RPNCalcGUIHelper helper = new RPNCalcGUIHelper();	
	
	//Creates a bunch of buttons and an EditText field
	private Button mButtonZero;
	private Button mButtonOne;
	private Button mButtonTwo;
	private Button mButtonThree;
	private Button mButtonFour;
	private Button mButtonFive;
	private Button mButtonSix;
	private Button mButtonSeven;
	private Button mButtonEight;
	private Button mButtonNine;
	private Button mButtonPI;
	private Button mButtonAdd;
	private Button mButtonSub;
	private Button mButtonMult;
	private Button mButtonDiv;
	private Button mButtonEnt;
	private Button mButtonBS;
	private Button mButtonNeg;
	private Button mButtonDec;
	private EditText mTextView;
	
	/**
	 * This method is called when the app starts.  It calls the super 
	 * constructor and sets the content view.  This method contains all of the 
	 * listeners for the buttons.
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rpncalc);
        
        //Sets the id of the text field equal to the class attribute
        mTextView = (EditText)findViewById(R.id.io_display);
        
        //All of these expressions set a button equal to the class attribute 
        //that applies and the listener calls the private method updateDisplay.
        
        mButtonZero = (Button)findViewById(R.id.button0);
        mButtonZero.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v)
        	{        		
        		updateDisplay('0');
        	}
        		
        	});
        mButtonOne = (Button)findViewById(R.id.button1);
        mButtonOne.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v)
        	{        		
        		updateDisplay('1');
        	}
        		
        	});
        mButtonTwo = (Button)findViewById(R.id.button2);
        mButtonTwo.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v)
        	{        		
        		updateDisplay('2');
        	}
        		
        	});
        mButtonThree = (Button)findViewById(R.id.button3);
        mButtonThree.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v)
        	{        		
        		updateDisplay('3');
        	}
        		
        	});
        mButtonFour = (Button)findViewById(R.id.button4);
        mButtonFour.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v)
        	{        		
        		updateDisplay('4');
        	}
        		
        	});
        mButtonFive = (Button)findViewById(R.id.button5);
        mButtonFive.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v)
        	{        		
        		updateDisplay('5');
        	}
        		
        	});
        mButtonSix = (Button)findViewById(R.id.button6);
        mButtonSix.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v)
        	{        		
        		updateDisplay('6');
        	}
        		
        	});
        mButtonSeven = (Button)findViewById(R.id.button7);
        mButtonSeven.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v)
        	{        		
        		updateDisplay('7');
        	}
        		
        	});
        mButtonEight = (Button)findViewById(R.id.button8);
        mButtonEight.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v)
        	{        		
        		updateDisplay('8');
        	}
        		
        	});
        mButtonNine = (Button)findViewById(R.id.button9);
        mButtonNine.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v)
        	{        		
        		updateDisplay('9');
        	}
        		
        	});
        
        /*All of these button expressions use a try and catch block.  Try to 
        send the key to the updateDisplay Method if an exception is generated 
        call the errorMessage method*/
        mButtonAdd = (Button)findViewById(R.id.button_add);
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v)
        	{   
        		try{
        			updateDisplay('+');
        		}
        		catch(Exception e)
        		{
        			errorMessage();
        		}
        	}
        		
        	});
        mButtonSub = (Button)findViewById(R.id.button_subtract);
        mButtonSub.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v)
        	{  
        		try{
        			updateDisplay('-');
        		}
        		catch(Exception e)
        		{
        			errorMessage();
        		}
        	}
        		
        	});
        mButtonMult = (Button)findViewById(R.id.button_mult);
        mButtonMult.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v)
        	{   try{     		
        			updateDisplay('*');
        		}
        		catch(Exception e)
        		{
        			errorMessage();
        		}
        	}
        		
        	});
        mButtonDiv = (Button)findViewById(R.id.button_div);
        mButtonDiv.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v)
        	{   
        		try{
        			updateDisplay('/');
        		}
        		catch(Exception e)
        		{
        			errorMessage();
        		}
        	}
        		
        	});
        mButtonPI = (Button)findViewById(R.id.button_pi);
        mButtonPI.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v)
        	{ 
        		try{
        			updateDisplay('p');
        		}
        		catch(Exception e)
        		{
        			errorMessage();
        		}
        		
        	}        		
        	});
        mButtonDec = (Button)findViewById(R.id.button_dec);
        mButtonDec.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v)
        	{  
        		try{
        			updateDisplay('.');
        		}
        		catch(Exception e)
        		{
        			errorMessage();
        		}
        	}
        		
        	});
        mButtonEnt = (Button)findViewById(R.id.button_ent);
        mButtonEnt.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v)
        	{   
        		try{
        			updateDisplay('^');
        		}
        		catch(Exception e)
        		{
        			errorMessage();
        		}
        	}
        		
        	});
        mButtonBS = (Button)findViewById(R.id.button_bs);
        mButtonBS.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v)
        	{  
        		/*This button kept causing the app to crash if I continually
        		press the button.  It does not need to generate a toast
        		message so it does nothing if an exception happens.*/
        		try{
        			updateDisplay('<');
        		}
        		catch(Exception e)
        		{
        			
        		}        		
        	}
        		
        	});
        mButtonNeg = (Button)findViewById(R.id.button_negate);
        mButtonNeg.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v)
        	{         		
        		updateDisplay('n');
        	}
        		
        	});
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.rpncalc, menu);
        return true;
    }
    
    /**
     * This method is used to print a Toast error message.
     */
    private void errorMessage()
    {		
    	int messageResId = R.string.error_toast;
		
		Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }
    /**
     * This is common code in all of the button listeners.  Handles sending the
     * key to the helper class and updating the display.
     * @param key	the button pushed
     */
    private void updateDisplay(char key)
    {
    	String currentDisplay = helper.addKey(key);
		mTextView.setText(currentDisplay);    	
    }
}
