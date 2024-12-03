import java.util.*;

class Dijkstra {
    public static void findShortestPath(Graph graph, String start) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        Set<String> visited = new HashSet<>();

        // Khởi tạo khoảng cách cho tất cả các đỉnh
        for (String node : graph.getNodes()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.add(new AbstractMap.SimpleEntry<>(start, 0));

        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> currentNode = pq.poll();
            String current = currentNode.getKey();

            if (visited.contains(current)) continue;
            visited.add(current);

            for (Graph.Edge edge : graph.getEdges(current)) {
                if (visited.contains(edge.to)) continue;
                int newDist = distances.get(current) + edge.weight;
                if (newDist < distances.get(edge.to)) {
                    distances.put(edge.to, newDist);
                    pq.add(new AbstractMap.SimpleEntry<>(edge.to, newDist));
                }
            }
        }

        // In kết quả
        System.out.println("Dijkstra's Shortest Path from " + start + ": " + distances);
    }
}
