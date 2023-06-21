package coursesTest;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        ReadExpression readExpression = new ReadExpression();
        CheckExpression checkExpression = new CheckExpression();
        Calculate calculate = new Calculate();
        IO io = new IO();
        FindExpression findExpression = new FindExpression();

        MyExpression[] expressions = new MyExpression[]{new MyExpression("0.0", 0.0)};
        int o;
        while ((o = mainMenu()) != 0) {
            switch (o) {
                case 1 -> {
                    System.out.println("Введіть рівняння: ");
                    String expression = readExpression.readExpression();

                    System.out.println("Дужки записано правильно: " + checkExpression.checkBracket(expression));
                    System.out.println("Знаки записано правильно: " + checkExpression.checkOperator(expression));

                    if (checkExpression.checkBracket(expression) && checkExpression.checkOperator(expression)) {
                        System.out.println("Введіть корінь: ");
                        double x = readExpression.readX();
                        if (calculate.calculate(expression, x)) {
                            expressions = findExpression.addInArray(new MyExpression(expression, x), expressions);
                            io.writeObjects(expressions);
                            System.out.println("Записано у файл");
                        } else {
                            System.out.println("Не є коренем");
                        }
                    }
                }
                case 2 -> findExpression.findExpression();
            }
        }
    }

    private int mainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                1. Ввести нове рівняння;
                2. Знайти рівняння за коренем;
                0. Exit
                """);
        int res = scanner.nextInt();
        scanner.nextLine();
        return res;
    }
}