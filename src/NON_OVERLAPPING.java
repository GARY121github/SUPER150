import java.util.List;

public class NON_OVERLAPPING {
    public static void main(String[] args) {
        int[][] arr = {
                {1,3},
                {1,4},
                {5,1}
        };
    }

    public static int maxNon_Overlapping(List<Integer> list , int[][] arr , int index){
        if(index == arr.length){
            boolean check = check(arr , list);
            if(check(arr , list)){
                return list.size();
            }
            else{
                return 0;
            }
        }

//        choose
        list.add(index);
        int c1 = maxNon_Overlapping(list , arr , index+1);
        list.remove(list.size()-1);
//        not choose
        int c2 = maxNon_Overlapping(list , arr , index+1);

        return Math.max(c1 , c2);
    }

    private static boolean check(int[][] arr , List<Integer> list){
        for(int i = 1 ; i < list.size() ; i++){
            for(int j = 0 ; j < i ; j++){
                int c = list.get(i);
                int p = list.get(j);
                if(arr[c][0] < arr[p][0] || arr[c][1] < arr[p][1]){
                    return false;
                }
            }
        }
        return true;
    }
}
