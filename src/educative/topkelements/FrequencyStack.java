package educative.topkelements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Element {
    int number;
    int frequency;
    int sequenceNumber;

    public Element(int number, int frequency, int sequenceNumber) {
        this.number = number;
        this.frequency = frequency;
        this.sequenceNumber = sequenceNumber;
    }
}

class ElementComparator implements Comparator<Element> {

    @Override
    public int compare(Element e1, Element e2) {
        if (e1.frequency != e2.frequency) {
            return e2.frequency - e1.frequency;
        }
        // if both elements have same frequency, return the one that was pushed later
        return e2.sequenceNumber - e1.sequenceNumber;
    }
}

public class FrequencyStack {
    int sequenceNumber = 0;
    PriorityQueue<Element> maxHeap = new PriorityQueue<>(new ElementComparator());
    Map<Integer, Integer> frequencyMap = new HashMap<>();

    // O(log(n)) time | O(n) space
    public void push(int num) {
        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        maxHeap.offer(new Element(num, frequencyMap.get(num), sequenceNumber++));
    }

    // O(log(n)) time | O(n) space
    public int pop() {
        int num = maxHeap.poll().number;

        if (frequencyMap.get(num) > 1) {
            frequencyMap.put(num, frequencyMap.get(num) - 1);
        } else {
            frequencyMap.remove(num);
        }
        return num;
    }

    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(3);
        frequencyStack.push(2);
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(5);
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
    }
}
