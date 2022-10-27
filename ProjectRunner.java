// Virginia Tech Honor Code Pledge:
//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- Mason Dooley (906230479)
package towerofhanoi;

/**
 * This class runs the Hanoi game by determining how 
 * many disks will be used, creating the HanoiSolver (Back-end),
 * and creating the PuzzleWindow (Front-end)
 * 
 * @author Mason Dooley
 * @version 2022
 *
 */
public class ProjectRunner {

    /**
     * This is the entry point when the project runs.
     * Without an input argument for the amount of disks,
     * the default is 6 disks 
     * 
     * @param args
     */
    public static void main(String[] args) {
        
        //Specifying the amount of disks for the game
        int disks = 6;
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        
        //Creating the game and the PuzzleWindow
        HanoiSolver game = new HanoiSolver(disks);
        new PuzzleWindow(game);
    }
}
