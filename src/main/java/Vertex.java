import java.util.Objects;

public class Vertex<T> {
  T value;

  public Vertex(T value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Vertex))
      return false;
    Vertex<?> vertex = (Vertex<?>) o;
    return Objects.equals(value, vertex.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
