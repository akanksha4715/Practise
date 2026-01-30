import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        // int[] gas = {1,2,3,4,5};
        // int[] cost = {3,4,5,1,2};
        int[] gas = {3,1,1};
        int[] cost = {1,2,2};
        System.out.println(sol.canCompleteCircuit(gas, cost));
    }
    
}
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) return -1;

        int start=0;
        int n = gas.length;

        int surplus = 0;

        for(int i=0; i<n; i++){
            surplus += gas[i] - cost[i];

            if(surplus < 0){
                start = i+1;
                surplus = 0;
            } 
            
        }

        return  start ;
    }
}