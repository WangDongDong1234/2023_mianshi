package niukewang.动态规划;

public class A7矩阵的最小路径和 {

    /**
     * book[i][j] 表示走到i，j的最小路径
     * @param matrix
     * @return
     */
    public int minPathSum (int[][] matrix) {
        // write code here
        int mlength=matrix.length;
        int nlength=matrix[0].length;

        int[][] book=new int[mlength][nlength];
        book[0][0]=matrix[0][0];
        for(int t=1;t<mlength;t++){
            book[t][0]=matrix[t][0]+book[t-1][0];
        }

        for(int t=1;t<nlength;t++){
            book[0][t]=matrix[0][t]+book[0][t-1];
        }

        int min=book[0][0];
        for(int i=1;i<mlength;i++){
            for(int j=1;j<nlength;j++){
                book[i][j]=Math.min(book[i-1][j],book[i][j-1])+matrix[i][j];
                min=Math.min(min,book[i][j]);
            }
        }

        return book[mlength-1][nlength-1];
    }
}
