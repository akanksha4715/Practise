import java.util.PriorityQueue;

public class MaxScore {
    public static int maxScore (int[] nums, int k) {
      
        PriorityQueue<Integer> pq = new PriorityQueue<>((p,q) -> q - p);
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }
        
        int sum = 0;
        while( k > 0){
            int val = pq.poll();
            sum = sum + val;
            pq.add((int) Math.ceil(val/3.0));
            
            k--;
        }
        
        return sum;
    }

}