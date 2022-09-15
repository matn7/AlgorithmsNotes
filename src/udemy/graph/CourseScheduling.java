package udemy.graph;

import java.util.*;

public class CourseScheduling {

    public static void main(String[] args) {
        List<String> courses = new ArrayList<>(Arrays.asList("CS101", "CS102", "CS103", "CS104", "CS105",
                "CS106", "CS107"));
        Map<String, List<String>> prereqs = new HashMap<>();
        prereqs.put("CS101", new ArrayList<>(Arrays.asList("CS102", "CS103", "CS105")));
//        prereqs.put("CS103", new ArrayList<>(Arrays.asList("CS105")));
        prereqs.put("CS104", new ArrayList<>(Arrays.asList("CS105")));
        prereqs.put("CS105", new ArrayList<>(Arrays.asList("CS107")));

        order(courses, prereqs);

    }

    public static List<String> order(List<String> courseList, Map<String, List<String>> prereqs) {
        Graph courseGraph = new AdjacencyMatrixGraph(courseList.size(), Graph.GraphType.DIRECTED);

        Map<String, Integer> courseIdMap = new HashMap<>();
        Map<Integer, String> idCourseMap = new HashMap<>();

        for (int i = 0; i < courseList.size(); i++) {
            courseIdMap.put(courseList.get(i), i);
            idCourseMap.put(i, courseList.get(i));
        }

        for (Map.Entry<String, List<String>> prereq : prereqs.entrySet()) {
            for (String course : prereq.getValue()) {
                courseGraph.addEdge(courseIdMap.get(prereq.getKey()), courseIdMap.get(course));
            }
        }

        List<Integer> courseIdList = TopologicalSort.sort(courseGraph);

        List<String> courseScheduleList = new ArrayList<>();

        for (int courseId : courseIdList) {
            courseScheduleList.add(idCourseMap.get(courseId));
        }

        return courseScheduleList;
    }

}
