package niukewang.动态规划;

public class C2最大子数组和53 {

    public int maxSubArray(int[] nums) {
        int[] sum=new int[nums.length];
        sum[0]=nums[0];
        int max=sum[0];
        for(int i=1;i<nums.length;i++){
            //当前值nums[i]与前i项求和，取最大的
            sum[i]=Math.max(nums[i],sum[i-1]+nums[i]);

        }

        for(int i=1;i<nums.length;i++){
            max=Math.max(max,sum[i]);
        }

        return max;

    }
}
