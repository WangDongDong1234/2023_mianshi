package niukewang.动态规划;

/**
 * 20240525
 */
public class C1最长递增子序列300 {

    public static int lengthOfLIS(int[] nums) {
        if(nums.length<=0){
            return 0;
        }
        int[] dp=new int[nums.length];
        dp[0]=1;
        int max=1;

        for(int i=1;i<nums.length;i++){
            // 初始化1，不初始化会有问题
            dp[i]=1;
            // 跟前面计算的所有比
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }

        return max;

    }

    public static void main(String[] args) {
        //[10,9,2,5,3,7,101,18]
        int[] nums=new int[8];
        int result =lengthOfLIS(nums);
        System.out.println(result);


    }
}
