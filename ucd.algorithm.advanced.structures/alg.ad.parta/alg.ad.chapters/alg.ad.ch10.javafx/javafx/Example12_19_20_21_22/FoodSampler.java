/*  FoodSampler class
    Anderson, Franceschi
*/

import javafx.scene.image.Image;

public class FoodSampler
{
  private String [] countryList = 
     { "France", "Greece", "Italy", "Japan", "USA" };
  private Image [] foods = 
     { new Image( "cheese.jpg" ),
       new Image( "fetasalad.jpg" ),
       new Image( "pizza.jpg" ),
       new Image( "sushi.jpg" ),
       new Image( "hamburger.jpg" ) };
  private int selectedIndex = 0;

  /** getCountryList method
  *  @return a reference to the countryList array
  */
  public String [] getCountryList( )
  { 
    return countryList;  
  }

  /** the accessor for selectedIndex 
  *  @return the index selected
  */
  public int getSelectedIndex( )
  { 
    return selectedIndex;
  }

  /** the mutator for selectedIndex
  * @param selection the new value for selectedIndex
  */
  public void updateSelection( int selection )
  { 
    selectedIndex = selection;
  }

  /** the accessor for the image to display
  *  @return the image from the Image array
  *          using index selectedIndex
  */
  public Image getImageSelected( )
  { 
    return foods[selectedIndex];  
  }
}