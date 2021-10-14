import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoadClass {

    public static void main(String[] args) throws Exception{
        //new Person();


        //new Person();      //不管调用哪种方法，都会调用构造代码块 打印：静态代码块、构造代码块、无参Persson
        //new Person("a",22);//打印：静态代码块、构造代码块、有参Person
        //Person.staticAction();//静态方法，跟对象相关的就不在调用了，打印：静态代码块、静态方法
        //Person.id = 1; //打印：静态代码块
        //Class c = Person.class;//只进行加载，没有进行初始化，就没有进行打印。所以没有打印出结果。
        //Class.forName("Person");//打印：静态代码块；进行了初始化的操作。

        //ClassLoader cl = ClassLoader.getSystemClassLoader(); //ClassLoader抽象类，不能进行实例化。但有一个静态方法，获取系统的classloader
        //Class.forName("Person",false,cl); //不进行初始化，不调用静态方法。

//        Class c = Class.forName("Person",false,cl);//然后就可以进行实例化，正常实例化后，就可以加载,initializa:是否进行初始化。
//        c.newInstance();//打印：静态代码块、构造代码块、无参Persson

        //System.out.println(cl); //打印出来：jdk.internal.loader.ClassLoaders$AppClassLoader@2437c6dc 双向委派

        //本地文件测试，类加载机制，编辑路径和文件目录，会运行对应的程序。

//        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL("file:///D:\\tep\\")});
//        Class c = urlClassLoader.loadClass("Test");
//        c.newInstance();

        //用http进行测试，在对应的程序目录下启动一个http请求。截图在漏洞学习笔记中！
//        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL("http://localhost:9999/")});
//        Class c = urlClassLoader.loadClass("Test");
//        c.newInstance();

        //也可以用jar包进行加载
//        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL("jar:file:///D:\\tep\\test.jar/")});
        //路径也可以换成"jar:http://localhost:9999/test.jar/"
//        Class c = urlClassLoader.loadClass("test");
//        c.newInstance();

        //defineClass 是protected 所以需要反射调用
//        ClassLoader cl = ClassLoader.getSystemClassLoader();
//        Method defineClassMethod = ClassLoader.class.getDeclaredMethod("defineClass",String.class, byte[].class, int.class, int.class);
//        defineClassMethod.setAccessible(true);
//        byte[] code = Files.readAllBytes(Paths.get("D:\\tep\\Test.class"));
//        Class c = (Class) defineClassMethod.invoke(cl,"Test",code,0,code.length);
//        c.getDeclaredConstructor().newInstance();

        //unsafe.defindClass在JDK11后已经被删掉了！
//        ClassLoader cl = ClassLoader.getSystemClassLoader();
//        byte[] code = Files.readAllBytes(Paths.get("D:\\tep\\Test.class"));
//        Class c = Unsafe.class;
//        Field theUnsafeField = c.getDeclaredField("theUnsafe");
//        theUnsafeField.setAccessible(true);
//        Unsafe unsafe = (Unsafe) theUnsafeField.get(null);
//        Class c2 = unsafe.defineClass("Test",code,0,code.length,cl,null);
//        c2.newInstance();


        // 1. JDK 动态代理 Proxy 接口
        // 2. asm cglib
        //biubiu、oa-shiro-url



        //unsafe.d 测试使用
//        ClassLoader cl = ClassLoader.getSystemClassLoader();
////        byte[] code = Files.readAllBytes(Paths.get("D:\\tep\\Test.class"));
//        byte[] code = Files.readAllBytes(Paths.get("E:\\JetBrains\\Javacode\\Java_LoadClassTest\\src\\foo\\Test.class"));
//        MethodHandles.Lookup lookup = MethodHandles.lookup();
//        MethodHandles.Lookup privateLookup = MethodHandles.privateLookupIn(foo.LoadClassTest.class, lookup);
////        byte[] fooQuxClassFile = createClassFileForFooQuxClass();
//        privateLookup.defineClass(code);


    }

}
