package niukewang.动态规划;

public class A5不同路径的数目 {


    /**
     * 二维数组，从左上角走到右下角  只能向右或者向下
     * book[i][j]=book[i-1][j]+book[i][j-1]
     * 表示有几种走法
     * @param m
     * @param n
     * @return
     */

    public int uniquePaths (int m, int n) {
        // write code here
        int[][] book=new int[m][n];
        for(int i=0;i<m;i++){
            book[i][0]=1;
        }

        for(int j=0;j<n;j++){
            book[0][j]=1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                book[i][j]=book[i-1][j]+book[i][j-1];
            }
        }

        return book[m-1][n-1];


    }

}
