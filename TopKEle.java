import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKEle {
    public static String reorganizeString(String string1) {

        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq =
                    new PriorityQueue<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        int n = string1.length();
        StringBuilder s = new StringBuilder();
        
        for(int i =0; i<n; i++){
            int v = map.getOrDefault(string1.charAt(i), 0) + 1;
            if(v > (n+1)/2)
                return "";
            map.put(string1.charAt(i), v);
        }
        
        pq.addAll(map.entrySet());
        int len = 0;
        
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> first = pq.poll();
            if(s.isEmpty()){
                len++;
                s.append(first.getKey());
                first.setValue(first.getValue() - 1);
                if(first.getValue() > 0)
                    pq.add(first);
            }
            else{
                char prev = s.charAt(len-1);
                if(prev == first.getKey()){
                    if(!pq.isEmpty()){
                        Map.Entry<Character, Integer> second = pq.poll();
                        s.append(second.getKey());
                        second.setValue(second.getValue() - 1);
                        if(second.getValue() > 0)
                            pq.add(second);
                        
                        pq.add(first);
                    }
                    else{
                        return "";
                    }
                }
                else{
                    s.append(first.getKey());
                    first.setValue(first.getValue() - 1);
                    if(first.getValue() > 0)
                        pq.add(first);
                }
                
                len++;
            }
        }
        
        return s.toString();
        
    }
}
