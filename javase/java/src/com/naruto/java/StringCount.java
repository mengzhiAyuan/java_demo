package com.naruto.java;

/**
 * @author ：mengzhiayuan
 * @description：
 * 获取子字符串subStr在主字符串mainStr出现的次数
 * @date ：2021/2/4 13:17
 */
public class StringCount {
    public static void main(String[] args) {
        StringTest stringCount = new StringTest();
        int num=stringCount.getCount("231243243233343233323","23");
        System.out.println(num);
    }
}
class StringTest{
    public int getCount( String mainStr, String subStr){
        if(mainStr==null ||subStr==null)return 0;
        int count=0;
        int index=0;
        if(mainStr.length()<subStr.length())return 0;
        while((index=mainStr.indexOf(subStr))!=-1){
            count++;
            mainStr=mainStr.substring(index+subStr.length());
        }
        return count;
    }
}
