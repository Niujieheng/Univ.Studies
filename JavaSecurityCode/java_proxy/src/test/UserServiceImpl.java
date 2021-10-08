package test;

//抽象类：extends~
//类 可以实现接口 implements 接口
//实现了接口的类 就需要重写接口中的方法~

//多继承 利用接口实现多继承 以下是两个
public class UserServiceImpl implements UserService,TimeService{

    @Override
    public void add(String name) {

    }

    @Override
    public void delete(String name) {

    }

    @Override
    public void update(String name) {

    }

    @Override
    public void query(String name) {

    }

    @Override
    public void timer() {

    }
}
