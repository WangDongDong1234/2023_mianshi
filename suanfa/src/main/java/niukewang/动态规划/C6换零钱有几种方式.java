package niukewang.动态规划;

public class C6换零钱有几种方式 {


    public static int change(int amount, int[] coins) {
        int coinsLength=coins.length;
        int[][] dp=new int[coinsLength+1][amount+1];
        for(int i=0;i<coinsLength;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<coinsLength+1;i++){
            for(int j=1;j<=amount;j++){
                if(j<coins[i-1]){
                    // 如果你不把这第 i 个物品装⼊背包，也就是说你
                    // 不使⽤ coins[i-1] 这个⾯值的硬币，那么凑出⾯额 j 的⽅
                    // 法数 dp[i][j] 应该等于 dp[i-1][j]
                    dp[i][j]=dp[i-1][j];
                }else{
                    //如果你把这第 i 个物品装⼊了背包，也就是说你使⽤ coins[i-1]
                    // 这个⾯值的硬币，那么 dp[i][j] 应该 等于 dp[i][j-coins[i-1]]
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[coinsLength][amount];


    }

    public static void sort(int[] arr,int left,int right){
        if(right<=left){
            return;
        }

        int i=left;
        int j=right;
        int base=arr[i];
        while(i<j){
            while(arr[j]>=base&&j>i){
                j--;
            }
            while(arr[i]<=base&&j>i){
                i++;
            }
            if(i<j){
                int temp =arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        arr[left]=arr[i];
        arr[i]=base;
        sort(arr,left,i-1);
        sort(arr,i+1,right);


    }

    public static void main(String[] args) {
        int[] coins=new int[3];
        coins[0]=5;
        coins[1]=2;
        coins[2]=1;
        int resutl =change(5,coins);
        System.out.println(resutl);
    }
}
