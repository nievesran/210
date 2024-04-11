
package delimetermatching;

import java.util.Arrays;


public class Array {

    public int maxSize; //size of stack array
    public char[] array; //the stack
    public int top; //top of stack
    
    public Array(int s){ //constructor
    
    maxSize = s;  //set array size
    array  = new char [maxSize]; //create array
    top = -1; //no items yet
    
    } //end constructor
    
    public void push (char j){ //put item on top of stack
    
    array[++top] = j; //increment top then insert
    
    }//end push
    
    public char pop () { //take item from top
    
        return array[top--]; //access item, decrement top
    
    } //end pop
    
    public boolean isEmpty(){ //true if stack is empty 

        return (top == -1 );
    
    } //end isEmpty
    
    public boolean isFull() { //true if stack is full
    
        return (top == maxSize - 1);
    
    } //end isFull
    
    public void print() { // Prints out array, mostly for testing
    
          System.out.println(Arrays.toString(array));
    
    } //end print


} //end array

