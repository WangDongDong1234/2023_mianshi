package trycatchfinally;

public class Test1 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(test()); //2
    }
   public static int test(){
        int i = 1;
        try{
            i++;
            System.out.println("try block, i = "+i); //try block, i = 2
            return i;
        }catch(Exception e){
            i ++;
            System.out.println("catch block i = "+i);
        }finally{
            i = 10;
            System.out.println("finally block i = "+i); //finally block i = 10
        }
        return i;
    }
}
