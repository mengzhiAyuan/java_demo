package com.naruto.java;

import java.io.File;
import java.io.IOException;

/**
 * @author ：mengzhiayuan
 * @description：
 *
 * @date ：2021/2/9 15:36
 */
public class IoStream {
    public static void main(String[] args) {
//        try {
//            Stream.test1();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Stream.test2();
        FindJpg.test();
    }
}
class Stream{
    //文件的创建
    public static void test1() throws IOException {
        File file1=new File("hi.txt");
        if(!file1.exists()) {
            file1.createNewFile();
            System.out.println("创建成功");
        }else{
            file1.delete();
            System.out.println("删除成功");
        }
        System.out.println(file1.getName());
        System.out.println(file1.length());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.isFile());
        String[] list = file1.list();
        System.out.println(list);
    }
    //文件目录的创建
    public static void test2(){
        File file2=new File("d:\\iotest\\io1\\io2");
        boolean mkdir = file2.mkdir();
        if(mkdir){
            System.out.println("创建成功file2");
        }
        File file3=new File("d:\\iotest\\io1\\io2");
        boolean mkdirs = file3.mkdirs();
        if(mkdirs){
            System.out.println("创建成功file3");
        }
    }
}
//判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
class FindJpg{
    public static void test(){
        File fileGpg=new File("E:\\360MoveData\\Users\\lenovo\\Pictures");
        File[] list = fileGpg.listFiles();
        for(File e:list){
            System.out.println(e);
        }
        System.out.println("*********************");
        for(File e:list){
            if(e.getName().endsWith(".jpg")){
                System.out.println(e);
            }
        }
    }
}
