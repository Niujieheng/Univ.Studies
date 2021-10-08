package test;

//interface 定义的关键字,  接口都需要有实现类。
public interface UserService {

    //常量 public static final 一般不这样在接口中定义常量
    //public static final int age = 99;
    int Age = 99;

    //接口中的所有定义的方法其实都是抽象的 public abstract
    //public abstract void run();
    void add(String name);
    void delete(String name);
    void update(String name);
    void query(String name);
}

//作用：
//    1.约束
//    2.定义一些方法，让不同的人实现  如动态代理
//    3.方法是 public abstract
//    4.常量是 public static final
//    5.接口不能被实例化，接口中没有构造方法。（都不是类）
//    6.implements可以实现多个接口
//    7.实现接口的类，必须要重写里面的方法