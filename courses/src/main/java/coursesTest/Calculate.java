package coursesTest;

import net.objecthunter.exp4j.ExpressionBuilder;

public class Calculate {
    private String expr1;
    private String expr2;

    private void getSmallExpressions(String expression, double x) {
        String newExpr = expression.replace("x", Double.toString(x));
        String[] expressions = newExpr.split("=");
        setExpr1(expressions[0].trim());
        setExpr2(expressions[1].trim());
    }

    public boolean calculate(String expression, double x) {
        getSmallExpressions(expression, x);
        double e1 = new ExpressionBuilder(expr1).build().evaluate();
        double e2 = new ExpressionBuilder(expr2).build().evaluate();
        return Math.abs(e1 - e2) < 10e-9;
    }


    public void setExpr2(String expr2) {
        this.expr2 = expr2;
    }

    public void setExpr1(String expr1) {
        this.expr1 = expr1;
    }

}
