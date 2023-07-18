package Heap.Assignment;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
Nishant is a very naughty boy in Launchpad Batch. One day he was playing with strings, and randomly shuffled them all.
Your task is to help Nishant Sort all the strings ( lexicographically ) but if a string is present completely as a prefix in
another string, then string with longer length should come first. Eg bat, batman are 2 strings and the string bat is present as a
prefix in Batman - then sorted order should have - Batman, bat.

Input Format
N(integer) followed by N strings.

Constraints
N<=1000

Output Format
N lines each containing one string.

Sample Input
3
bat
apple
batman
Sample Output
apple
batman
bat
Explanation
In mathematics, the lexicographic or lexicographical order (also known as lexical order, dictionary order, alphabetical order or
lexicographic(al) product) is a generalization of the way words are alphabetically ordered based on the alphabetical order of their
component letters.
*/
public class String_Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               if(o1.indexOf(o2) == 0 || o2.indexOf(o1) == 0){
                   return Integer.compare(o2.length() , o1.length());
               }
               else{
                   return o1.compareTo(o2);
               }
            }
        });
        for (int i = 0 ; i < n ; i++){
            heap.add(sc.next());
        }
        while (!heap.isEmpty()){
            System.out.println(heap.remove());
        }
    }
}
