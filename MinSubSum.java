public class MinSubSum {
    public static int minSubArrayLen(int target, int[] nums) {
            
      int start = 0, sum = 0;
      
      int n = nums.length;
      int size = Integer.MAX_VALUE;
      
      for(int end = 0; end < n; end++){
         sum += nums[end];
         
         while(sum >= target ){
            size = Math.min(size, end - start + 1);
            sum -= nums[start];
            start++;
         }
      }
      
      return (size == Integer.MAX_VALUE) ? 0 : size;
   }
}
