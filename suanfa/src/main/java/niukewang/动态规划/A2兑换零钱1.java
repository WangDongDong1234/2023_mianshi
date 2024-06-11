package niukewang.动态规划;

public class A2兑换零钱1 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 最少货币数
     * @param arr int整型一维数组 the array
     * @param aim int整型 the target
     * @return int整型
     */
    public int minMoney (int[] arr, int aim) {
        if(arr.length==0 ){
            return -1;
        }

        // 零钱从小到大排序
        sort(arr,0,arr.length-1);

        int[] dp=new int[aim+1];
        dp[0]=0;



        for(int i=1;i<=aim;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<=arr.length-1;j++){
                int dif=i-arr[j];
                if(dif<0){
                    // 最小的不能换
                    break;
                }else if(dif==0){
                    // 正好能换一张
                    min=1;
                    break;
                }
                else{
                    // 看剩余金额能否换，剩余金额能换张2数就+1；
                    if(dp[dif]!=Integer.MAX_VALUE){
                        min=Math.min(min,dp[dif]+1);
                    }else{
                        //不能换
                    }
                }

            }
            dp[i]=min;
        }

        return dp[aim]!=Integer.MAX_VALUE?dp[aim]:-1;
    }

    public void sort(int[] arr,int left,int right){
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
