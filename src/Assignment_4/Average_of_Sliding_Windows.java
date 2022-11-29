package Assignment_4;

/*

You have to given a data stream terminated by -1 and the size of sliding window.
For each variation in sliding window you need to tell the average of data in current sliding window.
Print 4 digits after the decimal point.

Input Format
First line contains an integer denoting the size of sliding window.
Second line has a data stream terminated by -1.

Constraints
None

Output Format
Print average of each sliding window.

Sample Input
5
51 62 24 51 79 33 72 78 84 42 -1
Sample Output
51.0000 56.5000 45.6667 47.0000 53.4000 49.8000 51.8000 62.6000 69.2000 61.8000
Explanation
None

*/

import java.util.ArrayList;
import java.util.Scanner;

public class Average_of_Sliding_Windows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double k = sc.nextInt();
        ArrayList<Double> list = new ArrayList<>();
        while (true){
            double x = sc.nextDouble();
            if(x == -1){
                break;
            }
            list.add(x);
        }
        avg(list , k);
    }

    static void avg(ArrayList<Double> list , double k){
        int p1 = 0;
        int p2 = 0;
        double sliding_window = 0;

//        GROW WINDOW TILL K
        while (p2 < k){
            sliding_window += list.get(p2++);
            System.out.format("%.4f", (sliding_window / (p2)));
            System.out.print(" ");
        }

        while (p2 < list.size()){

//            SHRINK WINDOW
            sliding_window = sliding_window - list.get(p1++);

//            GROW WINDOW
            sliding_window += list.get(p2++);
            System.out.format("%.4f" , (sliding_window / k));
            System.out.print(" ");
        }
    }
}
