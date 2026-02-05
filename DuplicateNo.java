public class DuplicateNo {


    // 1 3 3 4 2 5
    // 0 1 2 3 4 5
public int findDuplicate(int[] nums) {
          int fast = nums[0];
          int slow = nums[0];

          while (true) {
              slow = nums[slow];
              fast = nums[nums[fast]];

              if (slow == fast) {
                  break;
              }
          }

          slow = nums[0];

          while (slow != fast) {
              slow = nums[slow];
              fast = nums[fast];
          }

          return fast;
    }
}