package Hashmap_and_Hashset;

import java.util.HashMap;

/**
 Input: nums = [100,4,200,1,3,2]
 Output: 4
 Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
* */
public class Longest_Consecutive_Sequence_128 {
    public static void main(String[] args) {

    }
    public int longestConsecutive(int[] arr) {
        HashMap<Integer , Boolean> map = new HashMap<>();
        for (int i : arr){
            if(map.containsKey(i-1)){
                map.put(i , false);
            }
            else{
                map.put(i , true);
            }

            if(map.containsKey(i+1)){
                if(map.get(i+1)){
                    map.put(i+1 , false);
                }
            }
        }

        int ans = longest(map);
        return ans;
    }

    private int longest(HashMap<Integer ,Boolean> map){
        int ans = 0;
        for (int i : map.keySet()){
            if(map.get(i)){
                int count = 1;
                while (map.containsKey(i+1)){
                    count++;
                    i++;
                }
                ans = Math.max(count , ans);
            }
        }
        return ans;
    }
}
