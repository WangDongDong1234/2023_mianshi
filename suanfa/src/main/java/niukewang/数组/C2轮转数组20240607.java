package niukewang.数组;

public class C2轮转数组20240607 {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reserve(nums,0,nums.length-1);
        reserve(nums,0,k-1);
        reserve(nums,k,nums.length-1);


    }

    public void reserve(int[] nums,int left,int right){
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }

    }

    public void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }

    public static void main(String[] args) {
        C2轮转数组20240607 start = new C2轮转数组20240607();
        int[] nums={-1};
        start.rotate(nums,2);

    }
}
