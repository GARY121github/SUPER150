package Assignment_7;

import java.util.Scanner;

/*
You are given number of pages in n different books and m students. The books are arranged in ascending order of number of pages.
Every student is assigned to read some consecutive books. The task is to assign books in such a way that the maximum number of pages
assigned to a student is minimum.

Input Format
First line contains integer t as number of test cases. Next t lines contains two lines. For each test case, 1st line contains two
integers n and m which represents the number of books and students and 2nd line contains n space separated integers which represents
the number of pages of n books in ascending order.

Constraints
1 < t < 50
1< n < 100
1< m <= 50
1 <= Ai <= 1000

Output Format
Print the maximum number of pages that can be assigned to students.

Sample Input
1
4 2
12 34 67 90
Sample Output
113
Explanation
1st students : 12 , 34, 67 (total = 113)
2nd students : 90 (total = 90)
Print max(113, 90)
*/
public class Book_Allocation_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int number_of_students = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < arr.length ; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(max_pages(arr , number_of_students));
        }
    }

    static int max_pages(int[] arr , int number_of_students){
        int s = 0;
        int e = 0;
        for(int i : arr){
            e += i;
        }
        int ans = 0;
        while (s <= e){
            int mid = s + (e - s)/2;

            if(isPossible(arr , number_of_students , mid)){
                ans = mid;
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        return ans;
    }

    static boolean isPossible(int[] arr , int nos , int max){
        int student = 1;
        int sum_till_now = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(sum_till_now + arr[i] <= max){
                sum_till_now += arr[i];
            }
            else{
                i--;
                sum_till_now = 0;
                student++;
            }

            if(student > nos){
                return false;
            }
        }
        return true;
    }
}
