import java.util.*;
/*
DFS to find a cycle in graph. optimize by using checked array to see if child has cycle already
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courses = new HashMap<>();
        for(int[] prereq : prerequisites) {
            courses.computeIfAbsent(prereq[0], k -> new ArrayList<>()).add(prereq[1]);
        }
        boolean[] checked = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        
        for(int i = 0; i < checked.length; ++i) {
            if(hasCycle(courses, checked, path, i)) return false;
        }
        return true;
    }
    
    private boolean hasCycle(Map<Integer, List<Integer>> courses, boolean[] checked, boolean[] path, int i) {
        if(checked[i] || !courses.containsKey(i)) return false;
        if(path[i]) return true;
        
        path[i] = true;
        
        for(int c : courses.get(i)) {
            if(hasCycle(courses, checked, path, c)) return true;
        }
        
        path[i] = false;
        checked[i] = true;
        return false;
    }
}