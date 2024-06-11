package niukewang.动态规划;

public class C7子集背包问题416 {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        if(sum%2!=0){
            return false;
        }

        sum=sum/2;
        boolean[][] dp=new boolean[nums.length+1][sum+1];
        for(int i=0;i<nums.length+1;i++){
            //因为背包没有空间的时候，就相当于装满了，⽽当没有物品可选择的时候，肯定没办法装满背包
            dp[i][0]=true;
        }

        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=sum;j++){
                if(j-nums[i-1]<0){
                    dp[i][j]=dp[i-1][j];
                }else{
                    // 此处是01背包的特性，dp[i-1][j-nums[i-1]]
                    // 表示放了第j个，则剩下的是否满足
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[nums.length][sum];


    }
}
