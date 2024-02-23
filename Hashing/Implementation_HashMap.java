package Hashing;
import java.util.*;

public class Implementation_HashMap {

    static class HashMap<K,V> {
        private class Node{
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
        
        private int n;  // size of keys
        private int N;  //size of the buckets 

        private LinkedList<Node> buckets[];   // N is the buckets.length

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<N; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashfunction(K key) {
            int hc = hashCode();
            return Math.abs(hc) % N;
        }

        private int searchinLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for(int i=0; i<ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key) {
                    return di;
                }
                di++;
            }

            return -1;
        }
        
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldbuck[] = buckets;
            buckets = new LinkedList[2*N];
            N = 2*N;
            for(int i=0; i<buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            for(int i=0; i<oldbuck.length; i++) {
                LinkedList<Node> ll = oldbuck[i];
                for(int j=0; j<ll.size(); i++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashfunction(key);
            int di = searchinLL(key, bi);   // valid or -1
            
            if(di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
            }

            double lamda = (double) n/N;
            if(lamda > 2.0) {
                rehash();
            }
        }

        public V remove(K key) {
            int bi = hashfunction(key);
            int di = searchinLL(key, bi);   // valid or -1
            
            if(di != -1) {
                Node node = buckets[bi].remove(di);
                return node.value;
            } else {
                return null;
            }
        } 

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<buckets.length ; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }
        
        public boolean isEmpty() {
            return n == 0;
        }

        public boolean containsKey(K key) {
            int bi = hashfunction(key);
            int di = searchinLL(key, bi);   // valid or -1
            
            if(di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V get(K key) {
            int bi = hashfunction(key);
            int di = searchinLL(key, bi);   // valid or -1
            
            if(di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }
    }
    public static void main(String args[]) {
        HashMap<String , Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("Us", 50);
        hm.put("Nepal", 5);
        System.out.println(hm);
    }
}
