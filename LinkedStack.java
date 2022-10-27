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

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * This class creates a LinkedStack where Nodes are arranged
 * from top to bottom and can be removed, or Nodes can be added to 
 * the top
 * 
 * @author Mason Dooley
 * @version 2022.10.14
 * @param <T> Generic
 *
 */
public class LinkedStack<T> implements StackInterface<T> {

    //Fields
    private int size;
    private Node<T> topNode;
    
    /**
     * Constructor. Initializes the size and topNode fields.
     */
    public LinkedStack() {
        size = 0;
        topNode = null;
    }
    
    /**
     * This method removes all entries from the LinkedStack
     * by setting the topNode to null
     */
    @Override
    public void clear() {
        topNode = null;
        size = 0;
    }

    /**
     * This method determines if the LinkedStack is empty
     * by looking at its size field
     * 
     * @return boolean if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        //A size equal to 0 means the stack is empty
        return size == 0;
    }

    /**
     * This method views the data of the Node at the top
     * of the stack
     * 
     * @return T data of the Node
     * @throws EmptyStackException
     *                      if the stack is empty
     */
    @Override
    public T peek() {
        
        //An empty stack will throw an EmptyStackException() 
        //as there are no Nodes to peek
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        //Data at the top Node
        return topNode.getData();
    }

    /**
     * This method removes the top Node from the stack
     * 
     * @return T data of the Node that was removed
     * @throws EmptyStackException
     *                   if the stack is empty
     */
    @Override
    public T pop() {
        
        //An empty stack will throw an EmptyStackException() 
        //as there are no Nodes to pop
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        //Store the data of the topNode to return later
        T topData = topNode.getData();
        
        //Remove topNode from stack and decrement size    
        topNode = topNode.getNextNode();
        size--;
        
        //Data of the Node that was removed
        return topData;
    }

    /**
     * This method adds a Node to the top of the stack
     * @param newData Data that is being added as a newNode
     */
    @Override
    public void push(T newData) {
        
        //Create a new Node that contains data arg0
        Node<T> temp = new Node<T>(newData);
        
        //points temp to topNode (current stack)
        temp.setNextNode(topNode);
        
        //Set the LinkedStack equal to the stack with arg0 at the top
        topNode = temp;
        
        //Increment the bag size
        size++;
    }
    
    /**
     * This method gets the current size of the stack
     * 
     * @return int current size of the stack
     */
    public int size() {
        return size;
    }

    /**
     * Will test if two LinkedStacks are equal to each other
     * 
     * @param obj
     *          Will be compared against this.LinkedStack
     *          to see if they are equal
     * @return boolean if the two LinkedStacks are equal
     */
    @SuppressWarnings("unchecked")
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
            
            //Cast LinkedStack class onto parameter
            LinkedStack<T> other = (LinkedStack<T>) obj;
            
            //If the LinkedStacks are not equal in size, they cannot
            //be equal
            if (other.size() != this.size()) {
                return false;
            }
            
            //Making a copy of both the LinkedStacks
            LinkedStack<T> otherCopy = other;
            LinkedStack<T> thisCopy = this;
            
            //Looping through each entry in the LinkedStacks
            while (!isEmpty()) {            
                //If the data in the current top of the LinkedStacks
                //are not equal, the linkedStacks are not equal
                if ((otherCopy.peek()).equals(thisCopy.peek())) {
                    //Remove the top of the current LinkedStacks
                    //and continue to loop through stack
                    otherCopy.pop();
                    thisCopy.pop();
                }   
                else {
                    //Data was not equal, so stacks are not equal
                    return false;
                }
            }
            
            //Iterated through the loop without
            //the top Entries not being equal; the LinkedStacks are equal
            return true;
        }
        
        //obj was not a LinkedStack, so it cannot be equal
        return false;
    }
    
    /**
     * This method returns a String of the entries in the LinkedStack
     * @return String of the LinkedStack's entries
     */
    public String toString() {
        
        StringBuilder entries = new StringBuilder();
        entries.append("[");
        Node<T> top = topNode;
        while (top != null) {
            if (entries.length() > 1) {
                entries.append(", ");
            }
            entries.append(top.getData());
            top = top.getNextNode();
        }
        entries.append("]");
        return entries.toString();
    }
    
    /**
     * This class creates Nodes which will be what make up the 
     * LinkedStack. Nodes contain a data value and point to either
     * another Node or null
     * 
     * @author Mason Dooley
     * @version 2022.10.14
     *
     */
    @SuppressWarnings("hiding")
    private class Node<T> {
        
        //Fields
        private T data;
        private Node<T> next;
        
        /**
         * Constructor. Will initialize the fields which create
         * a Node that contains a data and points
         * 
         * @param data
         * @param next
         */
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        } 
        
        /**
         * Second Constructor for if a Node was created without,
         * a specified next (will imply that next is null).
         * @param dataPortion
         */
        public Node(T data) {
            //Call first constructor which will set next to null
            this(data, null);
        }
        
        /**
         * This method is a getter for next
         * 
         * @return Node<T> the Node that is being pointed to
         */
        public Node<T> getNextNode() {
            return next;
        }
        
        /**
         * This method is a setter for next
         * 
         * @param newNext Node that will be set as the next node
         */
        public void setNextNode(Node<T> newNext) {
            next = newNext;
        }
        
        /**
         * This method is a getter for data
         * 
         * @return T Data of the Node
         */
        public T getData() {
            return data;
        }
        
    }
}
