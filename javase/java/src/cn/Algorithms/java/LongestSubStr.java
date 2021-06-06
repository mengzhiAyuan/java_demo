package cn.Algorithms.java;

/**
 * @author ：mengzhiayuan
 * @description：
 * 如果 str1 的长度为 N，str2 的长度为 M，生成大小为 N*M 的 数组 dp , dp[i][j]表示 str1[0…i] 与 str2[0…j] 的
 * 最长公共子串的长度。
 * 计算dp[i][j] 的方法如下：
 * 矩阵 dp 的第一列 dp[0…m-1][0].对于 某个位置（i，0）如果str1[i]==str2[0],则dp[i][0]=1,否则dp[i][0]=0
 * 矩阵 dp 的第一行 dp[0][0…n-1].对于 某个位置（0，j）如果str1[0]==str2[j],则dp[0][j]=1,否则dp[0][j]=0
 * 其他位置从左到右从上到下计算，dp[i][j]的值只有两种情况：
 * 1). str1[i]==str2[j],dp[i][j]=dp[i-1][j-1]+1;
 * 2). tr1[i]!=str2[j]则dp[i][j]=0;
 * str1=”abc”,str2=”caba”的 dp 矩阵如下:
 *      a　  b　　c
 * c　　0　　0　　1
 * a　　1　　0　　0
 * b　　0　　2　　0
 * a　　1　　0　　0
 * @date ：2021/2/4 13:58
 */
public class LongestSubStr {
    public static void main(String[] args) {
        char[]aa=new char[]{'a','c','c','b','c','a','a'};
        char[]bb={'b','a','a','b','c','b','c','a'};
        L_css.L(aa,bb);
    }
}
class L_css{
    public static void L(char str1[],char str2[])
    {
        int dp[][]=new int[str1.length][str2.length];
        //对dp矩阵的第一列赋值
        for(int i=0;i<str1.length;i++)
        {
            if(str2[0]==str1[i])
                dp[i][0]=1;
            else {
                dp[i][0]=0;
            }
        }
        //对dp矩阵的第一行赋值
        for(int j=0;j<str2.length;j++)
        {
            if(str1[0]==str2[j])
                dp[0][j]=1;
            else {
                dp[0][j]=0;
            }
        }
        for(int i=1;i<str1.length;i++)
            for(int j=1;j<str2.length;j++)
            {
                if(str1[i]==str2[j])
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j]=0;
                }
            }
        int max=dp[0][0];
        for(int i=0;i<str1.length;i++)
            for(int j=0;j<str2.length;j++)
            {
                max=Math.max(max,dp[i][j]);//实现了一种迭代
            }
        System.out.println(max);
    }
}
