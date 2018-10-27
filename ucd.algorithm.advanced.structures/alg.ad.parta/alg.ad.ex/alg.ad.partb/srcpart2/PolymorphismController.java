
/* PolymorphismController Class
 *  Anderson, Franceschi
 */
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import java.lang.String;
import java.lang.Iterable;

public class PolymorphismController {
  private final int FIRST_RACER = 50;
  private int finishX; // location of finish line, dependent on window width
  private ArrayList<Racer> racerList; // racers stored in ArrayList
  int yPos; // y coordinate of current racer
  @FXML
  private BorderPane bp;
  @FXML
  private TextField inputTextField;
  @FXML
  private Button enter;
  @FXML
  private Button start;
  @FXML
  private Label winner;
  private Pane pane;
  private Canvas canvas;
  private GraphicsContext gc;
  boolean raceMode; // true: race; false: reset

  public void initialize() {
    raceMode = true;
    racerList = new ArrayList<Racer>();
    yPos = FIRST_RACER;
    pane = new Pane();
    bp.setCenter(pane);
    canvas = new Canvas(Dimensions.APP_WIDTH - Dimensions.APP_PADDING, Dimensions.APP_HEIGHT - Dimensions.APP_PADDING);
    pane.getChildren().add(canvas);
    gc = canvas.getGraphicsContext2D();
    gc.setFill(Color.WHITE);
    gc.fillRect(0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT);
  }

  /**
   * prepareToRace method
   *   @param input racer type entered by the user
   *      racer types are 't' or 'T' for Tortoise,
   *                      'h' or 'H' for Hare
   */
  private void prepareToRace(char input) {
    final int START_LINE = 60; // x position of start of race
    final int RACER_SPACE = 50; // spacing between racers
    //  private String Tortoise = "t";
    //  private String Hare = "H";
    /**
     * 1. ***** Student writes this switch statement
     *  input parameter contains the racer type
     *      entered by the user
     *  If input is 'T' or 't',
     *     add a Tortoise object to the ArrayList named racerList
     *            which is an instance variable of this class
     *  The API of the Tortoise constructor is:
     *          Tortoise( String ID, int x, int y )
     *   a sample call to the constructor is
     *          new Tortoise( "Tortoise", START_LINE, yPos )
     *          where START_LINE is a constant local variable
     *            representing the starting x position for the race
     *          and yPos is an instance variable representing
     *             the racer's y position
     *
     *
     *  If input is 'H' or 'h',
     *      add a Hare object to the ArrayList named racerList
     *  The API of the Hare constructor is:
     *          Hare( String ID, int x, int y )
     *      a sample call to the constructor is
     *          new Hare( "Hare", START_LINE, yPos )
     *          where START_LINE is a constant local variable
     *            representing the starting x position for the race
     *          and yPos is an instance variable representing
     *             the racer's y position
     *
     *  After adding a racer to the ArrayList racerList,
     *          increment yPos by the value of
     *          the constant local variable RACER_SPACE
     *
     *  if input is anything other than 'T', 't',
     *          'H' or 'h', do nothing
     */
    // write your switch statement here
    switch (input) { // this will get the input from the user AND pass it through the switch statement 
    // this will have you choose between lower case or uppercase 
    case 't':
    case 'T':
      // to make sure you get all the coodinates right from the 
      //method and to pass the object you need to create a new one every time so it can be inserted in the array 
      racerList.add(new Tortoise("Tortoise", START_LINE, yPos));
      yPos += RACER_SPACE;
      break;
    case 'h':
    case 'H':
      racerList.add(new Hare("Hare", START_LINE, yPos));
      yPos += RACER_SPACE;
      break;
    default:
      break;
    }
    /** end of student code, part 1 */
  } // end prepareToRace

  /**
   * getReady method
   *  @param gc   GraphicsContext context
   *  draws the finish line and draws the racers
   */
  protected void getReady(GraphicsContext gc) {
    // draw the finish line
    finishX = (int) canvas.getWidth() - 20;
    gc.setStroke(Color.BLUE);
    gc.strokeLine(finishX, 0, finishX, canvas.getHeight());
    // display racers before race begins
    /* 2. ***** student writes this code
     *  loop through instance variable ArrayList racerList,
     *    which contains Racer object references,
     *    calling draw for each element. (Do not call move!)
     *  The API for draw is:
     *      void draw( GraphicsContext gc )
     *        where gc is the graphics context
     *        passed to this getReady method
     */
    // student code goes here
    // here we are going through every in racer list and at every iteration we are applying the method gc draw 
    // drawign onto out cavas with passing the parameter gc from GraphicsContext
    for (Racer racer : racerList) { // iterate through the racerlist in racer class

      racer.draw(gc); // calling draw method and setting racerList in the draw class // System.out.println(racer);
    }
    /** end of student code, part 2 */
  } // end getReady

  /**
   * runRace method
   *  @param gc   GraphicsContext context
   *  moves and draws racers
   */
  public void runRace(GraphicsContext gc) {
    gc.setStroke(Color.BLUE);
    gc.strokeLine(finishX, 0, finishX, canvas.getHeight());

    /* 3. ***** student writes this code
     *    loop through instance variable ArrayList racerList,
     *    which contains Racer object references,
     *    calling move, then draw for each element
     *  The API for move is:
     *      void move( )
     *  The API for draw is:
     *      void draw( GraphicsContext gc )
     *        where gc is the GraphicsContext object
     *        passed to this runRace method
     */

    // student code goes here
    // this will loop through all the racers in the list and apply the 
    //  methoss move and draw. we need draw again because it needs to update and rest 
    for (Racer racer : racerList) { // iterate through the racerlist in racer class
      // System.out.println(racer);
      racer.move(); // call back racer move without any params 
      racer.draw(gc); // calling draw method and setting racerList in the draw class 
    }
    /** end of student code, part 3 */
  } // end runRace

  /**
   * handler method for "Enter racer" button
   *   displays an Alert if screen is full
   *   otherwise, passes input from textfield to prepareRace method
   *   then calls getReady method to display the racers
   */
  @FXML
  protected void activity(ActionEvent event) {
    String userInput = inputTextField.getText(); // get input from user
    if (userInput != null && userInput.length() >= 1) {
      if (yPos + 50 >= canvas.getHeight()) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("");
        alert.setContentText("Field is full. No more racers can be added.");
        alert.showAndWait();
      } else {
        char input = userInput.charAt(0);
        prepareToRace(input);
        getReady(gc);
      }
    }
  }

  /**
   * handler method for "Start race" button
   *  starts the animation if raceMode is on
   */
  @FXML
  protected void race(ActionEvent event) {
    if (raceMode) // start race
    {
      if (racerList.size() >= 1)
        startAnimation();
    } else // reset race
    {
      winner.setText("");
      gc.setFill(Color.WHITE);
      gc.fillRect(0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT);
      enter.setDisable(false);
      start.setDisable(false);
      start.setText("Start");
      raceMode = true;
    }
  }

  /**
   * startAnimation method
   *   starts the AnimationTimer
   *   to run the race
   */
  public void startAnimation() {
    RaceAnimationTimer timer = new RaceAnimationTimer();
    raceMode = true;
    enter.setDisable(true);
    start.setDisable(true);
    timer.start();
  }

  /**
   * resetRace method
   *   clears the ArrayList of Racers
   *   resets yPos to FIRST_RACER
   */
  public void resetRace() {
    raceMode = false;
    start.setText("New Race");
    inputTextField.setText("");
    start.setDisable(false);
    racerList.clear();
    yPos = FIRST_RACER;
  }

  /**
   * findWinners:
   *    checks for any racer whose x position is past the finish line
   *    @return  true if any racer's x position is past the finish line
   *             or false if no racer's x position is past the finish line
   */
  private boolean findWinner() {
    for (Racer r : racerList) {
      if (r.getX() > finishX)
        return true;
    }
    return false;
  }

  /**
   * reportRaceResults : compiles winner names and prints message
   *   winners are all racers whose x position is past the finish line
   */
  private String reportRaceResults() {
    String results = "Racer ";
    for (int i = 0; i < racerList.size(); i++) {
      if (racerList.get(i).getX() > finishX)
        results += (i + 1) + ", a " + racerList.get(i).getID() + ", ";
    }
    return results + " win(s) the race ";
  }

  /**
   * private inner class to handle the animation
   */
  private class RaceAnimationTimer extends AnimationTimer {
    @Override
    public void handle(long now) {
      // update screen
      gc.setFill(Color.WHITE);
      gc.fillRect(0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT); // gets rid of all the pixels and resets for next move 
      runRace(gc);
      Pause.wait(0.01);
      // test if race is over
      if (findWinner()) {
        String result = reportRaceResults();
        winner.setText(result);
        resetRace();
        stop();
      }
    }
  }
}