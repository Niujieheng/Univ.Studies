public class UserImpl implements IUser{
    public UserImpl(){

    }

    @Override
    public void show(){
        System.out.println("展示");
    }

    @Override
    public void create() {
        System.out.println("新建");
    }

    @Override
    public void update() {
        System.out.println("更新");
    }
}
