import java.util.Map;
import java.util.Objects;

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

    public MyVertex(V data, V dest) {
        this.data = data;
        this.dest = dest;
    }

    public void addAdjVertex(MyVertex<V> dest, double weight) {
        adjVertices.put(dest, weight);
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public Map<MyVertex<V>, Double> getAdjVertices() {
        return adjVertices;
    }

    public void setAdjVertices(Map<MyVertex<V>, Double> adjVertices) {
        this.adjVertices = adjVertices;
    }

    public V getDest() {
        return dest;
    }

    public void setDest(V dest) {
        this.dest = dest;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyVertex vertex = (MyVertex) o;
        return Objects.equals(data, vertex.data) &&
                Objects.equals(dest, vertex.dest);
    }
}