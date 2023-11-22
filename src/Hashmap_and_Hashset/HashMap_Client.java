package Hashmap_and_Hashset;

public class HashMap_Client {
    public static void main(String[] args) {
        MyHashmap<Integer , Integer> map = new MyHashmap<>();
        for (int i = 1 ; i <= 10 ; i++){
            map.put(i , i*i);
        }
        System.out.println(map);
        map.remove(3);
        System.out.println(map);
        map.put(2 , 2);
        System.out.println(map);
    }
}
