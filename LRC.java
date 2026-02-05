import java.util.HashMap;

public class LRC {
    public static int longestRepeatingCharacterReplacement(String s, int k) {
        // a c b e d c c
        int start = 0, mostFreqChar = 0;
        int maxLen = 1;
        int n = s.length();
        char current;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int end = 0; end < n; end++){
            current = s.charAt(end);
            
            map.put(current, map.getOrDefault(current, 0) + 1);
            
            mostFreqChar = Math.max(mostFreqChar, map.get(current));
            
            if(end - start + 1 - mostFreqChar > k){
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            
            maxLen = Math.max(maxLen, end - start + 1);
        }
        
        return maxLen;
    }
}
