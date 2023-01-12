package Recursion;

public class Print_all_the_ways_to_achive_the_number_from_the_dice {
    public static void main(String[] args) {
        System.out.println(count_number_of_ways(3 , "" , 0 , 4));
    }

    static int count_number_of_ways(int face , String ans , int num ,int target){
        if(num > target){
            return 0;
        }
        if(num == target){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for(int i = 1 ; i <= face ; i++){

            count += count_number_of_ways(face , ans+i , num+i , target);
        }
        return count;
    }
}

