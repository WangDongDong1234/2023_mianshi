package niukewang.排序;

public class C1数组中第K个最大元素 {

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,0,nums.length-1,k);
    }

    public int quickSort(int[] nums,int left,int right,int k){
        int i=left;
        int j=right;
        int base=nums[i];
        while(i<j){
            while(nums[j]<=base&&i<j){
                j--;
            }
            while(nums[i]>=base&&i<j){
                i++;
            }
            if(i<j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        nums[left]=nums[i];
        nums[i]=base;
        if(i==k-1){
            return nums[i];
        }else if(i<k-1){
            return quickSort(nums,left,i-1,k);
        }else{
            return quickSort(nums,i+1,right,k);
        }
    }
}
