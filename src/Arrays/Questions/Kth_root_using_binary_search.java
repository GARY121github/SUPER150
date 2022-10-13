package Arrays.Questions;

public class Kth_root_using_binary_search {
    public static void main(String[] args) {
        System.out.println(kthroot(63 , 3));
    }

    static int kthroot(int n , int k){
        int s = 1;
        int e = n;
        int ans = 0;
        while (s <= e){
            int mid = s + (e - s) / 2;
            if(Math.pow(mid , k) <= n){
                ans = mid;
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }
        return ans;
    }


}
