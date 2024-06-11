package niukewang.动态规划;

import java.util.Arrays;

/**
 * 跟C1一样
 */
public class B2最长上升子序列 {
    public int LIS (int[] arr) {
        // write code here
        int n = arr.length;
        if(n == 0) return 0;
        int[] dp = new int[n];     // dp[i]表示以arr[i]结尾时的最长递增子序列长度
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for(int i = 1; i < n; i++){
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] < arr[i]){
                    // arr[j] < arr[i]，可以把arr[i]接在arr[j]后面，构成长度为dp[j]+1的递增子序列
                    dp[i] = Math.max(dp[i], dp[j] + 1);     // 选择能构成更长递增子序列的arr[j]
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
