import java.util.PriorityQueue;

public class HappyNo {
    public static String longestDiverseString(int a,  int b, int c) 
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p, q) -> q.count - p.count);
        
        if(a > 0) pq.add(new Pair(a, 'a'));
        if(b > 0) pq.add(new Pair(b, 'b'));
        if(c > 0) pq.add(new Pair(c, 'c'));
        
        StringBuilder res = new StringBuilder();
        
        while(!pq.isEmpty()){
            
            Pair top = pq.poll();
            int len = res.length();
            
            if(len >= 2 && res.charAt(len-1) == top.ch && res.charAt(len-2) == top.ch){
                if(!pq.isEmpty()){
                    Pair sec = pq.poll();
                    res.append(sec.ch);
                    if(--sec.count > 0) pq.add(sec);
                    pq.add(top);
                }
            }
            else{
                res.append(top.ch);
                if(--top.count > 0) pq.add(top);
            }
        }
        return res.toString();
    }
    
    static class Pair{
    private int count;
    private char ch;
    
    public Pair(int count, char ch){
        this.count = count;
        this.ch = ch;
    }
}
}
