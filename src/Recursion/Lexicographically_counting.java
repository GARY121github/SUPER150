package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Lexicographically_counting {
    public static void main(String[] args) {
        System.out.println(lexicalOrder(1000 , 0));
    }

    static List<Integer> lexicalOrder(int n , int current) {
        List<Integer> list = new ArrayList<>();
        if(current > n){
            return list;
        }

        list.add(current);

        int i = 0;
        if(current == 0){
            i = 1;
        }

        for( ; i <= 9 ; i++){
            list.addAll(lexicalOrder(n , current*10 + i));
        }

        return list;
    }
}
