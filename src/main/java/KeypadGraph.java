import java.util.Set;
import java.util.TreeSet;

public class KeypadGraph {

  private Graph<Integer> graph;
  private StringBuilder stringBuilder = new StringBuilder();
  private Set<Integer> result = new TreeSet<>();
  private String temp = "";

  public KeypadGraph() {
    init();
  }

  private void init() {
    graph = new Graph<Integer>()
      .withVertices(0,1,2,3,4,5,6,7,8,9)
      .withEdge(1,2)
      .withEdge(1,4)
      .withEdge(2,5)
      .withEdge(2,3)
      .withEdge(3,6)
      .withEdge(4,5)
      .withEdge(4,7)
      .withEdge(5,6)
      .withEdge(5,8)
      .withEdge(6,9)
      .withEdge(7,8)
      .withEdge(5,8)
      .withEdge(8,0);
  }

  public KeypadGraph traverse(Integer root, int length){

    if (length == 1) {
      result.add(root);
      return this;
    }

    temp = String.valueOf(root);

    recursiveGetValues(root, length);
    return this;
  }

  public Set<Integer> get(){
    return result;
  }

  private void recursiveGetValues(Integer root, int length ) {

    if(length == temp.length()){
      result.add(Integer.valueOf(temp));
      return;
    }

    for (Vertex<Integer> v : graph.getAdjVertices(root)) {
      temp = temp.concat(String.valueOf(v.value));
      recursiveGetValues(v.value, length);
      temp = temp.substring(0, temp.length() -1);
    }

  }
}
