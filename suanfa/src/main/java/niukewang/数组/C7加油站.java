package niukewang.数组;

public class C7加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index=0;
        int n=gas.length;
        while(index<n){
            int cur=1;
            int curIndex=index;
            int totalGas=0;
            int totalCost=0;
            while(cur<=n){
                totalGas+=gas[curIndex%n];
                totalCost+=cost[curIndex%n];

                if(totalCost>totalGas){
                    break;
                }
                cur++;
                curIndex++;
            }
            if(cur==n+1){
                return index;
            }
            index++;




        }

        return -1;

    }

    public static void main(String[] args) {
        C7加油站 st=new C7加油站();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(st.canCompleteCircuit(gas,cost));
    }
}
