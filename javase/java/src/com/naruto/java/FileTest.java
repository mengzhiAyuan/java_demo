package com.naruto.java;

import java.io.*;

/**
 * @author ：mengzhiayuan
 * @description：IO流
 * @date ：2021/2/9 20:38
 */
public class FileTest {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
       test4();
//        test5();
    }
    public static void test1(){
        FileReader fr=null;
        try {
            //实例化File对象，表明要操控的文件
            File file=new File("hi.txt");
            //提供具体的流
            fr=new FileReader(file);
            //数据的读入
            //read():返回读入的一个字符，如果达到文件末尾，返回-1
            int data;
            while((data=fr.read())!=-1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void test2(){
        FileReader fr=null;
        try {
            File file=new File("hi.txt");
            fr=new FileReader(file);
            //读入的操作，read(char[] cbuf):返回每次读入cbuf数组的字符个数，如果到达文件末尾，返回-1
            //可以将cbuf看成送快递的小车
            char[] cbuf=new char[5];
            int len;
            while((len=fr.read(cbuf))!=-1){
//                for (int i = 0; i < cbuf.length; i++) {
//                    System.out.print(cbuf[i]);
//                }//错误操作，一定注意
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr!=null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //文本文件的复制
    public static void test3(){
        FileReader fr= null;
        FileWriter fw= null;
        try {
            File hiFile=new File("hi.txt");
            File helloFile=new File("helloWorld.txt");
            fr = new FileReader(hiFile);
            fw = new FileWriter(helloFile,true);
            fw.write("I love you!!!NARUTO\n");
            char[] cbuf=new char[6];
            int len;
            while((len=fr.read(cbuf))!=-1){
                fw.write(cbuf,0,len);//len为写入字符的个数
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr!=null)fr.close();
                if(fw!=null)fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //非文本文件的复制，复制照片，使用缓冲流
    public static void test4(){
        BufferedInputStream bin= null;
        BufferedOutputStream bout= null;
        try {
            //造文件对象
            File file1=new File("java/src", "com/naruto/java/hanhan.jpg");
            File file2=new File("naruto.jpg");
            //造节点流
            FileInputStream fr=new FileInputStream(file1);
            FileOutputStream fw=new FileOutputStream(file2);
            //造缓冲流
            bin = new BufferedInputStream(fr);
            bout = new BufferedOutputStream(fw);
            //复制的细节，读取，写入
            byte[] buffer=new byte[1024];
            int len;
            while((len=bin.read(buffer))!=-1){
                bout.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源关闭，先关闭外部流，再关闭内部流，随着外部流的关闭，内部流也会关闭，可不手动close内部流
            if(bin!=null) {
                try {
                    bin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bout!=null) {
                try {
                    bout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //转换流
    public static void test5(){
        InputStreamReader fc= null;
        try {
            FileInputStream file=new FileInputStream("hi.txt");
            fc = new InputStreamReader(file,"UTF-8");
            char[] cbuf=new char[8];
            int len;
            while((len=fc.read(cbuf))!=-1){
                String str=new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fc!=null) {
                try {
                    fc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

