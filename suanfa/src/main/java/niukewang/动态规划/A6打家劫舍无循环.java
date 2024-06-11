package niukewang.动态规划;

public class A6打家劫舍无循环 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int rob (int[] nums) {

        // write code here
        int length=nums.length;
        if(length==1){
            return nums[0];
        }
        int[] dp=new int[length];

        int index=0;
        while(index<length){
            if(index==0){
                dp[index]=nums[index];
                index++;
                continue;
            }
            if(index==1){
                dp[index]=Math.max(dp[index-1],nums[index]);
                index++;
                continue;
            }

            dp[index]=Math.max(dp[index-2]+nums[index],dp[index-1]);
            index++;
        }

        return dp[length-1];
    }
}
