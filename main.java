public class main {
    public static void main(String[] args) {
        MyWeightedGraph<String> graph = new MyWeightedGraph<>(true);

        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
        graph.addEdge("Mars", "Astana", 77.2);

        System.out.println("Dijkstra:");
        MySearch<String> djk = new MyDjakstraSearch<>(graph, "Almaty");
        outputPath(djk, "Kyzylorda");

//        System.out.println("DFS:");
//        Search<String> dfs = new DepthFirstSearch<>(graph, "Almaty");
//        outputPath(dfs, "Kyzylorda");
//
        System.out.println("\n--------------------------------");
//
        System.out.println("BFS:");
        MySearch<String> bfs = new MyBFS<>(graph, "Almaty");
        outputPath(bfs, "Kyzylorda");
    }

    public static void outputPath(MySearch<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
    }
}
