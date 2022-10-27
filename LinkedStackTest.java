// Virginia Tech Honor Code Pledge:
//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- Mason Dooley (906230479)
package towerofhanoi;

import java.util.EmptyStackException;
import student.TestCase;

/**
 * Test class for the LinkedStack class
 * 
 * @author Mason Dooley
 * @version 2022.10.14
 * @param <T>
 */
public class LinkedStackTest<T> extends TestCase {
    
    //Fields
    private LinkedStack<T> stack;

    /**
     * The setUp() method runs before each test method
     * and initialize the field stack
     */
    public void setUp() {
        stack = new LinkedStack<T>();
    }       
    
    /**
     * This test method tests the constructor of Linked Stack.
     * Will test that the LinkedStack is initially empty with 
     * the topNode being null by seeing if an EmptyStackException
     * is throw when calling peek()
     */
    public void testLinkedStack() {
        //Calling peek() to look at the topNode should throw
        //an EmptyStackException. Will also test isEmpty()
        Exception exception = null;
        try
        {
            stack.peek();
            fail("peek() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("peek() is throwing the wrong type of exceptions",
                   exception instanceof EmptyStackException);
        
    }
    
    /**
     * This test method will test the clear() method
     * Adding 3 strings should result in the topNode being
     * null and the stack being empty
     */
    @SuppressWarnings("unchecked")
    public void testClear() {
        //Adding 3 Strings
        stack.push((T) "Banana");
        stack.push((T) "Apple");
        stack.push((T) "Carrot");
        
        //isEmpty() should be false
        assertFalse(stack.isEmpty());
        
        //TopNode should not be null
        assertNotNull(stack.peek());
        
        //Clear stack
        stack.clear();
        
        //isEmpty() should be true
        assertTrue(stack.isEmpty());
        
        //Peeking top Node should throw an EmptyStackException
        Exception exception = null;
        try
        {
            stack.peek();
            fail("peek() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("peek() is throwing the wrong type of exceptions",
                   exception instanceof EmptyStackException);
    }
        
    
    /**
     * This test method will test the pop() method
     * Stack is initially empty so pop should throw an EmptyStackException
     */
    public void testPop() {
        //Calling pop() to remove the topNode should throw
        //an EmptyStackException. Will also test isEmpty()
        Exception exception = null;
        try
        {
            stack.pop();
            fail("pop() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("pop() is throwing the wrong type of exceptions",
                   exception instanceof EmptyStackException);
    }
    
    /**
     * This test method will test the pop() method
     * Will also test push(), isEmpty(), and size()
     * A single String will be pushed and then popped
     */
    @SuppressWarnings("unchecked")
    public void testPop2() {     
        //Adding a String "Banana" to stack
        stack.push((T) "Banana");
        
        //Size should now be 1
        assertEquals(1, stack.size());
        
        //Stack is popped, should return the String "Banana"
        assertEquals("Banana", stack.pop());
        
        //Size should now be 0
        assertEquals(0, stack.size());
    }
    
    /**
     * This test method will test the pop() method
     * Will also test push(), isEmpty(), and size()
     * Multiple Strings will be added and popped to make sure that
     * the stack behaves properly
     */
    @SuppressWarnings("unchecked")
    public void testPop3() {
        //Adding 3 Strings to the stack
        stack.push((T) "Banana");
        stack.push((T) "Apple");
        stack.push((T) "Carrot");
        assertEquals(3, stack.size());
        
        //Pop should remove the Strings in inverse order in
        //which they were added. Size should decrement after 
        //each removal
        assertEquals(stack.pop(), "Carrot");
        assertEquals(stack.size(), 2);
        assertEquals(stack.pop(), "Apple");
        assertEquals(stack.size(), 1);
        assertEquals(stack.pop(), "Banana");
        
        //Stack should now be empty
        assertTrue(stack.isEmpty());
    }
    
    /**
     * This test method will test the peek() method
     * Multiple Strings will be added and then peek() will
     * be called to make sure that the proper String is on top
     */
    @SuppressWarnings("unchecked")
    public void testPeek() {
        //Adding 3 Strings to the stack
        stack.push((T) "Banana");
        stack.push((T) "Apple");
        stack.push((T) "Carrot");
        
        //Top String should be the String pushed last ("carrot")
        assertEquals(stack.peek(), "Carrot");
        
        //Removing a String should leave Apple at the top
        stack.pop();
        assertEquals(stack.peek(), "Apple");
        
        //Removing another String should leave Banana at the top
        stack.pop();
        assertEquals(stack.peek(), "Banana");
    }
    
    /**
     * This test method will test the toString() method
     * Multiple String will be added to see if the toString()
     * method returns the proper String
     */
    @SuppressWarnings("unchecked")
    public void testToString() {
        //Adding 3 Strings to the stack
        stack.push((T) "Banana");
        stack.push((T) "Apple");
        stack.push((T) "Carrot");
        
        //ToString() should return from the top of the stack to the
        //bottom of the stack (so lastPush to firstPush).
        assertEquals("[Carrot, Apple, Banana]", stack.toString());
    }
    
    /**
     * This test method will test the equals() method.
     * Will check that True is returned when stack is checked
     * for equality against itself
     */
    public void testEquals() {
        assertTrue(stack.equals(stack));
    }

    /**
     * This test method will test the equals() method.
     * Will check that False is returned when stack is checked
     * for equality against null
     */
    public void testEquals2() {
        assertFalse(stack.equals(null));
    }
    
    /**
     * This test method will test the equals() method
     * Will check that False is returned when stack is 
     * checked for equality against a testObject of a 
     * different class
     */
    public void testEquals3() {
        Object testObject = new Object();
        assertFalse(stack.equals(testObject));
    }
    
    /**
     * This test method will test the equals() method
     * Will check that False is returned when stack is
     * checked for equality against a stack of different 
     * size
     */
    @SuppressWarnings("unchecked")
    public void testEuqals4() {
        //Adding 1 String to stack
        stack.push((T) "Peanut");
        
        //Adding 2 Strings to a different Stack
        LinkedStack<T> testStack = new LinkedStack<T>();
        testStack.push((T) "Peanut");
        testStack.push((T) "Apples");
        
        //Stacks should not be equal in size...
        assertNotSame(testStack.size(), stack.size());
        
        
        //So testing the stack for equality against each other
        //should return false
        assertFalse(stack.equals(testStack));
    }
    
    /**
     * This test method will test the equals() method
     * Will check that False is returned when two stacks that
     * are checked for equality have the same size, but not the same
     * order of Strings
     */
    @SuppressWarnings("unchecked")
    public void testEquals5() {
        //Adding 3 Strings to stack
        stack.push((T) "Peanut");
        stack.push((T) "Apples");
        stack.push((T) "Carrot");
        
        //Adding 3 Strings to a different Stack
        LinkedStack<T> testStack = new LinkedStack<T>();
        testStack.push((T) "Chocolate");
        testStack.push((T) "Apples");
        testStack.push((T) "Carrot");
        
        //Stacks should be equal in size...
        assertEquals(testStack.size(), stack.size());
        
        
        //But should not be equal since the bottom Strings
        //differ
        assertFalse(stack.equals(testStack));
    }
    
    /**
     * This test method will test the equals() method
     * Will check that True is returned when two stacks that
     * are checked for equality have the same size, and the same
     * entries at every level of the stack
     */
    @SuppressWarnings("unchecked")
    public void testEquals6() {
        //Adding 3 Strings to stack
        stack.push((T) "Peanut");
        stack.push((T) "Apples");
        stack.push((T) "Carrot");
        
        //Adding 3 Strings to a different Stack
        LinkedStack<T> testStack = new LinkedStack<T>();
        testStack.push((T) "Peanut");
        testStack.push((T) "Apples");
        testStack.push((T) "Carrot");
        
        
        //Stacks should be equal in size...
        assertEquals(testStack.size(), stack.size());
        
        //And should be Equal since the each level of the stack is the
        //same
        assertTrue(stack.equals(testStack));
        
        //Double Checking. If the stacks are equal their toString() methods
        //should be equal
        assertFuzzyEquals(testStack.toString(), stack.toString());
    }
}
