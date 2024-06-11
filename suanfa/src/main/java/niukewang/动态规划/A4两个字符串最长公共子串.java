package niukewang.动态规划;

public class A4两个字符串最长公共子串 {

    /**
     * book[i][j]  表示str1以i开始，str2以j开始的 最长公共字串的长度
     * @param str1
     * @param str2
     * @return
     */
    public String LCS (String str1, String str2) {
        // write code here
        char[] arr1=str1.toCharArray();
        char[] arr2=str2.toCharArray();

        int length1=arr1.length;
        int length2=arr2.length;
        // book表示最长公共子串
        int[][] book=new int[length1][length2];

        int maxLength=0;
        int startIndex=0;
        for(int i=0;i<length1;i++){
            for(int j=0;j<length2;j++){
                if(arr1[i]==arr2[j]){
                    book[i][j]=1;
                    jisuan(i,j,1,book,length1,length2,arr1,arr2);
                    if(book[i][j]>maxLength){
                        maxLength=book[i][j];
                        startIndex=i;
                    }

                }
            }
        }

        return str1.substring(startIndex,startIndex+maxLength);






    }

    public void jisuan(int i,int j,int length,int[][] book,int length1,int length2,char[] arr1,char[] arr2){
        int nextI=i+length;
        int nextj=j+length;
        if(nextI>=length1||nextj>=length2){
            return;
        }
        if(arr1[nextI]==arr2[nextj]){
            length++;
            book[i][j]=length;
            jisuan(i,j,length,book,length1,length2,arr1,arr2);
        }

    }
}
