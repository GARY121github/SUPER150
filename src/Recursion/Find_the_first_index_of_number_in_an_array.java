package Recursion;

public class Find_the_first_index_of_number_in_an_array {
    public static void main(String[] args) {
        int[] arr = {2,3,7,2,5,7,9,7};
        int target = 7;
//        System.out.println(first_index(arr , 0 , target));
        System.out.println(last_index(arr , arr.length-1 , target));
    }

    static int first_index(int[] arr, int index,int target){

        if(index == arr.length){
            return -1;
        }

        if(arr[index] == target){
            return index;
        }

        return first_index(arr , index+1 , target);

    }

    static int last_index(int[] arr , int index , int target){
        if(index < 0){
            return -1;
        }

        if(arr[index] == target){
            return index;
        }

        return first_index(arr , index-1 , target);

    }
}
