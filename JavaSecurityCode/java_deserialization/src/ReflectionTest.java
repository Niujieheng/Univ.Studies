import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) throws Exception {

        Person person = new Person();
        //自己写好一个类，编译到硬盘中，会生成Person.Class 对应的就是这里的Class 相当与原型
        //这里是person类，也可以新建一个student类，就写成student.getClass，与Person.Class一样都属于Class类型，但是值是不同的
        Class c = person.getClass();
        //Class最重要的是有一个forName方法 传一个Person就会返回Person的原型类
//        Class.forName("Person");
//        System.out.println(Class.forName("Person"));

        //反射就是操作Class

        //从原型class里面实例化对象
        //c.newInstance(); //新建一个对象 调用无参的构造方法
        //c.getConstructor();//获取它的构造方法 有参的
        Constructor personconstructor = c.getConstructor(String.class,int.class); //class类型的参数  //现有的原型c 然后调用它的构造方法
        Person p = (Person) personconstructor.newInstance("abc",22);
        System.out.println(p);

        //获取类里面的属性
        //c.getField() c.getFields() c.getDeclaredField() c.getDeclaredFields()    s指复数 Declared能打印出私有属性
        //数组
        Field[] personfields1 = c.getFields();
        for(Field f:personfields1){
            System.out.println(f); //打印出来是 public java.lang.String Person.name  因为name是public而name是private所以没打出来
        }

        Field[] personfields2 = c.getDeclaredFields();
        for(Field f:personfields2){
            System.out.println(f); //打印出来是 public java.lang.String Person.name  private int Person.age
        }
        //变量名
        Field namefield1 = c.getField("name"); //公有
        namefield1.set(p,"abcd");
        System.out.println(p);

        Field namefield2 = c.getDeclaredField("age");//私有
        namefield2.setAccessible(true);
        namefield2.set(p,25);
        System.out.println(p);

        //调用类里面的方法
//        Method[] personmehods = c.getMethods();
//        for(Method m:personmehods){
//            System.out.println(m);  //会打印出很多方法如equals、hashCode等都是继承Object，还会有自己写的action方法
//        }
        Method actionmethod = c.getMethod("action", String.class);
        actionmethod.invoke(p,"aaaaaaa");
    }
}