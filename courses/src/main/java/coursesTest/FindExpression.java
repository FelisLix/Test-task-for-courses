package coursesTest;

import java.io.IOException;

public class FindExpression {

    public void findExpression() throws IOException {
        ReadExpression readExpression = new ReadExpression();
        IO io = new IO();
        System.out.println("Введіть корінь: ");
        double x = readExpression.readX();
        MyExpression[] expressions = io.readObjects();
        for (MyExpression expression : expressions) {
            if (expression.getX() == x) {
                System.out.println(expression);
            }
        }
    }

    public MyExpression[] addInArray(MyExpression expression, MyExpression[] expressions) {
        MyExpression[] newExpressions = new MyExpression[expressions.length + 1];
        System.arraycopy(expressions, 0, newExpressions, 0, expressions.length);
        newExpressions[expressions.length] = expression;
        return newExpressions;
    }

}
