package whiteboard;

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {
        List<Integer> jobs = new ArrayList<>();
        jobs.add(1);
        jobs.add(2);
        jobs.add(3);
        jobs.add(4);

        List<Integer[]> deps = new ArrayList<>();
        deps.add(new Integer[]{1, 2});
        deps.add(new Integer[]{1, 3});
        deps.add(new Integer[]{3, 2});
        deps.add(new Integer[]{4, 2});
        deps.add(new Integer[]{4, 3});

        List<Integer> result = topologicalSort(jobs, deps);
        System.out.println(result);
    }

    // ********
    // * STAR - G *
    // ********

    // O(j + d) time | O(j + d) space
    // #2: 23/06/2022
    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        List<Integer> zeroInDegreeList = new ArrayList<>();

        Map<Integer, JobNode> jobGraph = createJobGraph(jobs, deps);

        for (Map.Entry<Integer, JobNode> element : jobGraph.entrySet()) {
            if (element.getValue().degree == 0) {
                zeroInDegreeList.add(element.getValue().id);
            }
        }

        while (!zeroInDegreeList.isEmpty()) {
            Integer removedElement = zeroInDegreeList.remove(zeroInDegreeList.size() - 1);
            result.add(removedElement);
            removeFromNodes(jobGraph, removedElement, jobs, zeroInDegreeList);
        }

        if (jobs.size() != result.size()) {
            return new ArrayList<>();
        }

        return result;
    }

    private static void removeFromNodes(Map<Integer, JobNode> jobGraph, Integer removedElement,
                                        List<Integer> jobs, List<Integer> zeroInDegreeList) {
        for (Integer job : jobs) {
            JobNode jobNode = jobGraph.get(job);
            if (jobNode.deps.isEmpty()) {
                continue;
            }
            jobNode.removeDependency(removedElement);
            if (jobNode.degree == 0) {
                zeroInDegreeList.add(jobNode.id);
            }
        }
    }

    private static Map<Integer, JobNode> createJobGraph(List<Integer> jobs, List<Integer[]> deps) {
        Map<Integer, JobNode> jobGraph = new HashMap<>();

        for (Integer job : jobs) {
            jobGraph.put(job, new JobNode(job, 0));
        }

        updateDependencies(jobGraph, deps);
        return jobGraph;
    }

    private static void updateDependencies(Map<Integer, JobNode> jobGraph, List<Integer[]> deps) {
        for (Integer[] dep : deps) {
            Integer source = dep[0];
            Integer destination = dep[1];
            JobNode jobNode = jobGraph.get(destination);
            jobNode.addDependency(source);
        }
    }

    static class JobNode {
        int id;
        List<Integer> deps;
        int degree;

        public JobNode(int id, int degree) {
            this.id = id;
            this.deps = new ArrayList<>();
            this.degree = degree;
        }

        public void addDependency(Integer source) {
            deps.add(source);
            degree++;
        }

        public void removeDependency(Integer removedElement) {
            if (deps.contains(removedElement)) {
                deps.remove(removedElement); // todo: might be problem here
                degree--;
            }
        }
    }

}
