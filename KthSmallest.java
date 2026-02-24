import java.util.List;
import java.util.PriorityQueue;

public class KthSmallest {
    public static int kSmallestNumber(List<List<Integer>> lists, int k) {
        
        int n = lists.size();
        int max=0;
        
        if(n == 0)
            return 0;

        PriorityQueue<Group> pq = new PriorityQueue<>((p,q) -> p.value - q.value);
        
        for(int i=0; i<n ; i++){
            if(lists.get(i).size() > 0)
            pq.add(new Group(lists.get(i).get(0), 0, i));
        }
        
        
        while(k != 0 && !pq.isEmpty()){
            Group small = pq.poll();
            
            max = small.value;
            
            int next_idx = small.idx + 1;
            int list_i = small.list_index;
            
            if(k == 1)
                return small.value;
            
            if(next_idx < lists.get(list_i).size()){
                pq.add(new Group(lists.get(list_i).get(next_idx), next_idx, list_i));
            }
            
            k--;
            
        }

        return max;
    }
    
    static class Group{
        private int value;
        private int idx;
        private int list_index;
        
        
        public Group(int v, int i, int li){
            value = v;
            idx = i;
            list_index = li;
        }
    }
}
