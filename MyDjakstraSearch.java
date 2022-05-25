import java.util.*;

public class MyDjakstraSearch<V> extends MySearch<V> {
    private Set<V> unsettledNodes;
    private Map<V, Double> distances;
    private MyWeightedGraph<V> graph;

    public MyDjakstraSearch(MyWeightedGraph<V> graph, V source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;
        djakstra();
    }

    public void djakstra() {
        distances.put(source, 0D);
        unsettledNodes.add(source);

        while (unsettledNodes.size() > 0) {
            V node = getVertexWithMinimumWeight(unsettledNodes);
            marked.add((V) node);
            unsettledNodes.remove(node);
            for (V target : graph.adjacencyList(node)) {
                if (getShortestDistance(target) > getShortestDistance(node)
                        + getDistance(node, target)) {
                    distances.put(target, getShortestDistance(node)
                            + getDistance(node, target));
                    edgeTo.put(target, node);
                    unsettledNodes.add(target);
                }
            }
        }
    }

    private double getDistance(V node, V target) { // OWN
        Collection temp = graph.getWeight(node);
        int i = 0;
        for (MyWeightedGraph<V>.Vertex edge : graph.getEdges(node)) {
            if (edge.data.equals(target)) {
                return (double) temp.toArray()[i];
            } else {
                i++;
            }
        }
        return -1;
    }

    private V getVertexWithMinimumWeight(Set<V> vertices) {
        V minimum = null;
        for (V vertex : vertices) {
            if (minimum == null)
                minimum = vertex;
            else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum))
                    minimum = vertex;
            }
        }
        return minimum;
    }

    private double getShortestDistance(V destination) {
        Double d = distances.get(destination);
        return (d == null ? Double.MAX_VALUE : d);
    }
}
