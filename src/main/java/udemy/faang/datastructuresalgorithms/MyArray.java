package udemy.faang.datastructuresalgorithms;

public class MyArray {

    int length;
    String[] data;

    public MyArray(int capacity) {
        this.length = 0;
        this.data = new String[capacity];
    }

    public String get(int index) {
        if (index > this.length) {
            throw new RuntimeException("Invalid Index");
        }
        return this.data[index];
    }

    public int push(String item) {
        if (this.data.length == this.length) {
            increaseArraySize();
        }
        this.data[this.length] = item;
        this.length++;
        return this.length;
    }

    private void increaseArraySize() {
        String[] newData = new String[this.data.length * 2];
        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    public String pop() {
        if (this.length == 0) {
            throw new RuntimeException("Try to remove element from empty array");
        }
        String lastData = this.data[this.length - 1];
        this.data[this.length - 1] = null;
        this.length--;
        return lastData;
    }

    public String delete(int index) {
        String toDelete = this.data[index];
        shiftItems(index);
        return toDelete;
    }

    private void shiftItems(int index) {
        for (int i = index; i < this.length - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.length--;
    }
}

class MainArray {
    public static void main(String[] args) {
        MyArray myArray = new MyArray(10);
        myArray.push("Hi");
        myArray.push("You");
        myArray.push("!");
        myArray.push("Majka"); // <--
        myArray.push("Sebastian");
        myArray.push("Puszek");
        myArray.push("Foliarz");
        myArray.push("Foliarz");
        myArray.push("Foliarz");
        myArray.push("Foliarz");
        myArray.push("Foliarz");
        myArray.push("Foliarz");
        myArray.push("Foliarz");
        myArray.delete(3);
        System.out.println();
    }
}