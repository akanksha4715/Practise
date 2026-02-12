import java.util.Arrays;
import java.util.PriorityQueue;

public class minMachine {
    public static int minimumMachines(int[][] tasks) {
      
        Arrays.sort(tasks, (a,b) -> Integer.compare(a[0],b[0]));
        
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
         
        
        for(int i = 0; i< tasks.length; i++){
            int start = tasks[i][0];
            int end = tasks[i][1];
            
            if(!q.isEmpty() && start >= q.peek()){
                q.poll();
            }
            q.offer(end);
            
        }
        
        
        return q.size();
    }
    
}
