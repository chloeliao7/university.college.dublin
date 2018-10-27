/** Ledger class for ObservableList for TableView
 *  Anderson, Franceschi
*/

import javafx.beans.property.SimpleStringProperty;

public class Ledger 
{
	private final SimpleStringProperty activity = new SimpleStringProperty( "" );
	private final SimpleStringProperty currentBalance = new SimpleStringProperty( "" );
	private final SimpleStringProperty currentRate = new SimpleStringProperty( "" );
	
	public Ledger( ) 
	{
		this ( "", "", "" );
	}
	
	public Ledger( String activity, String currentBalance, String currentRate ) 
	{
		setActivity( activity );
		setCurrentBalance( currentBalance );
		setCurrentRate( currentRate );
	}
	
	public Ledger setActivity( String activity ) 
	{
		this.activity.set( activity );
		return this;
	}
	
	public Ledger setCurrentBalance( String currentBalance ) 
	{
		this.currentBalance.set( currentBalance );
		return this;
	}
	
	public Ledger setCurrentRate( String currentRate ) 
	{
		this.currentRate.set( currentRate );
		return this;
	}
	
	public String getActivity( ) 
	{
		return activity.get( );
	}
	
	public String getCurrentBalance( )
	{
		return currentBalance.get( );		
	}
	
	public String getCurrentRate( )
	{
		return currentRate.get( );
	}	
}