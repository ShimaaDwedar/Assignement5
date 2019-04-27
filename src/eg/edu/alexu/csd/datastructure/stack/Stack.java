package eg.edu.alexu.csd.datastructure.stack;
import java.util.Scanner;

/**
 * Implementation of the stack.
 * @author shimaa_kamal
 */
public class Stack implements IStack {
    /**
     * value refers to the value on the node.
     */
    
    public Object value;
    /**
     * next refers to the next node.
     */
    public Stack next;
    /**
     * top refers to the first node in the stack.
     */
    public Stack top = null;
    /**
     * size refers to the size of the stack.
     */
    private int size = 0;

    /**
     * Removes the element at the top of stack and returns that element.
     *
     * @return top of stack element, or through exception if empty
     */
    public Object pop() {
        size--;
        Object temp = new Object();
        try {
            temp = top.value;
            top = top.next;
        } catch (Exception e) {
            return "The stack is empty";
        }

        return temp;
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param element to insert
     */
    public void push(final Object element) {
        Stack newTop = new Stack();
        newTop.value = element;
        newTop.next = top;
        top = newTop;
        size++;
    }

    /**
     * Get the element at the top of stack without removing it from stack.
     *
     * @return top of stack element, or through exception if empty
     */
    public Object peek() {
        Object peek = new Object();
        try {
            peek = top.value;

        } catch (Exception e) {
            return "The stack is empty";
        }
        return peek;
    }

    /**
     * Tests if this stack is empty.
     *
     * @return true if stack empty
     */
    public boolean isEmpty() {
        boolean check = false;
        if (top == null) {
            check = true;
        }
        return check;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return number of elements in the stack
     */
    public int size() {
        return size;
    }
 
}
