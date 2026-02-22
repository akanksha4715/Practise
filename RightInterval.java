import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RightInterval {
    public static int[] findRightInterval (int[][] intervals) {
        
        int n = intervals.length;
        int[] res = new int[n];
        if(n == 1){
            res[0] = -1;
            return res;
        }
      
        List<Pair> pq = new ArrayList<>();
        
        for(int i = 0; i< n; i++){
            pq.add(new Pair(intervals[i][0], i));
        }
        
        pq.sort(Comparator.comparingInt(p -> p.start_time));
        
        for(int i = 0; i< n; i++){
            int et = intervals[i][1];
            int index = binary(pq, et);
            res[i] = index;
        }
        
        return res;
    }
    
    public static int binary(List<Pair> lst, int end){
        int left = 0, right = lst.size() - 1;
        int res = -1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(lst.get(mid).start_time >= end){
                res = lst.get(mid).idx;
                right = mid - 1;
            }
            else{
                left = mid+1;
            }
        }
        
        return res;
    }
    
    static class Pair{
        private int start_time;
        private int idx;
        
        public Pair(int s, int i){
            start_time = s;
            idx = i ;
        }
    }
}
