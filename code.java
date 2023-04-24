// This code implements a depth-first search algorithm using recursion.
// The algorithm takes a graph and a source node as input and returns a list of nodes in the order they were visited.
// The algorithm works by visiting the source node and then recursively visiting all of its neighbours.
// The neighbours are visited in the order they appear in the graph dictionary.
// The algorithm keeps track of the visited nodes in a list called 'path'.
// If a node has already been visited, it is not visited again.
// If a node has no neighbours, it is considered a leaf node and the algorithm backtracks to the previous node.
// The algorithm terminates when all nodes have been visited.

import java.util.*;

public class Code {
    public static List<String> dfs_recursive(Map<String, List<String>> graph, String source, List<String> path) {
        if (!path.contains(source)) {
            path.add(source);

            if (!graph.containsKey(source)) {
                // leaf node, backtrack
                return path;
            }

            for (String neighbour : graph.get(source)) {
                path = dfs_recursive(graph, neighbour, path);
            }
        }

        return path;
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C", "D"));
        graph.put("B", Arrays.asList("E"));
        graph.put("C", Arrays.asList("G", "F"));
        graph.put("D", Arrays.asList("H"));
        graph.put("E", Arrays.asList("I"));
        graph.put("F", Arrays.asList("J"));
        graph.put("G", Arrays.asList("K"));

        List<String> dfs_element = dfs_recursive(graph, "A", new ArrayList<String>());
        System.out.println(dfs_element);
    }
}