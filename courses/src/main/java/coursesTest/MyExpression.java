package coursesTest;

import java.io.Serializable;

public class MyExpression implements Serializable {
    private String expression;
    private Double x;

    public MyExpression(String expression, double x) {
        this.expression = expression;
        this.x = x;
    }

    public Double getX() {
        return x;
    }

    @Override
    public String toString() {
        return expression + " x= " + x;
    }

}
