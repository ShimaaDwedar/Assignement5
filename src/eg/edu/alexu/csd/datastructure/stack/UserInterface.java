package eg.edu.alexu.csd.datastructure.stack;

import java.util.Scanner;
/**
 * user interface.
 */

public class UserInterface {

    public static void main(String[] args) {
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
                    System.out.println("Enter the value");
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
