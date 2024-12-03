import java.util.*;

class Graph {
    private Map<String, List<Edge>> adjacencyList = new HashMap<>();

    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight) {
        adjacencyList.get(from).add(new Edge(from, to, weight));
    }

    public List<Edge> getEdges(String node) {
        return adjacencyList.getOrDefault(node, new ArrayList<>());
    }

    public Set<String> getNodes() {
        return adjacencyList.keySet();
    }

    // Định nghĩa lớp Edge bên trong Graph
    class Edge {
        String from;
        String to;
        int weight;

        Edge(String from, String to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
