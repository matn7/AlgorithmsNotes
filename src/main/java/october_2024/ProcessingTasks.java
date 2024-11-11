package october_2024;

import java.util.PriorityQueue;

public class ProcessingTasks {

    public static void main(String[] args) {
        int[] servers = {3, 3, 2};
        int[] tasks = {1, 2, 3, 2, 1, 2};

        ProcessingTasks processingTasks = new ProcessingTasks();
        processingTasks.assignTasks(servers, tasks);
    }

    // leetcode 1882
    // O(mlog(n)) time | O(m) space
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Element> available = new PriorityQueue<>();
        PriorityQueue<TimeElement> unavailable = new PriorityQueue<>();
        int[] res = new int[tasks.length];

        for (int i = 0; i < servers.length; i++) {
            int serverWeight = servers[i];
            available.add(new Element(serverWeight, i));
        }

        int t = 0;
        for (int i = 0; i < tasks.length; i++) {
            t = Math.max(t, i);

            if (available.isEmpty()) {
                t = unavailable.peek().timeFree;
            }
            while (!unavailable.isEmpty() && t >= unavailable.peek().timeFree) {
                TimeElement timeElement = unavailable.poll();
                available.add(timeElement.element);
            }

            Element element = available.poll();
            res[i] = element.index;
            unavailable.add(new TimeElement(t + tasks[i], element));
        }

        return res;

    }

    static class Element implements Comparable<Element> {
        int weight;
        int index;

        public Element(int weight, int index) {
            this.weight = weight;
            this.index = index;
        }

        @Override
        public int compareTo(Element o) {
            if (weight - o.weight == 0) {
                return index - o.index;
            }
            return (weight) - (o.weight);
        }
    }

    static class TimeElement implements Comparable<TimeElement> {
        int timeFree;
        Element element;

        public TimeElement(int timeFree, Element element) {
            this.timeFree = timeFree;
            this.element = element;
        }

        @Override
        public int compareTo(TimeElement o) {
            return (timeFree) - (o.timeFree);
        }
    }

}
