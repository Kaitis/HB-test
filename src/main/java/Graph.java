import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
class Graph<T> {
  private Map<Vertex<T>, List<Vertex<T>>> adjVertices = new HashMap<>();

  Graph<T> withVertices(T... values){
    for (T value : values)
      addVertex(value);
    return this;
  }

  Graph<T> addVertex(T value) {
    adjVertices.putIfAbsent(new Vertex(value), new ArrayList<>());
    return this;
  }

  Graph<T> removeVertex(T value) {
    Vertex<T> v = new Vertex<>(value);
    adjVertices.values()
      .stream()
      .map(e -> e.remove(v))
      .collect(Collectors.toList());
    adjVertices.remove(new Vertex(value));
    return this;
  }

  Graph<T> withEdge(T value1, T value2) {
    Vertex<T> v1 = new Vertex<>(value1);
    Vertex<T> v2 = new Vertex<>(value2);
    adjVertices.get(v1).add(v2);
    adjVertices.get(v2).add(v1);
    return this;
  }

  Graph<T> removeEdge(T value1, T value2) {
    Vertex v1 = new Vertex<>(value1);
    Vertex v2 = new Vertex<>(value2);
    List<Vertex<T>> eV1 = adjVertices.get(v1);
    List<Vertex<T>> eV2 = adjVertices.get(v2);
    if (eV1 != null)
      eV1.remove(v2);
    if (eV2 != null)
      eV2.remove(v1);
    return this;
  }

  List<Vertex<T>> getAdjVertices(T value){
    return adjVertices.get(new Vertex<>(value));
  }
}