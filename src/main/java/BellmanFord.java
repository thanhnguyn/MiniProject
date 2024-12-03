import java.util.*;

class BellmanFord {
    public static void findShortestPath(Graph graph, String start) {
        Map<String, Integer> distances = new HashMap<>();

        // Khởi tạo khoảng cách cho tất cả các đỉnh
        for (String node : graph.getNodes()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        // Relax edges (lặp lại |V| - 1 lần)
        for (int i = 1; i < graph.getNodes().size(); i++) {
            for (String node : graph.getNodes()) {
                for (Graph.Edge edge : graph.getEdges(node)) {
                    int newDist = distances.get(node) + edge.weight;
                    if (newDist < distances.get(edge.to)) {
                        distances.put(edge.to, newDist);
                    }
                }
            }
        }

        // Kiểm tra chu trình âm
        for (String node : graph.getNodes()) {
            for (Graph.Edge edge : graph.getEdges(node)) {
                if (distances.get(node) + edge.weight < distances.get(edge.to)) {
                    System.out.println("Graph contains a negative weight cycle.");
                    return;
                }
            }
        }

        // In kết quả
        System.out.println("Bellman-Ford Shortest Path from " + start + ": " + distances);
    }
}
