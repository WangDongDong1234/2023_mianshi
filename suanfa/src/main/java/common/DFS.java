package common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;

public class DFS {

    public static int total=0;

    public static void main(String[] args) {
        int[] container=new int[11];
        int[] book=new int[11];
        dfs(1,container,book);
        System.out.println(total);
        HashMap<Integer,Integer> temp=new HashMap();
    }

    /**
     * step表示当前在那个盒子面前,step从1开始
     * container是容器
     * book是标记牌是否在手上
     * @param step
     */
    public static void dfs(int step,int[] container,int[] book){

        //到达最后一个
        if(step==container.length){
            System.out.println(Arrays.toString(container));
            total++;
            return;
        }

        for(int i=1;i<book.length;i++){
            if(book[i]==0){
                book[i]=1;
                container[step]=i;
                dfs(step+1,container,book);
                book[i]=0;
            }
        }

    }
}
