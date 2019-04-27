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
    /**
     * user interface.
     */
    public static void ui() {
        Stack s = new Stack();
        while (true) {
            System.out.println("Please choose an action");
            System.out.println("-----------------------");
            System.out.println("1- Set a stack \n"
            + "2- Push onto the stack \n"
                    + "3- Pop from the stack \n"
                    + "4- Get the peak \n"
                    + "5- Get size \n"
                    + "6- Check if the stack is empty \r\n"
                    + "7- Convert from Infix to Postfix and evaluate");
            System.out.println("============================================");
            Scanner scan = new Scanner(System.in);
            int action = scan.nextInt();
            scan.nextLine();
            if (action == 1) {
                s = new Stack();
            } else if (action == 2) {
                int value = scan.nextInt();
                s.push(value);
            } else if (action == 3) {
                System.out.println(s.pop());
            } else if (action == 4) {
                if (s.peek() == "The stack is empty") {
                    System.out.println(s.peek());
                } else {
                    System.out.println("peak = " + s.peek());
                }

            } else if (action == 6) {
                if (s.isEmpty()) {
                    System.out.println("The Stake is empty");
                } else {
                    System.out.println("The Stake is NOT empty");
                }
            } else if (action == 5) {
                System.out.println("size = " + s.size());
            } else if (action == 7) {
                ExpressionEvaluator exp = new ExpressionEvaluator();
                System.out.println("Please Enter the infix expression");
                String x = scan.nextLine();
                String f = exp.infixToPostfix(x);
                System.out.print("Postfix = ");
                for (int i = 0; i < f.length(); i++) {
                    System.out.print(f.charAt(i));
                }
                System.out.print("\n");
                System.out.println("The value = " + exp.evaluate(f) + "\n");
            } else {
                System.out.println("Please choose number from 1 to 7 only");
            }
        }
    }
}
