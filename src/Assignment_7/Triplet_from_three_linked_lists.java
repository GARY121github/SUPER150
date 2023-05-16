package Assignment_7;

import LinkedList.MyLinkedList;

import java.util.LinkedList;
import java.util.Scanner;

/*

Given three linked lists, say a, b and c, find one node from each list such that the sum of the values of the nodes is equal to a given
number say, Target. As any number of answers can be possible return the first one you get while traversing.

Input Format
The First Line contains 3 Integers n, m and k as the Size of the Three LinedLists. Next 3 Lines contains n, m and k integers
Respectively as the elements of Linked Lists. Next Line contains the Integer as Target.

Constraints
The Size of the Lists can be different.

Output Format
Display the 3 elements from each of the Lists whose sum is equals to the target separated by space.

Sample Input
3 3 3
12 6 29
23 5 8
90 20 59
101
Sample Output
6 5 90
Explanation
In the Given Sample Input, 6, 5 and 90 from lists 1, 2 and 3 respectively add to give 101.

*/
public class Triplet_from_three_linked_lists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p1 = sc.nextInt();
        int p2 = sc.nextInt();
        int p3 = sc.nextInt();

        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        LinkedList<Integer> list3 = new LinkedList<>();

        for(int i = 0 ; i < p1 ; i++){
            list1.add(sc.nextInt());
        }
        for(int i = 0 ; i < p2 ; i++){
            list2.add(sc.nextInt());
        }
        for(int i = 0 ; i < p3 ; i++){
            list3.add(sc.nextInt());
        }

        int target = sc.nextInt();

        for(int i = 0 ; i < list1.size() ; i++){
            for(int j = 0 ; j < list2.size() ; j++){
                for(int k = 0 ; k < list3.size() ; k++){
                    int sum = list1.get(i) + list2.get(j) + list3.get(k);
                    if(sum == target){
                        System.out.println(list1.get(i) + " " + list2.get(j) + " " + list3.get(k));
                        return;
                    }
                }
            }
        }
    }
}
