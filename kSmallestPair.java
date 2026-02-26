import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class kSmallestPair {
    public static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int target) {
        
        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<Group> pq = new PriorityQueue<>((p,q) -> p.sum - q.sum);
        int len1 = list1.length;
        int len2 = list2.length;
        for(int i=0; i< len1; i++){
            int k = list2[0];
            pq.add(new Group(list1[i]+k, i, 0));
        }
        
        while(target > 0 && !pq.isEmpty()){
            Group initial = pq.poll();
            res.add(List.of(list1[initial.idx_1],list2[initial.idx_2]));
            if(++initial.idx_2 < len2){
                pq.add(new Group(list1[initial.idx_1]+list2[initial.idx_2], initial.idx_1, initial.idx_2));
            }
            target--;
        }
        return res;
    }
    
    static class Group{
        private int sum;
        private int idx_1;
        private int idx_2;
        
        public Group(int s, int i1, int i2){
            sum = s;
            idx_1 = i1;
            idx_2 = i2;
        }
    }
}
