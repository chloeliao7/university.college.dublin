import javafx.beans.value.*; 
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.*;

public class PhotoGrayerController 
{
  private PhotoGrayer photoGrayer;

  @FXML private ImageView grayImageView;
  @FXML private Slider slider;

  public void initialize( )
  {
    photoGrayer = new PhotoGrayer( "sushi.jpg" );

    // initialize grayImageView
    Image grayImage = photoGrayer.gray( slider.getValue( ) );   
    grayImageView.setImage( grayImage );
    
    // set up event handling for slider
    SliderHandler sh = new SliderHandler( );
    slider.valueProperty( ).addListener( sh );  
  }

  private class SliderHandler 
                 implements ChangeListener<Number>
  {
    @Override
    public void changed( ObservableValue<? extends Number> o,
                         Number oldValue, Number newValue ) 
    {
      // update grayImageView
      grayImageView.setImage( 
           photoGrayer.gray( newValue.doubleValue( ) ) );
    }    
  }
}