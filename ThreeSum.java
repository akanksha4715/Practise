import java.util.*;

public class ThreeSum {
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        int n = nums.length;
        for(int i = 0;i<=n-3;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            
            int start = i+1;
            int end = n-1;
            int currNum = (-1) * nums[i];
            
            while(start < end){
                
                int sum = nums[start] + nums[end];
                if(sum == currNum){
                    List<Integer> lst = Arrays.asList(nums[start],nums[end],nums[i]);
                    if(!ans.contains(lst)){
                        ans.add(lst);
                    }
                    start++;
                    end--;
                    while(start < end && nums[start] == nums[start-1]){
                        start++;
                    }
                    while(start < end && nums[end] == nums[end+1]){
                        end--;
                    }
                }
                else if(sum < currNum){
                    start++;
                    while(start < end && nums[start] == nums[start-1]){
                        start++;
                    }
                    
                }
                else{
                    end--;
                    while(start < end && nums[end] == nums[end+1]){
                        end--;
                    }
                }
                
            }
        } 
        return ans;
    }

}
