package coursesTest;

import java.io.*;

public class IO {

    public MyExpression[] readObjects() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Expressions.dat"))) {
            return (MyExpression[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeObjects(MyExpression[] expression) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Expressions.dat"))) {
            oos.writeObject(expression);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
