package Assignment_4;

/*


Kartik Bhaiya has a string consisting of only 'a' and 'b' as the characters.
Kartik Bhaiya describes perfectness of a string as the maximum length substring of equal characters.
Kartik Bhaiya is given a number k which denotes the maximum number of characters he can change.
Find the maximum perfectness he can generate by changing no more than k characters.

Input Format
The first line contains an integer denoting the value of K. The next line contains a string having only ‘a’ and ‘b’ as
the characters.

Constraints
2 ≤ N ≤ 10^6

Output Format
A single integer denoting the maximum perfectness achievable.

Sample Input
2
abba
Sample Output
4
Explanation
We can swap the a's to b using the 2 swaps and obtain the string "bbbb". This would have all the b's and hence the answer 4.
Alternatively, we can also swap the b's to make "aaaa". The final answer remains the same for both cases.

*/


import java.util.Scanner;

public class Kartik_Bhaiya_And_Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String st = sc.next();
        int a = max_length_substring(st , 'b' , k);
        int b = max_length_substring(st ,  'a' , k);
        System.out.println(Math.max(a , b));

    }

    static int max_length_substring(String st , char ch , int k){
        int s = 0;
        int e = 0;
        int flip = 0;
        int ans = 0;
        while (e < st.length()){
            if(st.charAt(e) == ch){
                flip++;
            }

            while (flip > k){
                if(st.charAt(s) == ch){
                    flip--;
                }
                s++;
            }

            ans = Math.max(ans , e - s + 1);
            e++;
        }
        return ans;
    }
}
