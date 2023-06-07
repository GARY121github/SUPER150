package Arrays.Algorithm;

import java.util.Arrays;

public class SORTING {
    public static void main(String[] args) {
        int[] arr = {10 , 9 , 8 , 6 , 5, 3 , 2 , 1};
        System.out.println("BEFORE SORTING -> " + Arrays.toString(arr));
//        insertionSort(arr);
        selectionSort(arr);
//        bubbleSort(arr);
        System.out.println("AFTER SORTING -> " + Arrays.toString(arr));
    }

    static void insertionSort(int[] arr){

        for(int i = 1 ; i < arr.length ; i++){
            int j = i-1;
            int item = arr[i];

            while (j >= 0 && arr[j] > item){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = item;
        }
    }

    static void selectionSort(int[] arr){

        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i + 1 ; j < arr.length ; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static void bubbleSort(int[] arr){

        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr.length - 1 -i ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }
}
