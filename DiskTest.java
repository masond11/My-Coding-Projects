// Virginia Tech Honor Code Pledge:
//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- Mason Dooley (906230479)
package towerofhanoi;

import student.TestCase;

/**
 * Test class for the Disk class
 * 
 * @author Mason Dooley
 * @version 2022.10.18
 *
 */
public class DiskTest extends TestCase {

    private Disk disk;
    
    /**
     * Runs before each testMethod and initializes 
     * disk field to a length of 5
     */
    public void setUp() {
        disk = new Disk(5);
    }
    
    /**
     * Test method for the Disk Constructor
     */
    public void testDisk() {
        //Disk's width should be equal to what was passed into
        //the Constructor in setUp()
        assertEquals(disk.getWidth(), 5);
       
        //Disks's Height should be equal to the height in PuzzleWindow Class
        assertEquals(disk.getHeight(), PuzzleWindow.DISK_HEIGHT);
    }
    
    /**
     * Test method for equals() method
     * Will check that False is returned when disk is checked
     * for equality against null
     */
    public void testEquals() {
        assertFalse(disk.equals(null));
    }
    
    /**
     * Test method for equals() method
     * Will check that True is returned when disk is checked
     * for equality against itself
     */
    public void testEquals2() {
        assertTrue(disk.equals(disk));
    }
    
    /**
     * Test method for equals() method
     * Will check that False is returned when disk is checked
     * for equality against a testObject (not equal in class)
     */
    public void testEquals3() {
        Object testObject = new Object();
        assertFalse(disk.equals(testObject));
    }
    
    /**
     * Test method for equals() method
     * Will check that true is returned when disk is checked
     * for equality against another testDisk of equal width
     */
    public void testEquals4() {
        Disk testDisk = new Disk(5);
        assertTrue(disk.equals(testDisk));
    }
    
    /**
     * Test method for equals() method
     * Will check that False is returned when disk is checked
     * for equality against another testDisk of nonequal width
     */
    public void testEquals5() {
        Disk testDisk = new Disk(4);
        assertFalse(disk.equals(testDisk));
    }
    
    /**
     * Test Method for ToString()
     * When calling ToString() on Disk, "5" should be returned
     */
    public void testToString() {
        assertEquals("5", disk.toString());
    }
    
    /**
     * Test Method for compareTo()
     * Should throw an IllegalArgumentException as null will
     * be passed in as the parameter
     */
    public void testCompareTo() {
        Exception exception = null;
        try
        {
            disk.compareTo(null);
            fail("compareTo() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("CompareTo() is throwing the wrong type of exceptions",
                   exception instanceof IllegalArgumentException);
    }
    
    /**
     * Test Method for compareTo()
     * disk will be compared against a testDisk of equal width
     * and therefore should return 0
     */
    public void testCompareTo2() {
        Disk testDisk = new Disk(5);
        assertEquals(0, disk.compareTo(testDisk));
    }    
    
    /**
     * Test Method for compareTo()
     * disk will be compared against a testDisk of smaller width
     * and therefore should return 1
     */
    public void testCompareTo3() {
        Disk testDisk = new Disk(4);
        assertEquals(1, disk.compareTo(testDisk));
    }
    
    /**
     * Test Method for compareTo()
     * disk will be compared against a testDisk of greater width
     * and therefore should return -1
     */
    public void testCompareTo4() {
        Disk testDisk = new Disk(6);
        assertEquals(-1, disk.compareTo(testDisk));
    }
}
