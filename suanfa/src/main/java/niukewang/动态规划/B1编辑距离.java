package niukewang.动态规划;

public class B1编辑距离 {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str1 string字符串
     * @param str2 string字符串
     * @return int整型
     */
    public int editDistance (String str1, String str2) {
        // write code here
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        // 将空串编辑成str1[:i]只能不断插入字符
        for(int i = 1; i <= str1.length(); i++){
            dp[i][0] = dp[i - 1][0] + 1;
        }
        // 将空串编辑成str2[:j]只能不断插入字符
        for(int j = 1; j <= str2.length(); j++){
            dp[0][j] = dp[0][j - 1] + 1;
        }
        for(int i = 1; i <= str1.length(); i++){
            for(int j = 1; j <= str2.length(); j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
