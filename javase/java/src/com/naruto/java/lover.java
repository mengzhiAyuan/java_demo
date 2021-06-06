package com.naruto.java;

/**
 * @author ：mengzhiayuan
 * @description：枚举类
 * 1. 私有化类的构造器，保证不能在类的外部创建其对象
 * 2. 在类的内部创建枚举类的实例。声明为：public static final
 * 3. 对象如果有实例变量，应该声明为private final，并在构造器中初始化
 * $ 使用enum定义枚举类
 *      使用 enum 定义的枚举类默认继承了 java.lang.Enum类，因此不能再
 * 继承其他类
 * 枚举类的构造器只能使用 private 权限修饰符
 * 枚举类的所有实例必须在枚举类中显式列出(, 分隔 ; 结尾)。列出的
 * 实例系统会自动添加 public static final 修饰
 * 必须在枚举类的第一行声明枚举类对象
 * JDK 1.5 中可以在 switch 表达式中使用Enum定义的枚举类的对象
 * 作为表达式, case 子句可以直接使用枚举值的名字, 无需添加枚举
 * 类作为限定。
 * @date ：2021/2/5 12:34
 */
public class lover {
    public static void main(String[] args) {
        System.out.println(lovers.NARUTO_19.toString());
        lovers[] values = lovers.values();
        for(lovers e:values){
            System.out.println(e);
            e.show();
        }
    }
}
//自定义枚举类
//class lovers{
//    private final String LoverName;//lover的名称
//    private final String LoverDetails;//lover的描述
//    private lovers(String Name,String details){
//        this.LoverName = Name;
//        this.LoverDetails = details;
//    }
//    public static final lovers NARUTO_15 = new lovers("15岁的鸣人", "阳光");
//    public static final lovers NARUTO_17 = new lovers("13岁的鸣人", "可爱");
//    public static final lovers NARUTO_19 = new lovers("19岁的鸣人", "恋爱");
//    public String getName(){
//        return LoverName;
//    }
//    public String getDetails(){
//        return LoverDetails;
//    }
//
//    @Override
//    public String toString() {
//        return "lovers{" +
//                "LoverName='" + LoverName + '\'' +
//                ", LoverDetails='" + LoverDetails + '\'' +
//                '}';
//    }
//}
//enum实现枚举类，同时实现了接口
interface Foo{
    void show();
}
enum lovers implements Foo{
    NARUTO_15("15岁的鸣人", "阳光"){
        @Override
        public void show() {
            System.out.println("永远向前");
        }
    },
    NARUTO_17("13岁的鸣人", "可爱"){
        @Override
        public void show() {
            System.out.println("积极向上");
        }
    },
    NARUTO_19("19岁的鸣人", "恋爱"){
        @Override
        public void show() {
            System.out.println("my sun");
        }
    };
    private final String LoverName;//lover的名称
    private final String LoverDetails;//lover的描述
    private lovers(String Name,String details){
        this.LoverName = Name;
        this.LoverDetails = details;
    }
    public String getName(){
        return LoverName;
    }
    public String getDetails(){
        return LoverDetails;
    }
}

