package Recursion;

public class Print_All_the_combination_of_head_and_tail {
    public static void main(String[] args) {
        printHeadTails(3 , "");
        System.out.println("-------------------------------------");
        print_Head_Tails_which_does_not_contains_consucitive_head(3 , "");

    }

    static void printHeadTails(int n , String ans){
        if(n == 0){
            System.out.println(ans);
            return;
        }



        //pic head
        printHeadTails(n-1 , ans+'H');

        //pic tails
        printHeadTails(n-1 , ans+'T');
    }

    static void print_Head_Tails_which_does_not_contains_consucitive_head(int n, String ans){

        if(n == 0){
            for(int i = 0 ; i < ans.length()-1 ; i++){
                if(ans.charAt(i) == 'H' && ans.charAt(i+1) == 'H'){
                    return;
                }
            }
            System.out.println(ans);
            return;
        }



        //pic head
        printHeadTails(n-1 , ans+'H');

        //pic tails
        printHeadTails(n-1 , ans+'T');

    }
}
