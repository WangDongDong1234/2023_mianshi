package niukewang.动态规划;

/**
 * 最少需要几张纸币
 */
public class C6换零钱最小纸张 {

    public static int change(int aim, int[] arr) {
        if(aim <= 0){
            return 0;
        }
        sort(arr,0,arr.length-1);
        int[] cost=new int[aim+1];
        cost[0]=0;
        for(int i=1;i<=aim;i++){
            //Integer.MAX_VALUE 两层含义
            // 1.初始值用最大值表示         2.无法兑换
            cost[i]=Integer.MAX_VALUE;
            for(int j=0;j<arr.length;j++){
                if(i<arr[j]){
                    //
                    break;
                }else{
                    if(cost[i-arr[j]]!=Integer.MAX_VALUE){
                        cost[i]=Math.min(cost[i],cost[i-arr[j]]+1);
                    }
                }
            }
        }

        return cost[aim]!=Integer.MAX_VALUE?cost[aim]:-1;

    }

    public static void main(String[] args) {
        int[] coins =new int[3];
        coins[0]=1;
        coins[1]=2;
        coins[2]=5;
        int result =change(5,coins);
        System.out.println(result);
    }


    public static void sort(int[] arr,int left,int right){
        if(right<=left){
            return;
        }
        int i=left;
        int j=right;
        int jidian=arr[i];
        while(i<j){
            while(arr[j]>=jidian&&j>i){
                j--;
            }
            while(arr[i]<=jidian&&j>i){
                i++;
            }
            if(i<j){
                int temp =arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }

        arr[left]=arr[i];
        arr[i]=jidian;
        sort(arr,left,i-1);
        sort(arr,i+1,right);
    }
}
