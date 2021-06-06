package cn.Algorithms.java;

/**
 * @author ：mengzhiayuan
 * @description：TODO
 * @date ：2021/5/13 20:12
 */
import java.util.Scanner;
import java.util.TreeSet;

public class test06 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        char [] numsA = str1.toCharArray();
        char [] numsB = str2.toCharArray();
        int [][] dp = getMaxLCSLength2(numsA, numsB);
        int len = dp[numsA.length][numsB.length];
        String lcs_str = "";
        traceBack(dp, numsA, numsB, numsA.length,numsB.length,lcs_str);
        System.out.println(len);
    }

    //求最长公共子序列的长度，
    public static int[][] getMaxLCSLength2(char [] arr1, char [] arr2){
        int len1 = arr1.length;
        int len2 = arr2.length;
        int [][] dp = new int[len1+1][len2+1];//此处的动态规划数组长度要比原长度多加1，需要多存储一行0和一列0
        for(int i = 0;i<=len2;i++){//第0行第i列全部赋值为0   //这里是<=号
            dp[0][i] = 0;
        }
        for(int i = 0;i<=len1;i++){//第i行，第0列全部为0    //这里是<=号
            dp[i][0] = 0;
        }
        for(int i = 1;i<=len1;i++){//这里是<=号
            for(int j = 1;j<=len2;j++){//这里是<=号
                if(arr1[i-1] == arr2[j-1]){//注意这里若是arr1[i] == arr2[j]，就会发生数组越界
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        //return dp[len1][len2];
        return dp;
    }

    //功能：回溯，求出所有的最长公共子序列，并放入set中
    public static void traceBack(int [][] dp, char [] arr1, char [] arr2, int i, int j, String lcs_str) {
        TreeSet<String> set = new TreeSet<String>();
        while (i>0 && j>0) {
            if (arr1[i-1] == arr2[j-1]) {
                lcs_str += arr1[i-1];
                i--;
                j--;
            }
            else {
                if (dp[i][j-1]>dp[i-1][j])
                    j--;
                else if (dp[i][j-1]<dp[i-1][j])
                    i--;
                else {  // 相等的情况
                    traceBack(dp, arr1, arr2, i-1, j, lcs_str);
                    traceBack(dp, arr1, arr2, i, j-1, lcs_str);
                    return;
                }
            }
        }
        set.add(reverse(lcs_str));
        //输出最长公共子序列
        for(String s : set) {
            System.out.println(s);
        }
    }

    //功能：字符串逆序
    public static String reverse(String str) {
        StringBuffer strBuf = new StringBuffer(str).reverse();
        return strBuf.toString();
    }
}
