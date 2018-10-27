/** TellerController
*   Anderson, Franceschi
*/

import java.util.Optional;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.text.*;
  
public class TellerController 
{

 @FXML private TableView<Ledger> tableView;
 @FXML private TableColumn<String, String> activityLedger, balanceLedger, rateLedger;
 @FXML private Button changeRate, applyInterest, deposit, withdraw, display, exit;
 
 private SavingsAccount sa;
 private NumberFormat money = NumberFormat.getCurrencyInstance( );
 private DecimalFormat percent = new DecimalFormat( "0.00%" );
 
 public void initialize( ) {
	 
    double balance = 0.0, interestRate = 0.0;
    boolean goodBalance = false, defaultObj = false;
         
    TextInputDialog dialog = new TextInputDialog( );
    dialog.setTitle( "Starting Balance" );
    dialog.setHeaderText( "" );
    dialog.setContentText( "Enter the starting balance;"
		       + " or press return to use the default constructor" );
		
	do 
	{
	    try 
	    {		     
		     Optional<String> result = dialog.showAndWait( );
		     if ( result.isPresent( ) )
		     {
		    	if ( result.get( ).length( ) == 0 )
		    	{
		    		 defaultObj = true;
			    	 sa = new SavingsAccount( );
			    	 goodBalance = true;
		    	}
		    	else 
		    	{
		            balance =  Double.parseDouble( result.get( ) );
		            if ( balance < 0.0 )
		            {
		            	dialog.setContentText( "Enter a positive starting balance" );
		            }
		            else 
		            {
		               goodBalance = true;
		            }
		    	}		    		    
		     }
		     else  // user cancelled the dialog
		     {
		    	 System.exit( 1 );
		     }
	     }
		 catch ( NumberFormatException nfe )
		 {
			 dialog.setContentText( "Enter the starting balance as a number" );
		 }
	} while ( !goodBalance );
	
	if ( ! defaultObj ) 
	{
		boolean goodRate = false;
	    dialog = new TextInputDialog( "3.0" );
	    dialog.setTitle( "Starting Interest Rate" );
	    dialog.setHeaderText( "" );
	    dialog.setContentText( "Enter the interest rate" );
		do 
		{			  
		  try 
		  {
			   Optional<String> result = dialog.showAndWait( );
			   if ( result.isPresent( ) )
			   {
			      if ( result.get( ).length( ) > 0 )
			      {    	
			            interestRate =  Double.parseDouble(result.get( ) );
			            if ( interestRate < 0.0 )
			            {
			            	dialog.setContentText( "Enter a positive interest rate" );
			            }
			            else 
			            {
			                sa = new SavingsAccount( balance, interestRate );
			            	goodRate = true;
			            }
			      }		    		    
			    }
			    else  // user cancelled the dialog
			    {
			    	 System.exit( 1 );
			    }
	      }
		  catch ( NumberFormatException nfe )
		  {
			 dialog.setContentText( "Enter the interest rate as a positive number" );
		  }
		  
		} while ( !goodRate );		
	}
	
	updateLedger( "Account opened" );
	
 }
 
 private void updateLedger( String activity ) 
 {	 
	 ObservableList<Ledger> data = tableView.getItems( );
     data.add( new Ledger( activity,
                           money.format(sa.getBalance( ) ),
                           percent.format(sa.getInterestRate( ) ) )
     );
 }
 

 @FXML protected void changeRate( ActionEvent event ) 
 { 
	 try 
	 {
	    double input =  getInput( "Enter the new interest rate" );
	
		sa.setInterestRate( input );
	    updateLedger( "Rate changed" );
	 }
	 catch ( NoInputException nie )
	 {
		 // user cancelled input; do nothing
	 }	
 }

 @FXML protected void applyInterest( ActionEvent event ) 
 {
     sa.applyInterest( );
     updateLedger( "Interest applied" );
 }
 
 @FXML protected void deposit( ActionEvent event ) 
 {
	 try 
	 {
	    double input =  getInput( "Enter the amount to deposit" );
	
	    sa.deposit( input );
	    updateLedger( "Deposit" );
	 }
	 catch ( NoInputException nie )
	 {
		 // user cancelled input; do nothing
	 }	
 }

 @FXML protected void withdraw( ActionEvent event ) 
 {
	 try 
	 {
		 double input = getInput( "Enter the amount to withdraw" );
     
    	 sa.withdraw( input );
         updateLedger( "Withdrawal" );
	 }
	 catch ( NoInputException nie )
	 {
		 // user cancelled input; do nothing
	 }	
 }
 
 @FXML protected void display( ActionEvent event ) 
 {
	 Alert alert = new Alert( AlertType.INFORMATION );
     alert.setTitle( "Account Information" );
     alert.setHeaderText( "" );
     alert.setContentText( sa.toString( ) );
     alert.showAndWait( );
 }

 @FXML protected void exit( ActionEvent event ) 
 {
     System.exit( 0 );
 }
 
 private double getInput( String prompt ) throws NoInputException
 {
     double input = 0.0;
 
	 TextInputDialog dialog = new TextInputDialog( );
	 dialog.setTitle( "Value needed" );
	 dialog.setHeaderText( "" );
	 dialog.setContentText( prompt );
	 	
	 boolean goodInput = false;
	 do 
	 {		 
		 Optional<String> result = dialog.showAndWait( );
		 try 
		 {
		    if ( result.isPresent( )  )
		    {
		    	input = Double.parseDouble( result.get( ) );
		    	goodInput = true;		    	
		    }
		    else
		    {
		    	throw new NoInputException( "User cancelled input dialog" );
		    }
		    
		 }
		 catch ( NumberFormatException nfe )
		 {
		    dialog.setContentText( "Value must be a number" );	
		 }
	 } while ( ! goodInput );
	 return input;		    
 }     
}