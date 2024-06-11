package niukewang.滑动窗口;

import java.util.HashSet;

public class C1无重复字符的最长子串20240602 {
    public static int lengthOfLongestSubstring(String s) {
        char[] charArry=s.toCharArray();
        if(charArry.length==0){
            return 0;
        }
        HashSet<Character> set=new HashSet();
        int max=1;
        for(int i=0;i<charArry.length;i++){
            for(int j=i;j<charArry.length;j++){
                if(set.contains(charArry[j])){
                    // 有重复就清除
                    set.clear();
                    break;
                }else{
                    // 无重复就添加，并计算
                    set.add(charArry[j]);
                    max=Math.max(max,j-i+1);
                }

            }

        }

        return max;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));//3
        System.out.println(lengthOfLongestSubstring("bbbbb"));//1
        System.out.println(lengthOfLongestSubstring("pwwkew"));//3
    }


}
