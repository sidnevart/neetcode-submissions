class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;
        int i = n - 1;
        int j = m - 1;
        while (j >= 0 && i >= 0){
            if (nums1[j] > nums2[i]){
                nums1[last] = nums1[j];
                j--;
            } else {
                nums1[last] = nums2[i];
                i--;
            }
            last--;
        }
        while (i >= 0){
            nums1[last] = nums2[i];
            i--;
            last--;
        }
    }
}
/*
 0  1  2  3  4 5
          j    l
[10,20,20,40,0,0] nums1
[1,2] nums2
 0 1
   i
*/