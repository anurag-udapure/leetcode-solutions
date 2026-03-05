import java.util.Arrays;

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        
        int totalApples = 0;
        for(int a : apple){
            totalApples += a;
        }

        Arrays.sort(capacity);  // sort ascending
        
        int boxes = 0;
        int currCapacity = 0;

        for(int i = capacity.length - 1; i >= 0; i--){
            currCapacity += capacity[i];
            boxes++;
            
            if(currCapacity >= totalApples){
                return boxes;
            }
        }

        return boxes;
    }
}