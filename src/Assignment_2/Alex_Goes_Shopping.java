package Assignment_2;

/*
It is Alex’s birthday and she wants to go shopping. She only has ‘A’ units of money and she wants to spend all of her money.
However, she can only purchase one kind of item. She goes to a shop which has ‘n’ types items with prices A0,A1,A2,…,An-1.
The shopkeeper claims that he has atleast ‘k’ items she can choose from. Help her find out if the shopkeeper is correct or not.

Input Format
The first line contains an integer ‘n’ denoting the number of items in the shop. The second line contains ‘n’ space-separated
integers describing the respective price of each item. The third line contains an integer ‘q’ denoting the number of queries.
Each of the subsequent lines contains two space-separated integers ‘A’ and ‘k’

Constraints
1 <=n, Ai, A <= 10^5 where 0<=i

1 <= q <= 2*n
1 <= k <= n
The array may contain duplicate elements.

Output Format
For each query, print Yes on a new line if the shopkeeper is correct; otherwise, print No instead.

Sample Input
4
100 200 400 100
5
100 2
200 3
500 4
600 4
800 4
Sample Output
Yes
Yes
No
No
Yes
Explanation
In query 1, Alex has 100 units of money. The shopkeeper claims that she can choose to buy from 2 kinds of items
i.e. item 1 and item 4 each priced at 100.

In query 2, The shopkeeper claims that she can choose to buy from 3 kinds of items ie item 1 and item 4 each priced
at 100(she can buy 1 from either of the two), or item 2 priced at 200(she can buy one)

In query 3, she has 500 units of money. She can either buy item 1 or item 4 ( 5 of each kind respectively).
Thus, she has only 2 kinds of items to choose from.

In query 5, she has 800 units of money. She can either buy item 1 or item 4 ( 8 of each kind respectively) or
item 2(she can buy 4 of these) or item 3(2 of these). Thus, she has 4 kinds of items to choose from.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Alex_Goes_Shopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int q = sc.nextInt();
        while (q-- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int total_elements = total_elements_can_be_purchased(arr , x);
            if(total_elements == y)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
    static int total_elements_can_be_purchased(int[] arr , int capacity){
        int s = 0;
        int e = 0;
        int sum_till_now = 0;
        int total_elements = 0;
        System.out.println(Arrays.toString(arr));
        System.out.println("Total Money Alex Have ---> " + capacity);
        while (s < arr.length) {

            if(arr[s] > capacity){
                System.out.println(arr[s] + "   " + capacity);
                break;
            }

            if (sum_till_now == capacity) {
                total_elements += 1;
                sum_till_now = 0;
                System.out.println("SUM TILL NOW FOR " + s + " when matched  ----> " + sum_till_now);
                s++;
                e = s;
            } else if (sum_till_now < capacity && e < arr.length) {
                sum_till_now += arr[e];
                System.out.println("SUM TILL NOW FOR " + s + " ----> " + sum_till_now);
                e++;
            } else{
                System.out.println("SUM TILL NOW FOR terminating " + s + " ----> " + sum_till_now);
                sum_till_now = 0;
                s = s + 1;
                e = s;
            }
        }
        System.out.println("Total Elements could be bought " + total_elements);
        return total_elements;
    }
}
