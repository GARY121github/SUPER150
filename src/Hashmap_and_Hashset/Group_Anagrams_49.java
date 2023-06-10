package Hashmap_and_Hashset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Group_Anagrams_49 {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> map = new HashMap<>();
        for(int i = 0 ; i < strs.length ; i++){
            String st = strs[i];
            String key = generateKey(st);

            if(map.containsKey(key)){
                map.get(key).add(st);
            }
            else{
                map.put(key , new ArrayList<>());
                map.get(key).add(st);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (String i : map.keySet()){
            ans.add(map.get(i));
        }
        return ans;
    }

    private static String generateKey(String st){
        int[] arr = new int[26];
        for(int i = 0; i < st.length() ; i++){
            char ch = st.charAt(i);
            arr[ch - 'a']++;
        }

        StringBuilder builder = new StringBuilder();
        for (int i : arr){
            builder.append(i + " ");
        }
        return builder.toString();
    }
}
