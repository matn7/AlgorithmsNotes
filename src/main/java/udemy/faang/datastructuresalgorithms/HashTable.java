package udemy.faang.datastructuresalgorithms;


import java.util.ArrayList;
import java.util.List;

public class HashTable {

    List<List<Element>> data;

    public HashTable(int size) {
        this.data = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.data.add(new ArrayList<>());
        }
    }

    public List<List<Element>> set(String key, int value) {
        int address = this.hash(key);
        this.data.get(address).add(new Element(key, value));
        return this.data;
    }

    public Integer get(String key) {
        int address = this.hash(key);
        List<Element> currentBucket = this.data.get(address);
        if (!currentBucket.isEmpty()) {
            for (int i = 0; i < currentBucket.size(); i++) {
                if (currentBucket.get(i).key.equals(key)) {
                    return currentBucket.get(i).value;
                }
            }
        }
        return null;
    }

    public List<String> keys() {
        List<String> keysArray = new ArrayList<>();
        for (List<Element> element : data) {
            for (int i = 0; i < element.size(); i++) {
                keysArray.add(element.get(i).key);
            }
        }
        return keysArray;
    }


    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.charAt(i) * i) % this.data.size();
        }
        return hash;
    }
}

class Main3 {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(2);

        hashTable.set("grapes", 10000);
        hashTable.set("apples", 54);
        hashTable.set("oranges", 54);

        Integer element = hashTable.get("apples");
        List<String> keys = hashTable.keys();
        System.out.println();
    }
}

class Element {
    String key;
    int value;

    public Element(String key, int value) {
        this.key = key;
        this.value = value;
    }
}
