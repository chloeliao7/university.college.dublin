/*  Animation Controller
    Anderson, Franceschi
*/
import java.net.URL;

import javafx.animation.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class AnimationController
{
  @FXML private Button fadeButton, rotateButton, 
                       scaleButton, combineButton, 
                       startTranslateButton, stopTranslateButton;
  @FXML private VBox canvasContainer;
  
  private FadeTransition ftFade;
  private RotateTransition rtHalf, rtFull;
  private TranslateTransition ttStraight, ttDiagonal; 
  private ScaleTransition stLarger, stSmaller, stSqueeze; 
  private SequentialTransition sequential;
  private ParallelTransition parallel;
  
  private AudioClip sound;
 
  @FXML public void initialize( )
  {
    // Sprite extends Canvas
    Sprite sprite = new Sprite( 0, 0, 1 ); 
    GraphicsContext gc = sprite.getGraphicsContext2D( );     
    sprite.draw( gc );
    canvasContainer.getChildren( ).add( sprite );
   
    // fade for 3 seconds, then reverse   
    ftFade = new FadeTransition( Duration.seconds( 3 ), sprite );
    ftFade.setFromValue( 1.0 );
    ftFade.setToValue( 0.1 );
    ftFade.setCycleCount( 2 );
    ftFade.setAutoReverse( true );
    fadeButton.setOnAction( event -> runTransition( ftFade ) );
    
    // sound effect
    URL resource = getClass( ).getResource( "whoosh.m4a" ); 
    sound = new AudioClip( resource.toString( ) );
    sound.setCycleCount( 2 ); 
    
    // rotate 180 degrees and back
    rtHalf = new RotateTransition( Duration.millis( 3000 ), sprite );
    rtHalf.setFromAngle( 0 );
    rtHalf.setToAngle( 180 );
    rtHalf.setCycleCount( 2 );
    rtHalf.setAutoReverse( true );   
    rotateButton.setOnAction( event -> 
                              {
                                runTransition( rtHalf );
                                sound.play( );
                              }
                            );

    // reduce size to 1/2, return to start size
    stSmaller = new ScaleTransition( Duration.millis( 1500 ), sprite );
    stSmaller.setToX( 0.5f );
    stSmaller.setToY( 0.5f );
    stSmaller.setCycleCount( 2 );
    stSmaller.setAutoReverse( true );

    // reduce x size to 1/2, return to start size
    stSqueeze = new ScaleTransition( Duration.millis( 1500 ), sprite );
    stSqueeze.setToX( 0.5f );
    stSqueeze.setCycleCount( 2 );
    stSqueeze.setAutoReverse( true );
   
    sequential = new SequentialTransition( stSmaller, stSqueeze );
    scaleButton.setOnAction( event -> runTransition( sequential ) );            
    
    // move right 80 pixels, then return to start
    ttStraight = new TranslateTransition( Duration.seconds( 3 ), sprite );
    ttStraight.setFromX( 0 );
    ttStraight.setToX( 80 );
    ttStraight.setCycleCount( 2 );
    ttStraight.setAutoReverse( true );
    
    // rotate 360 degrees
    rtFull = new RotateTransition( Duration.millis( 3000 ), sprite );
    rtFull.setByAngle( 360 );
    
    // increase size by half, return to start size
    stLarger = new ScaleTransition( Duration.millis( 1500 ), sprite );
    stLarger.setToX( 1.5f );
    stLarger.setToY( 1.5f );
    stLarger.setCycleCount( 2 );
    stLarger.setAutoReverse( true );
        
    parallel = new ParallelTransition( ttStraight, rtFull, stLarger );  
    combineButton.setOnAction( event -> runTransition( parallel ) );

    // move diagonally up 100 pixels, then return to start
    ttDiagonal = new TranslateTransition( Duration.millis( 1500 ), sprite );
    ttDiagonal.setFromX( 0 );
    ttDiagonal.setToX( 100 );
    ttDiagonal.setFromY( 0 );
    ttDiagonal.setToY( -100 );
    ttDiagonal.setCycleCount( Animation.INDEFINITE );
    ttDiagonal.setAutoReverse( true );
    stopTranslateButton.setDisable( true );
    startTranslateButton.setOnAction( event -> 
                 {
                    stopTranslateButton.setDisable( false );
                    runTransition( ttDiagonal ); 
                  } );
               
    stopTranslateButton.setOnAction( event -> 
                 { 
                    stopTranslateButton.setDisable( true );
                    ttDiagonal.stop( );
                    disableButtons( false );
                  } );                     
  } 

  /**
  *   runTransition
  *   @param t, the transition to run
  *   disables buttons, sets animation finished event handler
  *   plays the animation
  */ 
  public void runTransition( Transition t )
  {
     disableButtons( true );
     t.setOnFinished( event -> disableButtons( false ) );
     t.play( );
  }
    
  /** disableButtons 
  *   @param mode   true to disable, false to enable
  */
  public void disableButtons( boolean mode )
  {
     fadeButton.setDisable( mode );
     startTranslateButton.setDisable( mode );
     rotateButton.setDisable( mode );
     scaleButton.setDisable( mode );
     combineButton.setDisable( mode );   
  }  
}