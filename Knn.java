import java.util.PriorityQueue;

public class Knn {
    public int[][] kClosest(int[][] points, int k) {
        
        int n = points.length;
        PriorityQueue<Group> pq = new PriorityQueue<Group>((p,q) -> q.dist - p.dist);
        int[][] res = new int[k][2];
        
        for(int i=0; i< k; i++){
            int x = points[i][0];
            int y = points[i][1];
            
            int distance = y*y + x*x;
            
            pq.add(new Group(x,y,distance));
            
        }
        
        for(int i=k; i< n; i++){
            int x = points[i][0];
            int y = points[i][1];
            
            int distance = y*y + x*x;
            
            Group g = pq.poll();
            if(g.dist > distance){
                pq.add(new Group(x,y,distance));
            }
            else{
                pq.add(g);
            }
            
        }
        
        int c = 0;
        
        while(!pq.isEmpty()){
            Group g = pq.poll();
            res[c][0] = g.x;
            res[c][1] = g.y;
            c++;
        }
        
        return res;
    }
    
    static class Group{
        private int x;
        private int y;
        private int dist;
        
        public Group(int x, int y, int d){
            this.x = x;
            this.y = y;
            dist = d;
        }
    }
}
