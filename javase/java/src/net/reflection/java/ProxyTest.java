package net.reflection.java;

/**
 * @author ：mengzhiayuan
 * @description： 静态代理
 * @date ：2021/3/9 10:30
 */
interface FoodFactory{
    void produceFood();
}
//代理类
class ProxyFoodFactory implements FoodFactory{
    private FoodFactory factory;//用被代理类对象进行实例化
    public ProxyFoodFactory(FoodFactory factory){
        this.factory=factory;
    }

    @Override
    public void produceFood() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceFood();
        System.out.println("代理工厂结束工作");
    }
}
//被代理类
class Food_Factory implements FoodFactory{

    @Override
    public void produceFood() {
        System.out.println("食物主公司开始生产食物");
    }
}
public class ProxyTest {
    public static void main(String[] args) {
        Food_Factory food_factory = new Food_Factory();
        ProxyFoodFactory proxyFoodFactory = new ProxyFoodFactory(food_factory);
        proxyFoodFactory.produceFood();
    }
}
