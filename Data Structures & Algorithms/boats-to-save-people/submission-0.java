class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int res = 0;
        while (left <= right){
            int pairSum = people[left] + people[right];
            if (pairSum > limit){
                res++;
            } else {
                res++;
                left++;
            }
            right--;
        }

        return res;
    }
}