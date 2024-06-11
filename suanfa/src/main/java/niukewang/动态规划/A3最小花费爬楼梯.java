package niukewang.动态规划;

public class A3最小花费爬楼梯 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param cost int整型一维数组
     * @return int整型
     */
    public int minCostClimbingStairs (int[] cost) {
        if(cost.length<=2){
            return 0;
        }
        // write code here  注意这里要+1
        int[] dp=new int[cost.length+1];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=cost.length;i++){
            dp[i]=Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
        }
        return dp[cost.length];
        // 时间复杂度O(N)，空间复杂度O(1)
        // int dp0 = 0, dp1 = 0, dp2=0;
        // for (int i = 2; i <= cost.length; ++i) {
        //     dp2 = Math.min(dp0 + cost[i - 2], dp1 + cost[i - 1]);
        //     dp0 = dp1;
        //     dp1 = dp2;
        // }
        // return dp2;


    }
}
