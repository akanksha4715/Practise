import java.util.HashMap;

public class LongestNonRepeat {
    public static int findLongestSubstring(String str) {

        HashMap<Character, Integer> map = new HashMap<>();
        int n = str.length();
        
        int start = 0;
        int end = 0;
        int max = 1;
        
        while(end < n){
            int idx = map.getOrDefault(str.charAt(end), -1);
            
            if(idx != -1){
                start = Math.max(start, map.get(str.charAt(end)) + 1);
            }
            
            max = Math.max(max, end-start+1);
            map.put(str.charAt(end), end);
            end++;
            
        }
        return max;
    }
}
