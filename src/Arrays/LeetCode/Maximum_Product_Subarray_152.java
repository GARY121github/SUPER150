package Arrays.LeetCode;

public class Maximum_Product_Subarray_152 {
    public static void main(String[] args) {

    }

    static int max_product_subarray(int[] arr){
        int max_product = Integer.MIN_VALUE;
        int s = 0 ;
        int e = 0 ;
        int current = 1;
        while (e < arr.length){
            current *= arr[e];

            if(current > max_product){
                max_product = current;
            }

            if(current < 0){
                current = 1;
            }
        }
        return max_product;
    }
}
