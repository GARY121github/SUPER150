package Arrays.LeetCode;

public class Alternating_Digit_Sum_2544 {
    public static void main(String[] args) {
        int n = 1111;
        System.out.println(alternateDigitSum(n));
    }
    static int alternateDigitSum(int n) {
        int number_of_digits = (int) (Math.log(n) / Math.log(10)) + 1;
        int ans = 0;
        if(number_of_digits%2 != 0){
            for(int i = 1 ; n > 0 ; i++){
                if(i%2 != 0){
                    ans += n%10;
                }
                else {
                    ans -= n%10;
                }

                n /= 10;
            }
        }
        else {
            for(int i = 1 ; n > 0 ; i++){
                if(i%2 == 0){
                    ans += n%10;
                }
                else {
                    ans -= n%10;
                }

                n /= 10;
            }
        }
        return ans;
    }

}
