package niukewang.数组;

public class C1合并两个有序数组20240607 {

    public  void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        int[] sortNum=new int[m+n];
        int i=0;
        int j=0;
        for(int t=0;t<m+n;t++){
            if(i==m){
                sortNum[t]=nums2[j];
                j++;
            }else if(j==n){
                sortNum[t]=nums1[i];
                i++;
            }else if(nums1[i]<=nums2[j]){
                sortNum[t]=nums1[i];
                i++;
            }else {
                sortNum[t]=nums2[j];
                j++;
            }
        }

        for(int t=0;t<m+n;t++){
            nums1[t]=sortNum[t];
        }


    }

    public static void main(String[] args) {
//        int[] nums1={1,2,3,0,0,0};
//        int[] nums2={2,5,6};
        int[] nums1={2,0};
        int[] nums2={1};
        C1合并两个有序数组20240607 start =new C1合并两个有序数组20240607();
        start.merge(nums1,1,nums2,1);
        System.out.println(nums1);
}}