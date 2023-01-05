package Recursion;

public class Factorial_using_tail_recursion {
    public static void main(String[] args) {
        System.out.println(factorial(5 , 1 , 1));
    }

    static int factorial(int n , int i , int ans){
        if(n == 0){
            return ans;
        }

        if(i == n){
            return ans*i;
        }

        return factorial(n , i+1 , ans*i);
    }
}
