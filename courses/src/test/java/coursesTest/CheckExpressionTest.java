package coursesTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckExpressionTest {

    @org.junit.jupiter.api.Test
    void checkBracket1() {
        CheckExpression checkExpression = new CheckExpression();
        String expr = "(2*x)+5=17";
        boolean expected = true;
        boolean result = checkExpression.checkBracket(expr);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void checkBracket2() {
        CheckExpression checkExpression = new CheckExpression();
        String expr = "((-1.3*5/x=1.2";
        boolean expected = false;
        boolean result = checkExpression.checkBracket(expr);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void checkOperator1() {
        CheckExpression checkExpression = new CheckExpression();
        String expr = "-1.3**5/x=1.2";
        boolean expected = false;
        boolean result = checkExpression.checkOperator(expr);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void checkOperator2() {
        CheckExpression checkExpression = new CheckExpression();
        String expr = "2*x+5=17";
        boolean expected = true;
        boolean result = checkExpression.checkOperator(expr);
        assertEquals(expected, result);
    }


}