package Assignment_6;

import java.util.Scanner;

public class Balanced_Parenthesis {

        public static void main(String[] args) throws Exception {
            // TODO Auto-generated method stub
            Scanner s = new Scanner(System.in);
            String str = s.next();
            Balanced_Parenthesis mainobj = new Balanced_Parenthesis();
            StacksUsingArrays stack = mainobj.new StacksUsingArrays(1000);
            if (isBalanced(str, stack)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }

        public static boolean isBalanced(String st, StacksUsingArrays stack) throws Exception {
            for(int i = 0 ; i < st.length() ; i++){
                char ch = st.charAt(i);

                int p_num = parentheses(ch);

                if(p_num < 0){
                    if(stack.isEmpty()){
                        return false;
                    }

                    int tos = stack.pop() + p_num;

                    if(tos != 0){
                        return false;
                    }
                }
                else if(p_num > 0){
                    stack.push(p_num);
                }
            }

            if(!stack.isEmpty()){
                return false;
            }

            return true;
        }

        static int parentheses(char ch){
            if(ch == '('){
                return  1;
            }
            else if(ch == '['){
                return 2;
            }
            else if(ch == '{'){
                return 3;
            }
            else if(ch == ')'){
                return -1;
            }
            else if(ch == ']'){
                return -2;
            }
            else if(ch == '}'){
                return -3;
            }
            else{
                return 0;
            }
        }

        private class StacksUsingArrays {
            private int[] data;
            private int tos;

            public static final int DEFAULT_CAPACITY = 10;

            public StacksUsingArrays() throws Exception {
                // TODO Auto-generated constructor stub
                this(DEFAULT_CAPACITY);
            }

            public StacksUsingArrays(int capacity) throws Exception {
                if (capacity <= 0) {
                    System.out.println("Invalid Capacity");
                }
                this.data = new int[capacity];
                this.tos = -1;
            }

            public int size() {
                return this.tos + 1;
            }

            public boolean isEmpty() {
                if (this.size() == 0) {
                    return true;
                } else {
                    return false;
                }
            }

            public void push(int item) throws Exception {
                if (this.size() == this.data.length) {
                    throw new Exception("Stack is Full");
                }
                this.tos++;
                this.data[this.tos] = item;
            }

            public int pop() throws Exception {
                if (this.size() == 0) {
                    throw new Exception("Stack is Empty");
                }
                int retVal = this.data[this.tos];
                this.data[this.tos] = 0;
                this.tos--;
                return retVal;
            }

            public int top() throws Exception {
                if (this.size() == 0) {
                    throw new Exception("Stack is Empty");
                }
                int retVal = this.data[this.tos];
                return retVal;
            }

            public void display() throws Exception {
                if (this.size() == 0) {
                    throw new Exception("Stack is Empty");
                }
                for (int i = this.tos; i >= 0; i--) {
                    System.out.println(this.data[i]);
                }

            }

        }
}
