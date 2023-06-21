package coursesTest;

import java.util.Stack;

public class CheckExpression {

    //2. Перевіряти введене рівняння на коректність розміщення дужок;
    public boolean checkBracket(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            if (currentChar == '(') {
                stack.push(currentChar);
            } else if (currentChar == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }

        }
        return stack.isEmpty();
    }

    //3. Перевіряти коректність введеного виразу
    public boolean checkOperator(String expression) {
        char[] charArray = expression.toCharArray();
        for (int i = 0; i < expression.length(); i++) {
            if (charArray[i] == '-') {
                if (i == 0 || (charArray.length - 1 == i) || (isOperator(charArray[i + 1])) || (charArray[i + 1] == ')') || i == expression.length() - 1) {
                    return false;
                }
            }
            if (isOperator(charArray[i])) {
                if (i == 0 || i == expression.length() - 1 || (isOperator(charArray[i + 1])) || (isOperator(charArray[i - 1]))
                        || (charArray[i - 1] == '(') || (charArray[i + 1] == ')')) {
                    return false;
                }
            }
        }
        return true;
    }


    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '*' || ch == '/';
    }



}
