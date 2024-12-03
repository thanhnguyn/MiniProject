import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class UIBuilder {
    public static void setupUI(BorderPane root) {
        Button dijkstraButton = new Button("Run Dijkstra");
        Button bellmanFordButton = new Button("Run Bellman-Ford");
        Button floodingButton = new Button("Run Flooding");

        root.setTop(dijkstraButton);      // Chỉ thêm một lần vào vị trí top
        root.setLeft(bellmanFordButton);  // Chỉ thêm một lần vào vị trí left
        root.setRight(floodingButton);    // Chỉ thêm một lần vào vị trí right

        dijkstraButton.setOnAction(e -> {
            Graph graph = createSampleGraph();
            Dijkstra.findShortestPath(graph, "A");
        });

        bellmanFordButton.setOnAction(e -> {
            Graph graph = createSampleGraph();
            BellmanFord.findShortestPath(graph, "A");
        });


        floodingButton.setOnAction(e -> {
            Graph graph = createSampleGraph();
            Flooding.flood(graph, "A");
        });

//        // Optional: Add these buttons to your layout (e.g., VBox or HBox)
//        root.setTop(dijkstraButton);
//        root.setLeft(bellmanFordButton);
//        root.setRight(floodingButton);
    }

    private static Graph createSampleGraph() {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Các cạnh và trọng số (bao gồm cả trọng số âm)
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", -5);  // Trọng số âm
        graph.addEdge("C", "D", 3);
        graph.addEdge("B", "D", 1);
        return graph;
    }
}
