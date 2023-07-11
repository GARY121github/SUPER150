package Assignment_6;
import java.util.Scanner;
import java.util.Stack;

/**
 Given an array of patterns containing only I’s and D’s. I for increasing and D for decreasing. Devise an algorithm to print the
 minimum number following that pattern. Digits from 1-9 and digits can’t repeat.

 Input Format
 The First Line contains an Integer N, size of the array. Next Line contains N Strings separated by space.

 Constraints
 1 ≤ T ≤ 100 1 ≤ Length of String ≤ 8

 Output Format
 Print the minimum number for each String separated by a new Line.

 Sample Input
 4
 D I DD II
 Sample Output
 21
 12
 321
 123
 Explanation
 For the Given sample case, For a Pattern of 'D' print a decreasing sequence which is 2 1.
 **/
public class Form_minimum_number_from_given_Sequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numStrings = scanner.nextInt();

        for (int i = 0; i < numStrings; i++) {
            String pattern = scanner.next();
            String sequence = generateSequence(pattern);
            System.out.println(sequence);
        }
    }

    private static String generateSequence(String pattern) {
        int currentNum = 1;
        int[] sequence = new int[pattern.length() + 1];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < sequence.length; i++) {
            // If the current character is 'I' or we have reached the end of the pattern
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                sequence[i] = currentNum++;
                // Pop elements from the stack and fill the sequence array
                while (!stack.isEmpty()) {
                    sequence[stack.pop()] = currentNum++;
                }
            } else {
                // Push the index to the stack if the current character is 'D'
                stack.push(i);
            }
        }

        // Convert the sequence array to a string and return it
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : sequence) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }
}
