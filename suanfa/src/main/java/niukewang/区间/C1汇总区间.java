package niukewang.区间;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C1汇总区间 {
    public List<String> summaryRanges(int[] nums) {
        Set<Integer> set=new HashSet();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        List<String> result =new ArrayList();
        for(Integer e:set){
            int value =e;
            if(set.contains(value-1)){
                continue;
            }else{
                StringBuilder sb =new StringBuilder();
                sb.append(value);
                int nextValue=value+1;
                while(set.contains(nextValue)){
                    nextValue++;
                }
                nextValue--;
                if(value!=nextValue){
                    sb.append("->").append(nextValue);
                }
                result.add(sb.toString());

            }
        }

        return result;

    }

    public static void main(String[] args) {
        C1汇总区间 start =new C1汇总区间();
        int[] nums={-2147483648,-2147483647,2147483647};
        start.summaryRanges(nums);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

    }
}
