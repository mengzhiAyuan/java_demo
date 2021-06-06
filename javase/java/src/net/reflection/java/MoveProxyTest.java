package net.reflection.java;

/**
 * @author ：mengzhiayuan
 * @description：动态代理
 * @date ：2021/3/9 10:53
 */
interface human{
    String getBelief(String s);
    void eat(String food);
}
class superMan implements human{

    @Override
    public String getBelief(String s) {
        return s;
    }

    @Override
    public void eat(String food) {
        System.out.println("喜欢的食物"+food);
    }
}
//要实现动态代理，需要解决的问题？
//问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
//问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类的同名方法
public class MoveProxyTest {
    public static void main(String[] args) {

    }
}
