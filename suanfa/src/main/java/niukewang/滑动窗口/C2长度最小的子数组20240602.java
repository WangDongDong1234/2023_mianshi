package niukewang.滑动窗口;

public class C2长度最小的子数组20240602 {

    /**
     * 此方法超时
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen2(int target, int[] nums) {
        int[] dp=new int[nums.length+1];
        dp[0]=0;
        for(int i=1;i<=nums.length;i++){
            dp[i]=dp[i-1]+nums[i-1];
        }

        int min=Integer.MAX_VALUE;
        for(int i=0;i<dp.length;i++){
            for(int j=i;j<dp.length;j++){
                if(dp[j]-dp[i]>=target){
                    min=Math.min(min,j-i);
                }
            }
        }

        return min==Integer.MAX_VALUE?0:min;

    }

    public static void main(String[] args) {
//        int[] nums1={2,3,1,2,4,3};
//        System.out.println(minSubArrayLen(7,nums1));//2
//
//        int[] nums2={1,4,4};
//        System.out.println(minSubArrayLen(4,nums2));//1
//
//        int[] nums3={1,1,1,1,1,1,1,1};
//        System.out.println(minSubArrayLen(11,nums3));//0

        int[] nums4={2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums4 ));//0


    }


    /**
     * 有问题
     * 存在重复加的问题
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen_ERROR(int target, int[] nums) {
        int left=0;
        int right=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        while(right<=nums.length-1&&left<=right){
            sum+=nums[right];
            if(sum>=target){
                min=Math.min(min,right-left+1);
                sum-=nums[left];
                sum-=nums[right];
                left++;
            }else{
                right++;
            }

        }

        return min==Integer.MAX_VALUE?0:min;


    }


    public static int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int right=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        while(right<=nums.length-1&&left<=right){
            sum+=nums[right];
            while(sum>=target){
                min=Math.min(min,right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;

        }

        return min==Integer.MAX_VALUE?0:min;
    }
}
