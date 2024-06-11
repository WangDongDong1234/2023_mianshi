package niukewang.数组;

public class C3跳跃游戏20240607 {
    public boolean canJump(int[] nums) {
        boolean[] result=new boolean[nums.length];
        result[0]=true;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(i-j<=nums[j]&&result[j]==true){
                    result[i]=true;
                    break;
                }
            }
            result[i]=false;

        }

        return result[nums.length-1];

    }

    public static void main(String[] args) {
        C3跳跃游戏20240607 start=new C3跳跃游戏20240607();
        int[] nums={2,3,1,1,4};
        start.canJump(nums);
    }
}
