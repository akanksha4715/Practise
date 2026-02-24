public class mergeKSorted {
    public static int[] mergeSorted(int[] nums1, int m, int[] nums2, int n) {
      
      int pt1 = m-1, pt2 = n-1;
      int k = m+n-1;
      
      while(pt1 >= 0 && pt2 >= 0){
         if(nums1[pt1] > nums2[pt2]){
            nums1[k] = nums1[pt1];
            pt1--;
         }
         else{
            nums1[k] = nums2[pt2];
            pt2--;
         }
         
         k--;
      }
      
      while(pt2 >= 0){
         nums1[k] = nums2[pt2];
         pt2--;
         k--;
      }
      
      return nums1;
   }
}
