package hard;

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {
        List<Integer> jobs = new ArrayList<>(Arrays.asList(1, 2, 3, 4)); // vertices in graph
        List<Integer[]> deps = new ArrayList<>();
        deps.add(new Integer[] {1, 2});
        deps.add(new Integer[] {1, 3});
        deps.add(new Integer[] {3, 2});
        deps.add(new Integer[] {4, 2});
        deps.add(new Integer[] {4, 3});

        topologicalSort(jobs, deps);

        // directed graph

        // 1 --> 3
        //  \   / ^
        //   v v   \
        //    2 <-- 4

        // 1 - 4: jobs with no pre-reqs
    }

    // O(j+d) time | O(j+d) space (j - jobs, d - dependencies) v + e
//    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
//        // Write your code here.
//        JobGraph jobGraph = createJobGraph(jobs, deps);
//
//        return getOrderedJobs(jobGraph);
//    }
//
//    private static List<Integer> getOrderedJobs(JobGraph graph) {
//        List<Integer> orderedJobs = new ArrayList<>();
//        List<JobNode> nodes = graph.nodes;
//        while (!nodes.isEmpty()) {
//            JobNode node = nodes.remove(nodes.size() - 1);
//            boolean containsCycle = depthFirstTraverse(node, orderedJobs);
//            if (containsCycle) {
//                return new ArrayList<>();
//            }
//        }
//        return orderedJobs;
//    }
//
//    private static boolean depthFirstTraverse(JobNode node, List<Integer> orderedJobs) {
//        if (node.visited) {
//            return false;
//        }
//        if (node.visiting) {
//            // cycle
//            return true;
//        }
//
//        node.visiting = true;
//        for (JobNode prereqNode : node.prereqs) {
//            boolean containsCycle = depthFirstTraverse(prereqNode, orderedJobs);
//            if (containsCycle) {
//                return true;
//            }
//        }
//        node.visited = true;
//        node.visiting = false;
//        orderedJobs.add(node.job);
//        return false;
//    }
//
//    private static JobGraph createJobGraph(List<Integer> jobs, List<Integer[]> deps) {
//        JobGraph graph = new JobGraph(jobs);
//        for (Integer[] element : deps) {
//            // adding edges
//            int prereq = element[0];
//            int job = element[1];
//            graph.addPrereq(job, prereq);
//        }
//        return graph;
//    }
//
//    static class JobGraph {
//        List<Integer> jobs;
//        List<JobNode> nodes;
//        Map<Integer, JobNode> graph;
//
//        public JobGraph(List<Integer> jobs) {
//            this.jobs = jobs;
//            this.nodes = new ArrayList<>();
//            this.graph = new HashMap<>();
//            for (Integer job : jobs) {
//                addNode(job);
//            }
//        }
//
//        private void addNode(Integer job) {
//            this.graph.put(job, new JobNode(job));
//            this.nodes.add(graph.get(job));
//        }
//
//        public void addPrereq(int job, int prereq) {
//            JobNode jobNode = getNode(job);
//            JobNode prereqNode = getNode(prereq);
//            jobNode.prereqs.add(prereqNode);
//        }
//
//        private JobNode getNode(int job) {
//            if (!graph.containsKey(job)) {
//                addNode(job);
//            }
//            return graph.get(job);
//        }
//    }
//
//    static class JobNode {
//        Integer job;
//        List<JobNode> prereqs;
//        boolean visited;
//        boolean visiting;
//
//        public JobNode(Integer job) {
//            this.job = job;
//            this.prereqs = new ArrayList<>();
//            this.visited = false;
//            this.visiting = false;
//        }
//    }

    // O(j+d) time | O(j+d) space (j - jobs, d - dependencies) v + e
    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        // Write your code here.
        JobGraph jobGraph = createJobGraph(jobs, deps);

        return getOrderedJobs(jobGraph);
    }

    private static List<Integer> getOrderedJobs(JobGraph graph) {
        List<Integer> orderedJobs = new ArrayList<>();
        List<JobNode> nodesWithNoPrereqs = new ArrayList<>();

        for (JobNode node : graph.nodes) {
            if (node.numOfPrereqs == 0) {
                nodesWithNoPrereqs.add(node);
            }
        }

        while (!nodesWithNoPrereqs.isEmpty()) {
            JobNode node = nodesWithNoPrereqs.remove(nodesWithNoPrereqs.size() - 1);
            orderedJobs.add(node.job);
            removeDeps(node, nodesWithNoPrereqs);
        }
        boolean graphHasEdges = false;
        for (JobNode node : graph.nodes) {
            if (node.numOfPrereqs != 0) {
                graphHasEdges = true;
                break;
            }
        }
        if (graphHasEdges) {
            return new ArrayList<>();
        }
        return orderedJobs;
    }

    private static void removeDeps(JobNode node, List<JobNode> nodesWithNoPrereqs) {
        while (!node.deps.isEmpty()) {
            JobNode dep = node.deps.remove(node.deps.size() - 1);
            dep.numOfPrereqs -= 1;
            if (dep.numOfPrereqs == 0) {
                nodesWithNoPrereqs.add(dep);
            }
        }
    }

    private static JobGraph createJobGraph(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph graph = new JobGraph(jobs);
        for (Integer[] element : deps) {
            // adding edges
            int job = element[0];
            int dep = element[1];
            graph.addDep(job, dep);
        }
        return graph;
    }

    static class JobGraph {
        List<Integer> jobs;
        List<JobNode> nodes;
        Map<Integer, JobNode> graph;

        public JobGraph(List<Integer> jobs) {
            this.jobs = jobs;
            this.nodes = new ArrayList<>();
            this.graph = new HashMap<>();
            for (Integer job : jobs) {
                addNode(job);
            }
        }

        private void addNode(Integer job) {
            this.graph.put(job, new JobNode(job));
            this.nodes.add(graph.get(job));
        }

        public void addDep(int job, int dep) {
            JobNode jobNode = getNode(job);
            JobNode depNode = getNode(dep);
            jobNode.deps.add(depNode);
            depNode.numOfPrereqs += 1;
        }

        private JobNode getNode(int job) {
            if (!graph.containsKey(job)) {
                addNode(job);
            }
            return graph.get(job);
        }
    }

    static class JobNode {
        Integer job;
        List<JobNode> deps;
        int numOfPrereqs = 0;

        public JobNode(Integer job) {
            this.job = job;
            this.deps = new ArrayList<>();
        }
    }

}
