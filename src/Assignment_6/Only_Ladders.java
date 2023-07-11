package Assignment_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 Take as input N, a number. N is the size of a snakes and ladders board. There are no snakes, but we’ve ladders from 1st prime number
 to last prime number in range, 2nd prime number to 2nd from last prime number and so-on.

 a. Write a recursive function which returns the count of different distinct ways this board can be crossed with a normal dice.
 Print the value returned.

 b. Write a recursive function which prints all valid paths (void is the return type for function).

 Input Format
 Enter the size of the snake and ladders board N

 Constraints
 None

 Output Format
 Display the number of ways in which the board can be crossed and also display all the possible ways to cross the board in a
 comma separated manner

 Sample Input
 3
 Sample Output
 0 1 2 END , 0 1 END , 0 2 END , 0 END ,
 4
 **/
public class Only_Ladders {
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];

        // Finding primes up to n
        for (int i = 2; i <= n; i++) {
            int f = 0;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    f = 1;
                    break;
                }
            }
            if (f == 0) {
                arr[i] = 1;
            }
        }

        // Updating the array for snake and ladder positions
        int i = 0, j = n;
        while (i <= j) {
            if (arr[i] == 1 && arr[j] != 1) {
                j--;
            } else if (arr[i] != 1 && arr[j] == 1) {
                i++;
            } else if (arr[i] == 1 && arr[j] == 1) {
                arr[i] = j;
                if (i != j) {
                    arr[j] = 0;
                }
                i++;
                j--;
            } else {
                i++;
                j--;
            }
        }

        path(n, 0, "0 ", arr);
        System.out.println("\n" + count);
    }

    static void path(int n, int position, String ans, int[] arr) {
        if (n == position) {
            System.out.print(ans + "END , ");
            count++;
            return;
        }

        for (int i = 1; i <= 6; i++) {
            if (position + i < n) {
                String str = "";
                if (arr[position + i] != n) {
                    str = arr[position + i] + " ";
                }

                if (arr[position + i] != 0) {
                    path(n, arr[position + i], ans + (position + i) + " " + str, arr);
                } else {
                    path(n, position + i, ans + (position + i) + " ", arr);
                }
            } else if (position + i == n) {
                path(n, position + i, ans + "", arr);
            }
        }
    }
}
