import java.util.Arrays;

public class Shapes {

     public static void main(String[] args) {
       int[] arr = {1,0,0,1,0,1};
       tow_pointers_app(arr);
     }

     static void tow_pointers_app(int[] arr){
          int p1 = 0;
          int p2 = arr.length - 1;
          while (p1 != p2){
               if(arr[p2] == 0){
                    if(arr[p1] == 1){
                         int temp = arr[p1];
                         arr[p1] = arr[p2];
                         arr[p2] = temp;
                    }
                    else{
                         p1++;
                    }
               }
               else{
                    p2--;
               }
          }

          System.out.println(Arrays.toString(arr));
     }

     static int count_number_of_zero(int[] arr){
          int number_of_zero = 0;
          for(int i = 0 ; i < arr.length ; i++){
               if(arr[i] == 0){
                    number_of_zero++;
               }
          }
          return number_of_zero;
     }
}
