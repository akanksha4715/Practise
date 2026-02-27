import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFreq {
    public static List<Integer> topKFrequent(int[] arr, int k) {

        List<Integer> res = new ArrayList<Integer>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = 
                new PriorityQueue<>(Map.Entry.<Integer,Integer>comparingByValue().reversed());
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i< arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        
       pq.addAll(map.entrySet());
       int count = 0;
       
       while(count < k && !pq.isEmpty()){
           Map.Entry<Integer,Integer> entry = pq.poll();
           res.add(entry.getKey());
           count++;
       }
        return res;
    }
}
