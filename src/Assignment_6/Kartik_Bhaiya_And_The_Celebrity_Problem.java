package Assignment_6;

import java.util.Scanner;
import java.util.Stack;

/*
Kartik Bhaiya, mentor at Coding Blocks, organized a party for their interns at Coding Blocks.
At a party of N people, only one person is known to everyone. Such a person may be present in the party, if yes,
she/he does’t know anyone in the party. We can only ask questions like “does A know B? “.
Find the stranger (celebrity) in minimum number of questions.

Input Format
First line contains N, number of persons in party. Next line contains the matrix of N x N which represents A knows B
when it's value is one.

Constraints
None

Output Format
Print the celebrity ID which is between 0 and N-1. If celebrity is not present then print "No Celebrity".

Sample Input
4
0 0 1 0
0 0 1 0
0 0 0 0
0 0 1 0
Sample Output
2
Explanation
In the given case there are 4 persons in the party let them as A, B, C, D. The matrix represents A knows B when it's
value is one. From the matrix, A knows C, B knows C and D knows C. Thus C is the celebrity who doesn't know anyone, and
it's ID is 2. Hence, output is 2.
*/
public class Kartik_Bhaiya_And_The_Celebrity_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int ans = isCelebrity(arr);
        if(ans == -1){
            System.out.println("No Celebrity");
        }
        else{
            System.out.println(ans);
        }
    }

    static int isCelebrity(int[][] arr){
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < arr.length ; i++){
            stack.push(i);
        }

        while (stack.size() > 1){
            int p1 = stack.pop();
            int p2 = stack.pop();

            if(arr[p1][p2] == 1 && arr[p2][p1] == 0){
                stack.push(p2);
            }
            else if(arr[p1][p2] == 0 && arr[p2][p1] == 1){
                stack.push(p1);
            }
        }

        if(stack.size() == 0){
            return -1;
        }

        int check = stack.pop();
        for(int i = 0 ; i < arr.length ; i++){
            if(i == check){
                continue;
            }

            if(arr[i][check] == 0 || arr[check][i] == 1){
                return -1;
            }
        }

        return check;
    }
}
