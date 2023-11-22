package Hashmap_and_Hashset;

import java.util.ArrayList;

public class MyHashmap<Key, Value> {
    private class Node {
        Key key;
        Value value;

        Node next;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private ArrayList<Node> bucketArray;

    public MyHashmap(int size) {
        this.bucketArray = new ArrayList<>();
        this.size = 0;
        for (int i = 0; i < size; i++) {
            this.bucketArray.add(null);
        }
    }

    public MyHashmap() {
        this(4);
    }

    private void rehashing() {
        ArrayList<Node> newBucketArray = new ArrayList<>();
        for (int i = 0; i < this.bucketArray.size() * 2; i++) {
            newBucketArray.add(null);
        }

        ArrayList<Node> oldBucketArray = this.bucketArray;
        this.bucketArray = newBucketArray;
        for (Node node : oldBucketArray) {
            while (node != null){
                put(node.key, node.value);
                node = node.next;
            }
        }
    }

    //    HASHCODE FUNCTION
    private int hashValue(Key key) {
        int hashcode = key.hashCode() % this.bucketArray.size();
        if (hashcode < 0) {
            hashcode += this.bucketArray.size();
        }
        return hashcode;
    }

    //    PUT KEY -> VALUE
    public void put(Key key, Value value) {
        int bucket = hashValue(key);

//        IF KEY IS ALREADY PRESENT
        Node head = this.bucketArray.get(bucket);
        while (head!=null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }

        Node node = new Node(key, value);
//        IF BUCKET IS EMPTY
        if (this.bucketArray.get(bucket) == null) {
            this.bucketArray.set(bucket, node);
            return;
        }

        Node start = this.bucketArray.get(bucket);
        node.next = start;
        this.bucketArray.set(bucket, node);

        this.size++;

        double loadFactor = (this.size * 1.0) / this.bucketArray.size();
        double thresholdFactor = 2.0;

        if (loadFactor > thresholdFactor) {
            rehashing();
        }
    }

    public Value get(Key key) {
        int bucket = hashValue(key);

        Node head = this.bucketArray.get(bucket);

        while (head != null) {
            if (head.key == key) {
                return head.value;
            }

            head = head.next;
        }

        return null;
    }

    public Value remove(Key key) {
        int bucket = hashValue(key);

        Node curr = this.bucketArray.get(bucket);
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                break;
            }

            prev = curr;
            curr = curr.next;
        }

//        IF THERE IS NO KEY PRESENT
        if (curr == null) {
            return null;
        }

//        IF THE KEY PRESENT IS THE HEAD OF THE BUCKET
        if (this.bucketArray.get(bucket) == curr) {
            this.bucketArray.set(bucket, curr.next);
            return curr.value;
        }

        prev.next = curr.next;
        curr.next = null;
        return curr.value;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        for (Node node : this.bucketArray){
            while (node != null){
                builder.append(node.key + "=" + node.value + ",");
                node = node.next;
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append(" }");

        return builder.toString();
    }
}
