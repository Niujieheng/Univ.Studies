import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Person implements Serializable {
    // private transient String name;
    public String name;
    private int age;

    public static int id;
    static {
        System.out.println("静态代码块");
    }

    public static void staticAction() {
        System.out.println("静态方法");
    }

    {
        System.out.println("构造代码块"); //不管调用哪种方法，都会调用构造代码块
    }

    public Person() {
        System.out.println("无参Persson");
    }

    public Person(String name, int age) {
        System.out.println("有参Person");
        this.name = name;
        this.age = age;
    }

    @Override // 注解 有功能的注释 重写
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        Runtime.getRuntime().exec("calc");
    }


    public void action(String act) {
        System.out.println(
                act
        );
    }
}
