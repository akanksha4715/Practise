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
        int start;
        int n = gas.length;

        for(int i=0; i<n; i++){
            if(gas[i] > cost[i]){
                start = i;
                
                int j = i+1;
                int g = gas[i] - cost[i];
                while(j%n != start){
                    j %= n;
                    g = g + gas[j] - cost [j];
                    if(!(g >= 0))
                        break;
                    j++;
                    
                }
                j %= n;
                if(j == start)
                    return start;
            }
        }

        return -1;
    }
}