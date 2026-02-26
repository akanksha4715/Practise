import java.util.PriorityQueue;

public class MergeKList {
    public static ListNode mergeKLists(ListNode[] lists) {
	  
	  ListNode head = null;
	  ListNode prev = null;
        
		int n = lists.length;
		PriorityQueue<ListNode> pq = new PriorityQueue<>((p,q) -> p.val - q.val);
		
		for(int i=0; i<n; i++){
		  if(lists[i] != null)
		    pq.add(lists[i]);
		}
		
		while(!pq.isEmpty()){
		  
		  ListNode node = pq.poll();
		  
		  if(head == null){
		    head = node;
		    prev = head;
		  }
		  else{
		    prev.next = node;
		    prev = node;
		  }
		  ListNode next = node.next;
		  
		  if(next != null)
		    pq.add(next);
		  
		}
		return head;
	}

    class ListNode {
    int val;
    ListNode next;

    // Constructor
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
}
