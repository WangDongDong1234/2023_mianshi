package niukewang.动态规划;

/**
 * 总结： 对角线都是回文字串，且长度等于1即i=j的情况
 *       场景：注意aba   和  abba的场景
 */
public class A1最长回文子串 {
    /**
     *
     *
     *
     * @param A string字符串
     * @return int整型
     */
    public int getLongestPalindrome (String A) {
        // write code here
        char[] array=A.toCharArray();
        int length=array.length;
        int[][] books=new int[length][length];
        for(int i=0;i<length;i++){
            //对角线
            books[i][i]=1;
            // aba情况
            dfs(i,i,array,length,books);
            // abba情况
            dfs2(i,i+1,array,length,books);
        }

        int max=1;
        for(int i=0;i<length;i++){
            for(int j=0;j<=i;j++){
                if(books[i][j]==1){
                    max=Math.max(max,i-j+1);
                }
            }
        }

        return max;



    }

    // aba向两边扩
    public void dfs(int i,int j,char[] array,int length,int[][] books){
        int nextI=i-1;
        int nextJ=j+1;
        if(nextI<0||nextJ>=length||nextI>=length||nextJ<0){
            return;
        }

        if(array[nextI]==array[nextJ]){
            books[nextI][nextJ]=1;
            books[nextJ][nextI]=1;
            dfs(nextI,nextJ,array,length,books);
        }



    }

    //abba向两边扩
    public void dfs2(int i,int j,char[] array,int length,int[][] books){

        if(i<0||j>=length||i>=length||j<0){
            return;
        }

        if(array[i]==array[j]){
            books[i][j]=1;
            books[j][i]=1;
            dfs2(i-1,j+1,array,length,books);
        }
    }
}
