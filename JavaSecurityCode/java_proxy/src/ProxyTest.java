import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        IUser user = new UserImpl();
        //user.show();
        //静态代理   有时需要调用一个方法，需要记录它，但是日志方法和本身(UserImpl)没有关系，所以放到外面代理类(UserProxy)里面去实现。
//        IUser userProxy = new UserProxy(user);
//        userProxy.show();
        //如果接口变了 那么代理也要变 如果是重复的 那么也会重复很多

        //动态代理
        //源码里没有Proxy这个类，但是要加进来，需要一个类加载classloader、要代理的接口、要做的事情(打印UserProxy)
        //Proxy.newProxyInstance(user.getClass().getClassLoader(), user.getClass().getInterfaces(),);
        InvocationHandler userinvocationhandler = new UserInvocationHandler(user);
        // 强制转换（IUser）
        IUser userProxy = (IUser)Proxy.newProxyInstance(user.getClass().getClassLoader(),user.getClass().getInterfaces(),userinvocationhandler);
        userProxy.show();



    }
}