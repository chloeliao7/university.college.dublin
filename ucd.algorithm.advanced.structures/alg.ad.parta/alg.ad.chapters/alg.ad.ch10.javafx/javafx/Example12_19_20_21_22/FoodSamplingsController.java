/*  FoodSamplingsController class
    Anderson, Franceschi
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.*;
 
public class FoodSamplingsController 
{
  private FoodSampler sampler;

  @FXML private ComboBox<String> countries;  
  @FXML private ImageView foodImage;
  private SingleSelectionModel<String> selectionModel;

  public void initialize( )
  {
    sampler = new FoodSampler( );
    
    // populate combobox with data from the Model
    countries.getItems( ).addAll( sampler.getCountryList( ) );
    
    // get a reference to the SingleSelectionModel
    selectionModel = countries.getSelectionModel( );
        
    // initialize View with initial data from Model
    selectionModel.select( sampler.getSelectedIndex( ) );
    foodImage.setImage( sampler.getImageSelected( ) );
  }

  @FXML protected void itemSelected( ActionEvent event ) 
  {
    // retrieve index of country selected
    int index = selectionModel.getSelectedIndex( );
    // update the Model
    sampler.updateSelection( index );
    // update the View with Image from the Model
    foodImage.setImage( sampler.getImageSelected( ) );
  }
}