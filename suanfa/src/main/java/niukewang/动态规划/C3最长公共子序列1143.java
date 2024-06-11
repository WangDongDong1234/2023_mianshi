package niukewang.动态规划;

/**
 * 记住状态转移方程
 */
public class C3最长公共子序列1143 {

    public static int longestCommonSubsequence(String text1, String text2) {
       char[] chars1= text1.toCharArray();
       char[] chars2= text2.toCharArray();
       int[][] dp=new int[chars1.length+1][chars2.length+1];
       for(int i=0;i<chars1.length+1;i++){
           dp[i][0]=0;
       }

        for(int i=0;i<chars2.length+1;i++){
            dp[0][i]=0;
        }

        int max=0;
        for(int i=1;i<chars1.length+1;i++){
            for(int j=1;j<chars2.length+1;j++){
                if(chars1[i]==chars2[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                max=Math.max(max,dp[i][j]);
            }
        }

        return max;



    }

    public static void main(String[] args) {

    }
}
