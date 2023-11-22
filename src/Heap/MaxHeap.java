package Heap;

import java.util.ArrayList;

public class MaxHeap {
    private ArrayList<Integer> maxHeap;
    private int size;

    public MaxHeap(){
        this.maxHeap = new ArrayList<>();
        this.size = 0;
    }

    public void add(int data){
        maxHeap.add(data);
    }
}
