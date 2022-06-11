package hard;

import java.util.*;

public class TopologicalSortREPEAT {

    public static void main(String[] args) {
        List<Integer> jobs = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer[]> deps = new ArrayList<>();
        deps.add(new Integer[]{1,2});
        deps.add(new Integer[]{1,3});
        deps.add(new Integer[]{3,2});
        deps.add(new Integer[]{4,2});
        deps.add(new Integer[]{4,3});

        List<Integer> result = topologicalSort(jobs, deps);
        System.out.println();
    }

    // jobs = [1, 2, 3, 4]
    // deps = [[1, 2], [1, 3], [3, 2], [4, 2], [4, 3]]

    //      1 ----------> 3 <----+
    //      |             |      |
    //      V             |      |
    //      2 <-----------+      |
    //      A                    |
    //      +------------------- 4
    //
    // O(j + d) time | O(j + d) time (V vertices - j (jobs), E edges- d (deps))
    // OK - repeated 29/01/2022
    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        // Write your code here.
        JobGraph jobGraph = createJobGraph(jobs, deps);
        return getOrderedJobs(jobGraph);
    }

    // jobs = [1, 2, 3, 4]
    // deps = [[1, 2], [1, 3], [3, 2], [4, 2], [4, 3]]

    //      1 ----------> 3 <----+
    //      |             |      |
    //      V             |      |
    //      2 <-----------+      |
    //      A                    |
    //      +------------------- 4
    //
    private static JobGraph createJobGraph(List<Integer> jobs, List<Integer[]> deps) {
        // jobs = [1, 2, 3, 4]
        // JobGraph
        // nodes = [(1, [], 0), (2, [], 0), (3, [], 0), (4, [], 0)]
        // graph = {
        //      1: (1, [], 0),
        //      2: (2, [], 0),
        //      3: (3, [], 0),
        //      4: (4, [], 0)
        // }

        // JobGraph
        // nodes = [(1, [(2), (3)], 0), (2, [], 3), (3, [(2)], 2), (4, [(2), (3)], 0)]
        // graph = {
        //      1: (1, [(2), (3)], 0),
        //      2: (2, [], 3),
        //      3: (3, [(2)], 2),
        //      4: (4, [(2), (3)], 0)
        // }
        JobGraph graph = new JobGraph(jobs);
        // deps = [[1, 2], [1, 3], [3, 2], [4, 2], [4, 3]]
        for (Integer[] dep : deps) {
            Integer job = dep[0]; // 1
            Integer depp = dep[1]; // 2
            graph.addDep(job, depp);
        }
        return graph;
    }

    // JobGraph
    // nodes = [(1, [(2), (3)], 0), (2, [], 3), (3, [(2)], 2), (4, [(2), (3)], 0)]
    // graph = {
    //      1: (1, [(2), (3)], 0),
    //      2: (2, [], 3),
    //      3: (3, [(2)], 2),
    //      4: (4, [(2), (3)], 0)
    // }
    private static List<Integer> getOrderedJobs(JobGraph graph) {
        // [4, 1, 3, 2]
        List<Integer> orderedJobs = new ArrayList<>();
        // []
        List<JobNode> nodesWithNoPrereqs = new ArrayList<>();
        for (JobNode node : graph.nodes) {
            if (node.numOfPrereqs == 0) {
                nodesWithNoPrereqs.add(node); // 1, 4
            }
        }

        while (!nodesWithNoPrereqs.isEmpty()) {
            // []
            JobNode node = nodesWithNoPrereqs.remove(nodesWithNoPrereqs.size() - 1); // 2
            orderedJobs.add(node.job); // 1, 4, 3, 2
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
        return orderedJobs; // [4, 1, 3, 2]
    }

    // JobGraph
    // nodes = [(1, [(2), (3)], 0), (2, [], 3), (3, [(2)], 2), (4, [(2), (3)], 0)]
    // graph = {
    //      1: (1, [], 0),
    //      2: (2, [], 0),
    //      3: (3, [], 0),
    //      4: (4, [], 0)
    // }
    private static void removeDeps(JobNode node, List<JobNode> nodesWithNoPrereqs) {
        // (2), []
        while (!node.deps.isEmpty()) {
            JobNode dep = node.deps.remove(node.deps.size() - 1); // (2)
            dep.numOfPrereqs--; // [3,0], [2,0]
            if (dep.numOfPrereqs == 0) {
                nodesWithNoPrereqs.add(dep); // 3, 2
            }
        }
    }
    // JobNode (job, deps, numOfPrereqs)
    // job = num
    // deps = []
    // numOfPrereqs = num

    // jobs = [1, 2, 3, 4]
    // JobGraph
    // nodes = [(1, [], 0), (2, [], 0), (3, [], 0), (4, [], 0)]
    // graph = {
    //      1: (1, [(2), (3)], 0),
    //      2: (2, [], 3),
    //      3: (3, [(2)], 2),
    //      4: (4, [(2), (3)], 0)
    // }
    static class JobGraph {
        List<JobNode> nodes;
        Map<Integer, JobNode> graph;

        public JobGraph(List<Integer> jobs) {
            this.nodes = new ArrayList<>();
            this.graph = new HashMap<>();

            for (Integer job : jobs) {
                addNode(job);
            }
        }

        public void addDep(Integer job, Integer dep) {
            // 4, 3
            JobNode jobNode = getNode(job); // (4)
            JobNode depNode = getNode(dep); // (3)
            jobNode.deps.add(depNode);
            depNode.numOfPrereqs++;
        }

        private void addNode(Integer job) {
            graph.put(job, new JobNode(job));
            nodes.add(graph.get(job));
        }

        private JobNode getNode(Integer job) {
            if (!graph.containsKey(job)) {
                addNode(job);
            }
            return graph.get(job);
        }
    }

    static class JobNode {
        private Integer job;
        private List<JobNode> deps;
        private Integer numOfPrereqs;

        public JobNode(Integer job) {
            this.job = job;
            this.deps = new ArrayList<>();
            this.numOfPrereqs = 0;
        }
    }

//    // O(j + d) time | O(j + d) time (V vertices - j (jobs), E edges- d (deps))
//    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
//        // Write your code here.
//        JobGraph jobGraph = createJobGraph(jobs, deps);
//        return getOrderedJobs(jobGraph);
//    }
//
//    private static JobGraph createJobGraph(List<Integer> jobs, List<Integer[]> deps) {
//        JobGraph graph = new JobGraph(jobs);
//        for (Integer[] dep : deps) {
//            Integer prereq = dep[0];
//            Integer job = dep[1];
//            graph.addPrereq(job, prereq);
//        }
//        return graph;
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
//            return true;
//        }
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
//    static class JobGraph {
//        List<JobNode> nodes;
//        Map<Integer, JobNode> graph;
//
//        public JobGraph(List<Integer> jobs) {
//            this.nodes = new ArrayList<>();
//            this.graph = new HashMap<>();
//
//            for (Integer job : jobs) {
//                addNode(job);
//            }
//        }
//
//        private void addNode(Integer job) {
//            graph.put(job, new JobNode(job));
//            nodes.add(graph.get(job));
//        }
//
//        public void addPrereq(Integer job, Integer prereq) {
//            JobNode jobNode = getNode(job);
//            JobNode prereqNode = getNode(prereq);
//            jobNode.prereqs.add(prereqNode);
//        }
//
//        private JobNode getNode(Integer job) {
//            if (!graph.containsKey(job)) {
//                addNode(job);
//            }
//            return graph.get(job);
//        }
//    }
//
//    static class JobNode {
//        private Integer job;
//        private List<JobNode> prereqs;
//        private boolean visited;
//        private boolean visiting;
//
//        public JobNode(Integer job) {
//            this.job = job;
//            this.prereqs = new ArrayList<>();
//            this.visited = false;
//            this.visiting = false;
//        }
//    }

}
