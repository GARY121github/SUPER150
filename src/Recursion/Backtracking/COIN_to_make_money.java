package Recursion.Backtracking;

public class COIN_to_make_money {
    public static void main(String[] args) {
        int[] arr = {2,3,5};
        int target = 10;
        possibleCombinations(arr , target , 0 , 0 , "");
    }

    static void possibleCombinations(int[] arr , int target , int sum , int index , String ans){
        if(sum == target){
            System.out.println(ans);
            return;
        }
        if(sum > target){
            return;
        }

        for(int i = index ; i < arr.length ; i++){
            sum += arr[i];
            possibleCombinations(arr , target , sum , i , ans+arr[i]);
            sum -= arr[i];
        }
    }
}
