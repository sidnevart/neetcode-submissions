class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int l = 0;
        int right = 0;
        for (int r = 0; r < arr.length; r++){
            if (r - l == k){
                if (isCloser(arr[l], arr[r], x)){
                    right = r;
                    break;
                } else {
                    l++;
                }
            }
        }
        right = right == 0 ? arr.length : right;
        while (l < right){
            res.add(arr[l]);
            l++;
        }

        return res;
    }

    public boolean isCloser(int a, int b, int x){
        return (Math.abs(a - x) < Math.abs(b - x)) || (Math.abs(a - x) == Math.abs(b - x) && a < b);
    }
}