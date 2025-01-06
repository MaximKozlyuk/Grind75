package leetcode.medium;

import java.util.*;

public class CourseSchedule {

    /**
     * https://leetcode.com/problems/course-schedule/
     *
     * [ Kahn's algorithm ](https://en.wikipedia.org/wiki/Topological_sorting#Algorithms)
     * L ← Empty list that will contain the sorted elements
     * S ← Set of all nodes with no incoming edge
     * while S is not empty do
     *     remove a node n from S
     *     add n to L
     *     for each node m with an edge e from n to m do
     *         remove edge e from the graph
     *         if m has no other incoming edges then
     *             insert m into S
     * if graph has edges then
     *     return error   (graph has at least one cycle)
     * else
     *     return L   (a topologically sorted order)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length <= 1) {
            return true;
        }

        var prerequisitesOf = new HashMap<Integer, Set<Integer>>();
        for (int[] p : prerequisites) {
            var currentPrerequisites = prerequisitesOf.get(p[0]);
            if (currentPrerequisites == null) {
                prerequisitesOf.put(
                        p[0],
                        new HashSet<>(){{
                            add(p[1]);
                        }}
                );
            } else {
                currentPrerequisites.add(p[1]);
            }
        }
        for (int i = 0; i < numCourses; i++) {
            prerequisitesOf.computeIfAbsent(i, k -> new HashSet<>());
        }

        var S = new Stack<Integer>();
        S.addAll(
                prerequisitesOf.keySet().stream()
                        .filter(k -> prerequisitesOf.get(k).isEmpty())
                        .toList()
        );

        while (!S.isEmpty()) {
            var n = S.pop();
            prerequisitesOf.remove(n);
            for (Integer k : prerequisitesOf.keySet()) {
                var currentPrerequisites = prerequisitesOf.get(k);
                currentPrerequisites.remove(n);
                if (currentPrerequisites.isEmpty()) {
                    S.add(k);
                }
            }
        }

        return prerequisitesOf.isEmpty();   // no cycles in graph
    }

}
