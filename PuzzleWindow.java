// Virginia Tech Honor Code Pledge:
//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- Mason Dooley (906230479)
/**
 * 
 */
package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

/**
 * This class creates the front-end of the hanoi game, so
 * it can easily be observed. This includes, creating a window
 * with 3 towers and however many disks have been specified. It will
 * also create a solve button that will execute the back-end of
 * the game.
 * 
 * @author weeks
 *
 */
@SuppressWarnings("deprecation")
public class PuzzleWindow implements Observer {

    //Fields
    private HanoiSolver game;
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;
    public static final int WIDTH_FACTOR = 50;
    public static final int DISK_GAP = 0;
    public static final int DISK_HEIGHT = 10;
    
    /**
     * Constructor. Initializes the fields, creates 3 poles, and creates
     * the disks and adds them to the starting pole (LEFT).
     * 
     * @param game Instance of the HanoiSolver
     */
    public PuzzleWindow(HanoiSolver game) {
        //Initializes the game field
        this.game = game;
        game.addObserver(this);
        
        //Creates a window
        window = new Window("Tower of Hanoi");
        
        //Creates 3 towers. The Left Tower is centered at 20% of the Window width,
        //the Middle is centered, and the Left Tower is centered at 80% of the Window width.
        //Half of the tower width (1% of the tower width) is subtracted from the tower to center
        //the towers. The towers have a height of 80% of the window
        //height and start at 10% of the window height to make
        //them centered. The tower width is 2% of the window width
        left = new Shape(window.getGraphPanelWidth()/5 - window.getGraphPanelWidth()/100,
            window.getGraphPanelHeight()/10, window.getGraphPanelWidth()/50,
            4*window.getGraphPanelHeight()/5, Color.gray);
        middle = new Shape(window.getGraphPanelWidth()/2 - window.getGraphPanelWidth()/100,
            window.getGraphPanelHeight()/10,window.getGraphPanelWidth()/50,
            4*window.getGraphPanelHeight()/5, Color.gray);
        right = new Shape(4*window.getGraphPanelWidth()/5 - window.getGraphPanelWidth()/100,
            window.getGraphPanelHeight()/10, window.getGraphPanelWidth()/50,
            4*window.getGraphPanelHeight()/5, Color.gray);
        
        //Creates each disk with a certain width, and adds them to the left tower
        for (int i = game.disks(); i > 0; i--) {
            //Adds Disk; Greater the i value the greater the width
            game.getTower(Position.LEFT).push(new Disk(i*15));
            
            //Add Disk to window
            window.addShape(game.getTower(Position.LEFT).peek());
            moveDisk(Position.LEFT);
        }
        
        //Adds each tower to the window
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        
        //Adds a solve button at the top of the window that when clicked
        //will complete the game
        Button solve = new Button("Solve");
        solve.onClick(this, "clickedSolve");
        window.addButton(solve, WindowSide.NORTH);
        
    }
    
    /**
     * This method updates the screen to the current state
     * of the towers
     * 
     * @param arg
     *          Position where the disk will be moved to
     * @param o
     *          Observable front-end
     */        
    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            moveDisk((Position) arg);
            sleep();
        }
    }

    /**
     * This method will pause the game algorithm between
     * disk movements, so the changes can be observed.
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }

    /**
     * This method will execute when the solve button is clicked
     * and will call the game's solve method to complete the game
     * 
     * @param button
     *              Solve Button
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }
    
    /**
     * Will move a disk to the tower that is at the specified position
     * 
     * @param position Tower where the disk will be moved to
     */
    private void moveDisk(Position position) {      
        
        //Getting the disk that will be moved
        Disk currentDisk = game.getTower(position).peek();
        
        //Getting the tower that the disk is being moved to
        Shape currentShape;
        switch (position) {
            case LEFT:
                currentShape = left;
                break;
            case MIDDLE:
                currentShape = middle;
                break;
            case RIGHT:
                currentShape = right;
                break;
            default:
                currentShape = middle;           
        }
        
        //Getting center coordinate at the bottom of the pole shape
        int towerYCoord = currentShape.getY() + currentShape.getHeight();
        int towerXCoord = currentShape.getX() + currentShape.getWidth()/2;
        
        //Using center coordinate to compute where the disk should be
        //moved to. Y coordinate will be the Y coordinate of the bottom center
        //of the tower minus the amount of disks times the disk height.
        //The X coordinate will be X coordinate of the bottom center of the tower
        //minus half the currentDisk width
        int diskYCoord = towerYCoord - (game.getTower(position).size())*DISK_HEIGHT;
        int diskXCoord = towerXCoord - currentDisk.getWidth()/2;
        
        //Moving the currentDisk
        currentDisk.moveTo(diskXCoord, diskYCoord);
    }
}
