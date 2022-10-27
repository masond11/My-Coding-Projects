// Virginia Tech Honor Code Pledge:
//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- Mason Dooley (906230479)
package towerofhanoi;

import student.TestCase;

/**
 * Test class for the Tower class
 * 
 * @author Mason Dooley
 * @version 2022.10.18
 *
 */
public class TowerTest extends TestCase {
    
    //Fields
    private Tower tower;
    
    /**
     * Runs before each test method and initializes the tower field
     * with a LEFT position
     */
    public void setUp() {
        tower = new Tower(Position.LEFT);
    }
    
    /**
     * Test method for the Tower constructor
     * Will also test the position() method
     * Size should be 0 and the position should be left
     */
    public void testTower() {
        assertEquals(tower.size(), 0);
        assertEquals(tower.position(), Position.LEFT);
    }
    
    /**
     * Test method for push() method. Will test that an
     * IllegalArgumentException is thrown when null is passed in
     * as a parameter
     */
    public void testPush() {
        Exception exception = null;
        try
        {
            tower.push(null);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
                   exception instanceof IllegalArgumentException);
    }
    
    /**
     * Test method for push() method. Will test that a disk
     * is added to an empty Tower
     */
    public void testPush2() {
        //Add disk
        Disk disk = new Disk(4);
        tower.push(disk);
        
        //Tower should have 1 disk with a width of 4
        assertEquals(tower.peek(), disk);
        assertEquals(tower.size(), 1);
        assertEquals(tower.toString(), "[4]");
    }

    /**
     * Test method for push() Method. Will test that a disk
     * is added to a tower who's top disk's width is greater 
     * than the parameter's disk width
     */
    public void testPush3() {
        //Creating 2 disks of different widths
        Disk disk = new Disk(3);
        Disk disk2 = new Disk(2);
        
        //Adding the two disks. Size should increase by 1 each time
        tower.push(disk);
        assertEquals(tower.size(), 1);
        tower.push(disk2);
        assertEquals(tower.size(), 2);
        
        //Top disk should be disk2
        assertEquals(tower.peek(), disk2);
        assertEquals(tower.toString(), "[2, 3]");
    }
    
    /**
     * Test method for push() Method. Will test that an
     * IllegalStateException is thrown when a tower's top disk's
     * width is less than the parameter disk's width
     */
    public void testPush4() {
        //Creating 2 Disks of different widths
        Disk disk = new Disk(2);
        Disk disk2 = new Disk(3);
        
        //Adding disk with smaller width
        tower.push(disk);
        
        //IllegalStateException is thrown when adding a disk of greater width
        Exception exception = null;
        try
        {
            tower.push(disk2);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
                   exception instanceof IllegalStateException);
    }
}
