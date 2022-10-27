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

import cs2.Shape;
import student.TestableRandom;
import java.awt.Color;

/**
 * This class creates a disk with a width, height and random color
 * This disks will be used to play the Hanoi game by moving
 * the disks between the Towers. Extends the Shape class
 * and implements the Comparable<Disk> class
 * 
 * @author Mason Dooley
 * @version 2022.10.18
 *
 */
public class Disk extends Shape implements Comparable<Disk> {

    /**
     * Constructor. Creates a Disk with a width and a Height
     * that is set in the PuzzleWindow class.
     * 
     * @param width
     *             Will be set as the Disk's width
     */
    public Disk(int width) {
        //Creating a disk
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        
        //Creating a random color
        TestableRandom getRandom = new TestableRandom();
        int color1 = getRandom.nextInt(256);
        int color2 = getRandom.nextInt(256);
        int color3 = getRandom.nextInt(256);
        Color randomColor = new Color(color1, color2, color3);    
        this.setBackgroundColor(randomColor);
    }
    
    /**
     * Comparing the width sizes of two different Disks
     * 
     * @param otherDisk
     *              Will be compared against the this Disk
     * @return int representing which disk has a greater width;
     * positive int for this Disk being greater, negative for the parameter,
     * and 0 for equal width
     * @throws IllegalArgumentException
     *              Thrown if otherDisk is null         
     */
    @Override
    public int compareTo(Disk otherDisk) {
        //Throws an IllegalArgumentException if parameter is null
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        
        if (otherDisk.getWidth() > this.getWidth()) {
            return -1; //Parameter Disk had a greater Width
        }
        
        else if (otherDisk.getWidth() < this.getWidth()) {
            return 1; //this.Disk had a greater Width
        }
        
        return 0; //Disks were equal is width        
    }
    
    /**
     * Returns a String of the Disk's width
     * 
     * @return String the Disk's width
     */
    public String toString() {
        return String.valueOf(getWidth());
    }

    /**
     * Determining if two Disks are equal to one another.
     * Two Disks are equal to each other if their widths are equals
     * 
     * @param obj 
     *          Will be checked against this.Disk to see if they are equal
     * @return boolean if the two Disks are equal
     */
    public boolean equals(Object obj) {
        //Both are pointing at the same place in memory (are equal)
        if (obj == this) {
            return true;
        }
        
        //If Object is null it cannot be equal to this.Disk
        if (obj == null) {
            return false;
        }
        
        if (this.getClass() == obj.getClass()) {
            //Cast Disk class onto parameter
            Disk other = (Disk) obj;
            
            //Are equal if their widths are equal
            return other.getWidth() == this.getWidth();
        }
        
        //obj was not a Disk, so it cannot be equal
        return false;
    }
}
