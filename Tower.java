// Virginia Tech Honor Code Pledge:
//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
//nor will I accept the actions of those who do.
// -- Mason Dooley (906230479)
package towerofhanoi;

/**
 * This class builds the towers that the disk will be stacked
 * on. This class implements the LinkedStack<T> class.
 * 
 * @author Mason Dooley
 * @version 2022.10.18
 *
 */
public class Tower extends LinkedStack<Disk> {

    //Fields
    private Position position;
    
    /**
     * Constructor for the Tower class. Creates a tower object
     * at a specified position
     * 
     * @param position
     *          where the tower will be placed: LEFT, MIDDLE, or RIGHT
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }
    
    /**
     * @return Position where the Tower is located
     */
    public Position position() {
        return position;
    }
    
    /**
     * This class pushes a disk onto the top of a tower
     * 
     * @param disk added to the tower
     * @throws IllegalArgumentException if parameter is null
     * @throws IllegalStateException if Disk being added to the
     * tower has a greater width than the top disk in the tower
     */
    @Override
    public void push(Disk disk) {
        
        //Checking if parameter is null
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        
        //Conditions that must be met for a disk to be
        //pushed onto a tower
        if (isEmpty() || disk.compareTo(peek()) < 0) {
            super.push(disk);
        }
        
        //Disk width was greater than the Disk at the top
        //Of the tower
        else {
            throw new IllegalStateException();
        }     
    }
        
}
