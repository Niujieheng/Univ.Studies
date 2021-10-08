public class UserProxy implements IUser{
    IUser user;
    public UserProxy(){

    }

    public UserProxy(IUser user){
        this.user = user;
    }

    @Override
    public void show(){
        user.show();
        System.out.println("调用了show");
    }

    @Override
    public void create() {
        System.out.println("调用了create");
    }

    @Override
    public void update() {
        System.out.println("调用了update");
    }

//    public void execute() {
//        method.invoke();
//    }
//    想用反射，但是不知道外部调用了什么方法。
}
