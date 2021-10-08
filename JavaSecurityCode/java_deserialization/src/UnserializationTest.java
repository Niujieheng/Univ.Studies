import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class UnserializationTest {
    public static Object unserialize(String Filename) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Filename));
        Object obj = ois.readObject();
        return obj;
    }

    public static void main(String[] args) throws Exception {
        Person person = (Person) unserialize("ser.bin");
        System.out.println(person);
    }
}