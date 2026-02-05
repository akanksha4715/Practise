public class BuySell {
   public static int maxProfit(int[] prices) {
      
      int buy = 0;
      int n = prices.length;
      int max = 0;
      if(n == 1) return max;
      
      for(int sell = 1; sell < n; sell++){
         if(prices[sell] < prices[buy]){
            buy = sell;
         }
         max = Math.max(max,prices[sell] - prices[buy] );
      }
      return max;
   }
}

