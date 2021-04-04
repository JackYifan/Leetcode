import org.junit.Test;

import java.util.*;

/**
 * @Author Yifan Wu
 * Date on 2021/3/14  22:32
 */
public class Solution706 {
    class MyHashMap {

        class Entry{
            int key;
            int value ;
            Entry(int key,int value){
                this.key = key;
                this.value = value;
            }

            public void setKey(int key) {
                this.key = key;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }
        public final int threshold = 997;
        List<Entry>[] hashTable ;
        /** Initialize your data structure here. */
        public MyHashMap() {
            hashTable = new LinkedList[threshold];
            for(int i=0;i<threshold;i++){
                hashTable[i] = new LinkedList<>();
            }
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hash = key%threshold;
            List<Entry> bucket = hashTable[hash];
            for(int i=0;i<bucket.size();i++){
                if(bucket.get(i).key==key){
                    bucket.get(i).setValue(value);
                    return ;
                }
            }
            bucket.add(new Entry(key,value));
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int hash = key%threshold;
            List<Entry> bucket = hashTable[hash];
            for(Entry entry : bucket){
                if(entry.key==key){
                    return entry.value;
                }
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int hash = key%threshold;
            List<Entry> bucket = hashTable[hash];
            for(int i=0;i<bucket.size();i++){
                if(bucket.get(i).key == key){
                    bucket.remove(i);
                }
            }
        }
    }

    public boolean isPrime(int x){
        for(int i=2;i*i<=x;i++){
            if(x%i==0) return false ;
        }
        return true;
    }

    @Test
    public void test(){
        int x = 1000;
        while(x!=0){
            if(isPrime(x)){
                System.out.println(x);
                break;
            }
            x--;
        }

    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}


