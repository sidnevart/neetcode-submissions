class Solution {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> colorFreq = new HashMap<>();
        colorFreq.put(0,0);
        colorFreq.put(1,0);
        colorFreq.put(2,0);

        for (int color : nums){
            colorFreq.put(color, colorFreq.get(color) + 1);
        }
        int idx = 0;
        for (int colorVal = 0; colorVal < 3; colorVal++){
            while (colorFreq.get(colorVal) != 0){
                nums[idx++] = colorVal;
                colorFreq.put(colorVal, colorFreq.get(colorVal) - 1);
            }
        }

    }
}

/*
0 - red
1 - white
2 - blue 

red -> white -> blue 

1 0 1 2
0 1 1 2

1 approach:
map {0: 1, 1: 2, 2: 1} O(n) to fill in
idx = 0
color ... colors (0 < 3):
    while {color} is in map
        nums[idx++] = 0
        map.get(0) -= 1 

*/