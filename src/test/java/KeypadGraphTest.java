import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KeypadGraphTest {

  KeypadGraph classUnderTest;

  @Before
  public void setUp() throws Exception {
    classUnderTest = new KeypadGraph();
  }

  @Test
  public void when_traversing_for_one_step_then_correct() {

    Set<Integer> result = classUnderTest.traverse(5,1).get();
    assertArrayEquals( new Integer[]{5}, result.toArray());
  }

  @Test
  public void when_traversing_for_multiple_steps_then_correct() {

    Set<Integer> result = classUnderTest.traverse(1,3).get();
    assertArrayEquals( new Integer[]{121,123,125,141,145,147}, result.toArray());
    System.out.println(result);
  }
}