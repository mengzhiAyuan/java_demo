package cn.Algorithms.java;

import java.util.Random;

/**
 * @author ：mengzhiayuan
 * @description：TODO
 * @date ：2021/3/12 12:39
 */
public class TestSchool {
    public static void main(String[] args) {
        int[] res=new int[100];
        for(int i=0;i<100;i++){
            res[i]= new Random().nextInt(10000);
        }
        System.out.println(minSum(res));
    }
    public static int minSum(int[] res){
        int sum=Integer.MAX_VALUE;
        for(int i=0;i<res.length;i++){
            for(int j=i+1;j<res.length;j++){
                if(Math.abs(res[j]-res[i])<sum)sum=Math.abs(res[j]-res[i]);
            }
        }
        return sum;
    }
}
