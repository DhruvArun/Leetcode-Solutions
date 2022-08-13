import java.util.*;

class EvaluateDivision {
    class Node {
        String key;
        double val;
        
        public Node(String k, double v) {
            key = k;
            val = v;
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        
        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet(), graph);
        }
        
        return result;
    }
    
    public double dfs(String s, String d, Set<String> visited, Map<String, List<Node>> graph) {
        if (!(graph.containsKey(s) && graph.containsKey(d))) {
            return -1.0;
        }
        
        if (s.equals(d)) {
            return 1.0;
        }
        
        visited.add(s);
        
        for (Node n : graph.get(s)) {
            if (!visited.contains(n.key)) {
                double result = dfs(n.key, d, visited, graph);
                
                if (result != -1.0) {
                    return result * n.val;
                }
            }
        }
        
        return -1.0;
    }
    
    // Builds a weighted directed graph
    public Map<String, List<Node>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Node>> graph = new HashMap<>();
        
        for (int i = 0; i < values.length; i++) {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            
            graph.putIfAbsent(src, new ArrayList());
            graph.putIfAbsent(dest, new ArrayList());
            
            graph.get(src).add(new Node(dest, values[i]));
            graph.get(dest).add(new Node(src, 1 / values[i]));
        }
        
        return graph;
    }
}
