package Recursion;

public class AkiPowerB {
    public static void main(String[] args) {
        System.out.println(power(2, 3 , 1));
    }

    static int power(int a , int b , int pow){
        if(b==0){
            return pow;
        }

        return power(a , b-1 , pow*a);
    }
}
