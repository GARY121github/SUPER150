package OOPS;

import STACKS_AND_QUEUE.My_Stack;

public class Dynamic_Stack extends My_Stack {
    @Override
    public void push(Object data) throws Exception {
        if(super.isFull()){
            Object[] new_data = new Object[super.data.length * 2];
            for(int i = 0 ; i < super.data.length ; i++){
                new_data[i] = super.data[i];
            }
            super.data = new_data;
        }

        super.push(data);
    }
}
