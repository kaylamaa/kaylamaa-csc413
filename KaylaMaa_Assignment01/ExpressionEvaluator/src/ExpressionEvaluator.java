import java.util.Scanner;
import java.util.Stack;

class ExpressionDriver {
    public static void main(String[] args) {
        System.out.println("---------------------Welcome to Expression Evaluator---------------------");
        // creating a while loop to see if the user wants to continue with computing, if not, program ends
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Would you like to compute an expression? Yes or No: ");
            String input = scanner.nextLine();

            if (input.toLowerCase().equals("no")) { //user answers no --> exit program
                System.out.println();
                System.out.println("Thank you for using Expression Evaluator!");
                System.out.println("Ending program....");
                break;
            }
            if (input.toLowerCase().equals("yes")) { //if user answers yes, begin taking inputs and compute
                double a, b, c, d;
                //prompting user to input values a,b,c,d to evaluate
                System.out.print("Enter a value for variable 'a': ");
                a = scanner.nextDouble(); // user input will be saved in variables a,b,c,d
                System.out.print("Enter a value for variable 'b': ");
                b = scanner.nextDouble();
                System.out.print("Enter a value for variable 'c': ");
                c = scanner.nextDouble();
                System.out.print("Enter a value for variable 'd': ");
                d = scanner.nextDouble();

                String infixExpression = "(a+b)*(c+d)"; // setting our predefined expressions
                String postfixExpression = "(ac-b^d+)";

                double infixResult = InfixEvaluator.evaluateInfix(infixExpression, a, b, c, d);
                System.out.println("Value of infix string (a+b)*(c+d) with a = " + (int) a + ", b = " + (int) b + ", c = " + (int) c + ", d = " + (int) d + " is " + (int) infixResult);

                double postfixResult = PostFixEvaluator.evaluatePostfix(postfixExpression, a, b, c, d);
                System.out.println("Value of infix string (ac-b^d+) with a = " + (int) a + ", b = " + (int) b + ", c = " + (int) c + ", d = " + (int) d + " is " + (int) postfixResult);
                System.out.println();
            }
            System.out.println("Please enter a valid input. Try again!");
        }
    }
}
class InfixEvaluator {
    static double evaluateInfix(String str, double a, double b, double c, double d) {
        Stack<Double> valueStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char val = str.charAt(i);

            if (Character.isLetter(val)) {
                // Push value onto value stack based on variable
                switch (val) {
                    case 'a' -> valueStack.push(a);
                    case 'b' -> valueStack.push(b);
                    case 'c' -> valueStack.push(c);
                    case 'd' -> valueStack.push(d);
                }
            } else if (Character.isDigit(val)) {
                // Extract and push numerical value onto value stack
                StringBuilder numToString = new StringBuilder();
                while (i < str.length() && (Character.isDigit(str.charAt(i)) || str.charAt(i) == '.')) {
                    numToString.append(str.charAt(i));
                    i++;
                }
                i--; // Move back one step to account for the extra increment
                valueStack.push(Double.parseDouble(numToString.toString()));
            } else if (val == '(') {
                // Push onto operating stack
                operatorStack.push(val);
            } else if (val == ')') {
                // compute expression when parenthesis ends
                while (operatorStack.peek() != '(') {
                    useOperation(operatorStack.pop(), valueStack);
                }
                operatorStack.pop();
            } else if (isOperator(val)) {
                // beginning to use Pemdas to see which operators are at "higher ranking" to be used first
                while (!operatorStack.isEmpty() && usePemdas(operatorStack.peek()) >= usePemdas(val)) {
                    useOperation(operatorStack.pop(), valueStack);
                }
                operatorStack.push(val);
            }
        }
        // Evaluate remaining expressions
        while (!operatorStack.isEmpty()) {
            useOperation(operatorStack.pop(), valueStack);
        }
        return valueStack.pop();
    }
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int usePemdas(char op) {
        if (op == '+' || op == '-')
            return 1;
        if (op == '*' || op == '/')
            return 2;
        return 0;
    }

    private static void useOperation(char op, Stack<Double> valueStack) {
        double a = valueStack.pop();
        double b = valueStack.pop();
        switch (op) {
            case '+' -> valueStack.push(a + b);
            case '-' -> valueStack.push(a - b);
            case '*' -> valueStack.push(a * b);
            case '/' -> valueStack.push(a / b);
            default -> throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
}

class PostFixEvaluator {
    public static double evaluatePostfix(String str, double a, double b, double c, double d) {
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char val = str.charAt(i);

            if (Character.isLetter(val)) {
                switch (val) {
                    case 'a':
                        stack.push(a);
                        break;
                    case 'b':
                        stack.push(b);
                        break;
                    case 'c':
                        stack.push(c);
                        break;
                    case 'd':
                        stack.push(d);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid variable: " + val);
                }
            } else if (isOperator(val)) {
                double op = stack.pop();
                double op1 = stack.pop();
                double result = useOperation(val, op, op1);
                stack.push(result);
            }
        }
         return stack.pop();
    }

    private static double useOperation(char op, double op1, double op2) {
        return switch (op) {
            case '+' -> op1 + op2;
            case '-' -> op1 - op2;
            case '*' -> op1 * op2;
            case '/' -> op1 / op2;
            case '^' -> Math.pow(op1, op2);
            default -> throw new IllegalArgumentException("Invalid operator: " + op);
        };
    }
    private static boolean isOperator(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/' || val == '^';
    }
}


