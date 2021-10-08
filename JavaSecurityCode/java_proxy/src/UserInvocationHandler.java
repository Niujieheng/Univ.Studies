import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserInvocationHandler implements InvocationHandler {
    //重写的方法 查看InvocationHandler

    //method.invoke会用到user，所以需要传进来一个User
    IUser user;

    //再定义构造函数
    public UserInvocationHandler(){

    }

    //定义有参的构造函数
    public UserInvocationHandler(IUser user){
        this.user=user;
    }
    //外面不管调用什么 invoke捕捉到 当作method传进去 使用相应的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("调用"+method.getName());
        method.invoke(user,args);
        return null;
    }
}
