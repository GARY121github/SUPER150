package Assignment_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Take as input N, a number. Write a recursive function which prints counting from 0 to N in lexicographical order.
In lexicographical (dictionary) order 10, 100 and 109 will be printed before 11.

Input Format
Enter a number N.

Constraints
None

Output Format
Display all the numbers upto N in a lexicographical order

Sample Input
10
Sample Output
0 1 10 2 3 4 5 6 7 8 9
*/
public class Recursion_Lexicographical_Order {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = lexicalOrder(n , 0);
        for(int i : list){
            System.out.print(i + " ");
        }
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
