// Virginia Tech Honor Code Pledge:
//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- Mason Dooley (906230479)
package towerofhanoi;

import student.TestCase;

/**
 * Test class for the HanoiSolver class
 * 
 * @author Mason Dooley
 * @version 2022.10.18
 *
 */
public class HanoiSolverTest extends TestCase {

    //Fields
    private HanoiSolver solver;
    
    /**
     * Executed before every test method. Sets up a Hanoi Solver
     * with 5 disks on the Left tower that increase in width from largest
     * to smallest
     */
    public void setUp() {
        solver = new HanoiSolver(5);
        for (int i = 5; i > 0 ; i--) {
            solver.getTower(Position.LEFT).push(new Disk(i));
        }
    }
    
    /**
     * Test method for the constructor for HanoiSolver.
     * 3 towers should be created with a total of
     * 5 disks that are on the Left Tower
     */
    public void testHanoiSolver() {
      
        //Should be 5 total disks
        assertEquals(solver.disks(), 5);
        
        //Left tower should have all 5 disks
        assertEquals(5, solver.getTower(Position.LEFT).size());
        
        //Middle and Right tower should be empty
        assertTrue(solver.getTower(Position.MIDDLE).isEmpty());
        assertTrue(solver.getTower(Position.RIGHT).isEmpty());
    }
    
    /**Test method for the solve method.
     * Upon completion of the game, all 5 disks should be in order
     * of decreasing width from top to bottom on the Right tower.
     */
    public void testHanoiSolve() {
        
        //Starting positon of disks
        assertEquals(solver.toString(), "[1, 2, 3, 4, 5][][]");
        
        //Complete the game
        solver.solve();
        
        //Ending positon of the disks
        assertEquals(solver.toString(), "[][][1, 2, 3, 4, 5]");
        
        //Double check. Right tower should have 5 disks with the
        //other towers being empty
        assertEquals(5, solver.getTower(Position.RIGHT).size());
        assertTrue(solver.getTower(Position.MIDDLE).isEmpty());
        assertTrue(solver.getTower(Position.LEFT).isEmpty());
    }
    
    /**Test method for the solve method.
     * Will attempt to complete the game with 10 disks.
     * Will have to create a new solver
     * Will also test that the middle tower is returned
     * when DEFAULT is passed in as the position parameter
     */
    public void testHanoiSolve2() {
        //Creating a new solver with 10 disks on the left tower
        HanoiSolver solver2 = new HanoiSolver(10);
        for (int i = 10; i > 0 ; i--) {
            solver2.getTower(Position.LEFT).push(new Disk(i));
        }
        
        //Starting positon of disks
        assertEquals(solver2.toString(), "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10][][]");
        
        //Complete the game
        solver2.solve();
        
        //Ending positon of the disks
        assertEquals(solver2.toString(), "[][][1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
        
        //Double check. Right tower should have 5 disks with the
        //other towers being empty
        assertEquals(10, solver2.getTower(Position.RIGHT).size());
        assertTrue(solver2.getTower(Position.DEFAULT).isEmpty());
        assertTrue(solver2.getTower(Position.LEFT).isEmpty());
    }
    
}
