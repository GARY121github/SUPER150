package Trie;


import java.util.HashMap;
import java.util.HashSet;

public class Trie {

    private class Node{
        char data;
        HashMap<Character , Node> childrens;

        boolean isTerminal;
        public Node(char data){
            this.data = data;
            this.childrens = new HashMap<>();
            this.isTerminal = false;
        }
    }
    private Node root;
    public Trie(){
        Node nn = new Node('*');
        this.root = nn;
    }

    public void insert(String word) {
        Node curr = this.root;
        for (int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            if(curr.childrens.containsKey(ch)){
                curr = curr.childrens.get(ch);
            }
            else {
                Node nn = new Node(ch);
                curr.childrens.put(ch , nn);
                curr = nn;
            }
        }

        curr.isTerminal = true;
    }

    public boolean search(String word) {
        Node curr = this.root;
        for (int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            if(curr.childrens.containsKey(ch)){
                curr = curr.childrens.get(ch);
            }
            else {
                return false;
            }
        }

        return curr.isTerminal;
    }

    public boolean startsWith(String word) {
        Node curr = this.root;
        for (int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            if(curr.childrens.containsKey(ch)){
                curr = curr.childrens.get(ch);
            }
            else {
                return false;
            }
        }

        return true;
    }
}
