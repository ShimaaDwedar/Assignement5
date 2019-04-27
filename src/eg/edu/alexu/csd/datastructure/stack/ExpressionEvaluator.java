package eg.edu.alexu.csd.datastructure.stack;

/**
 * Converting from infix to postfix and evaluating.
 * @author shimaa kamal
 */
public class ExpressionEvaluator implements IExpressionEvaluator {
    /**
     * To check if the '-' refers to a negative number or operator.
     * @param index refers to the index of '-'
     * @param exp refers to the string
     * @return find if the '-' was a negative number
     */
    public boolean check(final int index, final String exp) {
        boolean find = false;
        if (index == 0) {
            return true;
        }
        for (int i = index - 1; i > -1; i--) {
            if (exp.charAt(i) == ' ') {
                find = true;
            } else {
                if (exp.charAt(i) == '*'
                    || exp.charAt(i) == '+'
                    || exp.charAt(i) == '-'
                    || exp.charAt(i) == '/') {
                    find = true;
                    break;
                } else {
                    find = false;
                    break;
                }
            }
        }
        return find;
    }
    /**
     * Find the operand that has higher precedence.
     * @param x the operator
     * @return number refers to the precedence
     */
    public int better(final char x ){
        int b = 0;
        if (x == '+') {
            b = 1;
        } else if (x == '-') {
            b = 1;
        } else if (x == '*') {
            b = 2;
        } else if (x == '/') {
            b = 2;
        } else if (x == '(') {
            b = 3;
        }
        return b;
    }
    /**
     * To make sure that the expression is valid.
     * @param exp the expression wanted to be converted
     * @return if the exp is valid or not
     */
    public boolean valid(final String exp) {
        Stack open = new Stack();
        for (int i = 0; i < exp.length(); i++) {
           if (exp.charAt(i) == '(') {
               open.push(exp.charAt(i));
           } else if (exp.charAt(i) == ')') {
               if (open.isEmpty()) {
                   return false;
               } else {
               open.pop();
               }
           }
        }
        if (open.isEmpty()) {
            return true;
        } else {
            return false;
        }
        
    }
    /**
     * convert from infix to Postfix.
     * @param expression to be converted
     * @return the Postfix expression
     */
    public String infixToPostfix(final String expression) {
        if (!valid(expression)) {
            System.out.println("invalid input");
            return null;
        }else {
        String postfix = new String();
        String no = new String();
        Stack operand = new Stack();
        int y = (expression.length()) - 1;
        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))
                    || ((expression.charAt(i) == '-')
                            && ((check(i, expression))))) {
                int sign = 0;
                if ((expression.charAt(i) == '-')) {
                    no = no + expression.charAt(i);
                    sign = 1;
                }
                for (int j = i; j < expression.length(); j++) {
                    if (sign == 1 && j == i) {
                        j = j + 1;
                    }
                    if (Character.isDigit(expression.charAt(j))) {
                        no = no + expression.charAt(j);
                    } else {
                        postfix = postfix + " " + no;
                        no = "";
                        i = j - 1;
                        break;
                    }
                    if (j == y) {
                        postfix = postfix + " " + no;
                        no = "";
                        i = j;
                    }
                }
            } else if (expression.charAt(i) != ' ') {

                if (operand.isEmpty() || (char) operand.top.value == '(') {
                    operand.push(expression.charAt(i));
                    } else if (expression.charAt(i) == ')') {
                        while ((char) operand.top.value != '(') {
                            postfix = postfix + " " + operand.peek();
                            operand.pop();
                        }
                        operand.pop();
                    } else if (better(expression.charAt(i))
                            > better((char) operand.top.value)) {
                        operand.push(expression.charAt(i));
                    } else {
                        while (better(expression.charAt(i))
                                <= better((char) operand.top.value)
                                && (char) operand.top.value != '(') {
                            postfix = postfix + " " + operand.peek();
                            operand.pop();
                            if (operand.top == null) {
                                break;
                            }
                        }
                        operand.push(expression.charAt(i));
                    }
            }
        }
        while (operand.top != null) {
            postfix = postfix + " " + operand.peek();
            operand.pop();
        }
        postfix = postfix.substring(1, postfix.length());
        
        return postfix;
        }
    }
    /**
     * evaluating the expression.
     * @param expression to be evaluated
     * @return the value of the expression
     */
    public int evaluate(final String expression) {
        Stack eva = new Stack();
        String[] splited = expression.split("\\s+");
        for (int i = 0; i < splited.length; i++) {
            if (!splited[i].equals("+")
                    && !splited[i].equals("-")
                    && !splited[i].equals("*")
                    && !splited[i].equals("/")) {
                eva.push(Float.parseFloat(splited[i]));
            } else {
                float x = (float) eva.pop();
                float y = (float) eva.pop();
                if (splited[i].equals("+")) {
                    eva.push(y + x);
                } else if (splited[i].equals("-")) {
                    eva.push(y - x);
                } else if (splited[i].equals("*")) {
                    eva.push(y * x);
                } else if (splited[i].equals("/")) {
                   if (x == 0) {
                        throw new ArithmeticException();
                    } else {
                    eva.push((float) y / x);
                    }
                }
            }
        }
        return (int) (float) eva.top.value;
        }
}
