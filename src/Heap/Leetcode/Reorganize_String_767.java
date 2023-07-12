package Heap.Leetcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Reorganize_String_767 {
    public static void main(String[] args) {

    }
    public String reorganizeString(String st) {
        Map<Character , Integer> map = new HashMap<>();
        for (int i = 0 ; i < st.length() ; i++){
            char ch = st.charAt(i);
            map.put(ch , map.getOrDefault(ch , 0) + 1);
            if(map.get(ch) >= st.length()/2){
                return "";
            }
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((a , b) -> map.get(a) - map.get(b));
        queue.addAll(map.keySet());
        char[] arr = new char[st.length()];
        int index = 0;
        while (!queue.isEmpty()){
            char code = queue.remove();
            int freq = map.get(code);

            while (freq-- > 0){
                if(index == arr.length){
                    index = 1;
                }
                arr[index] = code;
                index += 2;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0 ; i < arr.length ; i++){
            if(i != arr.length-1 && arr[i] == arr[i+1]){
                return "";
            }
            builder.append(arr[i]);
        }

        return builder.toString();
    }
}
