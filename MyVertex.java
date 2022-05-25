import java.util.Map;

public class MyVertex<V> {
    private V data;
    private Map<MyVertex<V>, Double> adjVertices; // with weights
    private V dest;
    private double weight;

    public MyVertex(V data, V dest, Double weight) {
        this.data = data;
        this.dest = dest;
        this.weight = weight;
    }

    public void addAdjVertex(MyVertex<V> dest, double weight) {
        adjVertices.put(dest, weight);
    }
}
