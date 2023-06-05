package STACKS_AND_QUEUE.CODING_BLOCKS;

public class Decoded_String_at_Index_880 {
    public static void main(String[] args) {
        String s = "leet2code3";
        int k = 10;
        String ans = "leetleetcodeleetleetcodeleetleetcode";
    }

//    MEMORY-LimitExceededException
//    public String decodeAtIndex(String s, int k) {
//        StringBuilder word = new StringBuilder();
//        for(int i = 0 ; i < s.length() ; i++){
//            char ch = s.charAt(i);
//
//            if(ch >= '0' && ch <= '9'){
//                int n = ch - '0';
//                System.out.println(n);
//                StringBuilder current = new StringBuilder();
//                while (n-- > 0){
//                    current.append(word);
//                }
//                word = current;
//                System.out.println(word);
//            }
//            else{
//                word.append(ch);
//            }
//        }
//
//        System.out.println(word);
//        return String.valueOf(word.charAt(k-1));
//    }

    public String decodeAtIndex(String s, int k) {
        long size = 0;

        // CALCULATING THE SIZE OF THE DECODED STRING
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                size *= (ch - '0');
            }
            else{
                size++;
            }
        }

        for(int i = s.length()-1 ; i >= 0 ; i--){
            char ch = s.charAt(i);

            k %= size;
            if(k == 0 && !Character.isDigit(ch)){
                return String.valueOf(ch);
            }

            if(ch >= '0' && ch <= '9'){
                size /= (ch - '0');
            }
            else{
                size--;
            }
        }

        return "";
    }
}
