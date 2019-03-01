/*  Adjusts the gray value of an image
    Anderson, Franceschi
*/

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class PhotoGrayer extends Image
{  
  /** constructor
  * @param file  filename of the image
  *    passes the filename to the Image class
  *    constructor
  */
  public PhotoGrayer( String file ) 
  {   
    super( file );   
  }

  /** gray method
  *  @param  coeff the multipler to determine the
  *          color for each pixel
  *  @return a WritableImage
  */
  public WritableImage gray( double coeff ) 
  {
    int width = ( int ) getWidth( );
    int height = ( int ) getHeight( );
    WritableImage grayImage 
         = new WritableImage( width, height );
    PixelWriter pw = grayImage.getPixelWriter( );
    PixelReader pr = getPixelReader( );
    
    for ( int x = 0; x < width; x++ )
    {
      for ( int y = 0; y < height; y++ )
      {
        Color currentColor = pr.getColor( x, y );
        double grayValue =  coeff * 
          ( currentColor.getRed( ) + currentColor.getGreen( ) 
            + currentColor.getBlue( ) );
        currentColor = Color.gray( grayValue );
        pw.setColor( x, y, currentColor );
      }
    }
    return grayImage; 
  }
}