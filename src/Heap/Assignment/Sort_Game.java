package Heap.Assignment;

import java.util.*;

/*
Sanju needs your help! He gets a list of employees with their salary. The maximum salary is 100.

Sanju is supposed to arrange the list in such a manner that the list is sorted in decreasing order of salary. And if two employees have
the same salary, they should be arranged in lexicographical manner such that the list contains only names of those employees having
salary greater than or equal to a given number x.

Help Sanju prepare the same!

Input Format
On the first line of the standard input, there is an integer x. The next line contans integer N, denoting the number of employees.
N lines follow, which contain a string and an integer, denoting the name of the employee and his salary.

Constraints
1 <= N <= 10^5 1 <= | Length of the name | <= 100 1 <= x, salary <= 100

Output Format
You must print the required list.

Sample Input
79
4
Eve 78
Bob 99
Suzy 86
Alice 86

Sample Output
Bob 99
Alice 86
Suzy 86
*/
public class Sort_Game {
    static class pair{
        String name;
        int salary;
        public pair(String name , int salary){
            this.name = name;
            this.salary = salary;
        }
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int x = sc.nextInt();
       int n = sc.nextInt();
       ArrayList<pair> list = new ArrayList<>();
       for (int i = 0 ; i < n ; i++){
           String name = sc.next();
           int salary = sc.nextInt();
           if(salary >= x){
               pair ob = new pair(name , salary);
               list.add(ob);
           }
       }

       PriorityQueue<pair> heap = new PriorityQueue<>(new Comparator<pair>() {
           @Override
           public int compare(pair o1, pair o2) {
               if(o1.salary != o2.salary){
                   return o2.salary - o1.salary;
               }
               else {
                   return o1.name.compareTo(o2.name);
               }
           }
       });
       heap.addAll(list);
       while (!heap.isEmpty()){
           pair ob = heap.remove();
           System.out.println(ob.name + " " + ob.salary);
       }
    }
}
