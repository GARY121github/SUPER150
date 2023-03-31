package Assignment_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*
You are at a casino. There are N stacked cards on pile A0. Each card has a number written on it.
Then there will be Q iterations. In ith iteration, you start picking up the cards in Ai-1th pile from the top one by
one and check whether the number written on the card is divisible by the ith prime number. If the number is divisible,
you stack that card on pile Bi. Otherwise, you stack that card on pile Ai. After Q iterations, cards can only be on
pile B1, B2, B3, . . . BQ, AQ . Output numbers on these cards from top to bottom of each piles in order of
B1, B2, B3, . . . BQ, AQ .

Input Format
First line contains N and Q. The next line contains N space separated integers representing the initial pile of cards
i.e., A0. The leftmost value represents the bottom plate of the pile.

Constraints
N < 10^5
Q < 10^5
|Ai| < 10^9

Output Format
Output N lines, each line containing the number written on the card.

Sample Input
5 1
3 4 7 6 5
Sample Output
4
6
3
7
5
Explanation
Initially:

A0 = [3, 4, 7, 6, 5]<-TOP

After 1st iteration:

A0 = []<-TOP

A1 = [5, 7, 3]<-TOP

B1 = [6, 4]<-TOP

Now first print B1 from top to bottom then A1 from top to bottom.
*/
public class Playing_with_cards_In_stack {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int q = sc.nextInt();
            Stack<Integer> stack = new Stack<>();
            for(int i = 0 ; i < n ; i++){
                stack.push(sc.nextInt());
            }
            casino(stack , q);
        }

        static void casino(Stack<Integer> stack , int q){
            List<Integer> primes = getPrimes(q);
            Stack<Integer> a = new Stack<>();
            Stack<Integer> b = new Stack<>();

            for(int i = 0 ; i < primes.size() ; i++){
                int n = primes.get(i);
                while (!stack.isEmpty()){
                    int element = stack.pop();

                    if(element % n == 0){
                        b.push(element);
                    }
                    else{
                        a.push(element);
                    }
                }

                while (!b.isEmpty()){
                    System.out.println(b.pop());
                }

                stack = a;
                a = new Stack<>();
            }

            while (!stack.isEmpty()){
                System.out.println(stack.pop());
            }
        }

        public static List<Integer> getPrimes(int n) {
            List<Integer> primes = new ArrayList<>();
            primes.add(2);
            for (int i = 3; primes.size() < n; i += 2) {
                boolean isPrime = true;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    primes.add(i);
                }
            }
            return primes;
        }
    }
