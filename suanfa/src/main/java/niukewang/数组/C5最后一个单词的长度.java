package niukewang.数组;

public class C5最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        int n=s.length();
        int i=n-1;
        while(i>=0){
            if(s.charAt(i)!=' '){
                break;
            }
            i--;
        }

        int j=i;
        while(j>=0){
            if(s.charAt(i)==' '){
                break;
            }
            j--;
        }

        return i-j+1;

    }

    public static void main(String[] args) {
        C5最后一个单词的长度 st= new C5最后一个单词的长度();
        st.lengthOfLastWord("Hello World");
    }
}
