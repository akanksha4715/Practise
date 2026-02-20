import java.util.PriorityQueue;

public class ConnectSticks {
    public static int connectSticks (int[] sticks) {
      
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < sticks.length; i++){
            pq.add(sticks[i]);
        }
        
        int sumTillNow = 0;
        
        while(pq.size() > 1){
            int sum = 0;
            int first = pq.poll();
            int sec = pq.poll();
            
             sum = first + sec;
            sumTillNow += sum;
            
            pq.add(sum);
            
        }
        return sumTillNow;
    }
}
