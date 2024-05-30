package LeetCode9;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> arr = new ArrayList<>();
        int max = 0;
        for (int i = 0; i <candies.length; i++) {
            if(max <= candies[i]){
                max = candies[i];
            }
        }
        for (int i = 0; i <candies.length; i++) {
            int sum = candies[i] + extraCandies;
            if(sum >= max){
                arr.add(true);
            }else {
                arr.add(false);
            }
        }
        return arr;
    }
}