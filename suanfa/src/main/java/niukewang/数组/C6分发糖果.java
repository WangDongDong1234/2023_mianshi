package niukewang.数组;

public class C6分发糖果 {
    public int candy(int[] ratings) {
        int[] left=new int[ratings.length];
        int[] right=new int[ratings.length];
        left[0]=1;
        right[ratings.length-1]=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                left[i]=left[i-1]+1;
            }else{
                left[i]=1;
            }
        }

        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                right[i]=right[i+1]+1;
            }else{
                right[i]=1;
            }
        }

        int sum=0;
        for(int i=0;i<ratings.length;i++){
            sum+=Math.max(left[i],right[i]);
        }
        return sum;

    }

    public static void main(String[] args) {
        C6分发糖果 st=new C6分发糖果();
        int[] ratings={1,2,2};
        st.candy(ratings);
    }
}
