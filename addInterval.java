import java.util.*;

class Solution {

  public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {

    List<int[]> list = new ArrayList<>();
    
    if(existingIntervals.length == 0) {
      list.add(newInterval);
      return list.toArray(new int[list.size()][]);
    }
    int n = existingIntervals.length;
    int[] current = existingIntervals[0];
    boolean done = false;
    
    for(int i = 1; i< n;i++){
      if(current[1] >= newInterval[0] && !done){
        current[1] = Math.max(current[1], newInterval[1]);
        done = true;
      }
      if(current[1] >= existingIntervals[i][0]){
        current[1] = Math.max(current[1], existingIntervals[i][1]);
      }
      else{
        list.add(current);
        current = existingIntervals[i];
      }
    }
    
    list.add(current);
    if(!done){
      list.add(newInterval);
    }
    return list.toArray(new int[list.size()][]) ;
  }
}

