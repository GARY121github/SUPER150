package OOPS;

import STACKS_AND_QUEUE.My_Queue;

public class Dynamic_Queue extends My_Queue {
    @Override
    public void Enqueue(Object data) throws Exception {
        if(super.isFull()){
            Object[] new_data = new Object[super.data.length];
            for(int i = super.front ; i < size() ; i++){
                new_data[i] = super.data[i];
            }

            super.data = new_data;
        }
        super.Enqueue(data);
    }
}
