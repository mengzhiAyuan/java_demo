package cn.Algorithms.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：mengzhiayuan
 * @description：TODO
 * @date ：2021/5/19 20:47
 */
public class combination {
    private List<List<Integer>> list;

    public static void main(String[] args) {
        combination com=new combination();
        com.combine(4,2);
    }

    //    给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合

    public List<List<Integer>> combine(int n, int k) {
        list=new ArrayList<>();
        if(k==0)return list;
        ArrayDeque path=new ArrayDeque<>();
        backtrack(path,n,k,1);
        return list;
    }
    public void backtrack(ArrayDeque<Integer> path,int n,int k,int index){
        if(path.size()==k){
            list.add(new ArrayList<>(path));
            System.out.println(path);
            return;
        }
        for(int i=index;i<=n;i++){
            path.addLast(i);
            backtrack(path,n,k,i+1);
            path.removeLast();
        }
    }

    public void tedt() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("llll");
        }, "lala");

        t1.join();

    }

}

