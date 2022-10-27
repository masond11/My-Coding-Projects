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

import java.util.Observable;

/**
 * This class solves the Hanoi game by using a recursion
 * method solveTowers which is private
 * 
 * @author Mason Dooley
 * @version 2022.10.16
 *
 */
@SuppressWarnings("deprecation")
public class HanoiSolver extends Observable {

    //Fields
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;
    
    /**
     * Constructor. Initializes the 3 towers to
     * the corresponding position
     * 
     * @param numDisks
     *              Amount of disks that will be used for the gam
     */
    public HanoiSolver(int numDisks) {
        
        this.numDisks = numDisks;
        
        //Initializing towers
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }
    
    /**
     * Getter method for numDisks
     * 
     * @return int Amount of disks in the game
     */
    public int disks() {
        return numDisks;
    }
    
    /**
     * Getter method for Tower
     * 
     * @param pos
     *          Position that will be used to identify a tower
     * @return Tower that corresponds to the position parameter
     */
    public Tower getTower(Position pos) {
        
        switch (pos) {
            case LEFT:
                return left;
            case MIDDLE:
                return middle;
            case RIGHT:
                return right;
            default:
                return middle;           
        }
    }
    
    /**
     * Returns a String of the disk width in each tower
     * 
     * @return String of the disks in the tower
     */
    public String toString() {
        return left.toString() + middle.toString() + right.toString();
    }
    
    /**
     * Moves a disk to a different tower
     * 
     * @param source Tower that disk is being popped from
     * @param destination Tower that disk is being pushed into
     */
    private void move(Tower source, Tower destination) {
        destination.push(source.pop());
        setChanged();
        notifyObservers(destination.position());
    }
    
    /**
     * Solves the Hanoi game by using a recursion method.
     * 
     * @param currentDisks
     *              Amount of Disks
     * @param startPole
     *              Pole where the Disks will start at in the beginning
     *              of the game (LEFT)
     * @param tempPole
     *              Will be used to move the Disks (MIDDLE)
     * @param endPole
     *              Final pole for disks at the end of the game (RIGHT)
     */
    private void solveTowers(int currentDisks, Tower startPole,
        Tower tempPole, Tower endPole) {
  
        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
        
    }
    
    /**
     * Will call the solveTowers() method to solve the Hanoi game
     */
    public void solve() {
        solveTowers(numDisks, left, middle, right);
    }
}
