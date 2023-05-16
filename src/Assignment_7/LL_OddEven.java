package Assignment_7;

import LinkedList.MyLinkedList;
import org.w3c.dom.Node;

import java.util.Scanner;

/*
Given a list, modify it such that all odd elements appear before the even ones. The order of odd elements and even shall
remain intact.

See explanation for more info.

Input Format
The first line contains an integer N, the number of elements in the list.

The next line contains N space separated integral elements of the list.

Constraints
1 <= T <= 1000 0 <= N <= 10^6

Output Format
T lines of output

Sample Input
5
1 2 3 4 5
Sample Output
1 3 5 2 4
Explanation
Input : 1 -> 2 -> 3 -> 11-> 4 -> 5

The order of odd elements and even does not change. For instance 3 comes before 5 in the input, so comes in the output.

Output: 1 -> 3 -> 11 -> 5 -> 2 -> 4
*/
public class LL_OddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MyLinkedList even = new MyLinkedList();
        MyLinkedList odd = new MyLinkedList();

        for(int i = 0 ; i < n ; i++){
            int x = sc.nextInt();
            if((x&1) == 0){
                even.addLast(x);
            }
            else{
                odd.addLast(x);
            }
        }

        odd.display();
        even.display();
    }
}
